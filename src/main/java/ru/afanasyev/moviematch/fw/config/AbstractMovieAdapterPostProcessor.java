package ru.afanasyev.moviematch.fw.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import ru.afanasyev.moviematch.adapter.AbstractMovieAdapter;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.HashSet;
import java.util.Set;

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
        private final Set<String> methods = new HashSet<>();

        public TokenInvocationHandler(AbstractMovieAdapter target) {
            this.target = target;

            for (Method method : target.getClass().getDeclaredMethods()) {
                if (Modifier.isPublic(method.getModifiers())) {
                    this.methods.add(method.getName());
                }
            }
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Exception {
            try {
                return method.invoke(target, args);
            } catch (Exception e) {
                if (methods.contains(method.getName())) {
                    log.info("Error occurred. Switching token. Reason: {}", e.getMessage());
                    target.switchToken();
                    return method.invoke(target, args);
                } else {
                    throw e;
                }
            }
        }
    }
}
