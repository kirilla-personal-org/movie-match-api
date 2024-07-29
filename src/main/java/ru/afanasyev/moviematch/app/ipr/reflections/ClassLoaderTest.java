package ru.afanasyev.moviematch.app.ipr.reflections;

import lombok.SneakyThrows;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;

public class ClassLoaderTest {
    @SneakyThrows
    public static void main(String[] args) {
        CustomClassLoader customClassLoader = new CustomClassLoader();
        String className = "ru.alfabank.factoring.clients.domain.Address";

        Class<?> clazz = customClassLoader.loadClass(className);
        Object instance = ReflectionUtils.accessibleConstructor(clazz).newInstance();

        System.out.println(clazz.getClassLoader().getName());
        Field field = ReflectionUtils.findField(clazz, "id");
        ReflectionUtils.makeAccessible(field);
        ReflectionUtils.setField(field, instance, Long.valueOf(10L));
        System.out.println(ReflectionUtils.getField(field, instance));
    }
}
