package ru.afanasyev.fw.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import ru.afanasyev.adapter.AbstractMovieAdapter;
import ru.afanasyev.app.api.ServiceUnavailableException;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class AbstractMovieAdapterPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        if (!(bean instanceof AbstractMovieAdapter)) {
            return bean;
        }
        log.info("Wrapping {}", beanName);
        ClassLoader classLoader = bean.getClass().getClassLoader();
        Class<?>[] interfaces = bean.getClass().getInterfaces();
        TokenInvocationHandler invocationHandler = new TokenInvocationHandler((AbstractMovieAdapter) bean);

        return Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
    }

    static class TokenInvocationHandler implements InvocationHandler {
        private final AbstractMovieAdapter target;
        private final Map<String, Method> methods = new HashMap<>();

        public TokenInvocationHandler(AbstractMovieAdapter target) {
            this.target = target;

            for (Method method : target.getClass().getDeclaredMethods()) {
                if (Modifier.isPublic(method.getModifiers())) {
                    this.methods.put(method.getName(), method);
                }
            }
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) {
            try {
                return method.invoke(target, args);
            } catch (Exception e) {
                target.switchToken();
                try {
                    return method.invoke(target, args);
                } catch (Exception ex) {
                    throw new ServiceUnavailableException(ex);
                }
            }
        }
    }
}
