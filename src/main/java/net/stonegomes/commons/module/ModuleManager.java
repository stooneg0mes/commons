package net.stonegomes.commons.module;

import net.stonegomes.commons.module.annotation.cycle.Disable;
import net.stonegomes.commons.module.annotation.cycle.Enable;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class ModuleManager {

    public static void load(Class[] classes) {
        invokeMethodsByAnnotation(Enable.class, classes);
    }

    public static void unload(Class[] classes) {
        invokeMethodsByAnnotation(Disable.class, classes);
    }

    private static void invokeMethodsByAnnotation(Class<? extends Annotation> annotationClass, Class[] classes) {
        if (classes == null) return;

        for (Class<?> clazz : classes) {
            Set<Method> filteredMethods = Arrays.stream(clazz.getDeclaredMethods())
                .filter(method -> method.isAnnotationPresent(annotationClass))
                .collect(Collectors.toSet());

            for (Method method : filteredMethods) {
                Object[] parameters = Arrays.stream(method.getParameters()).toArray();

                try {
                    method.invoke(method.getDeclaringClass().newInstance(), parameters);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        }
    }

}
