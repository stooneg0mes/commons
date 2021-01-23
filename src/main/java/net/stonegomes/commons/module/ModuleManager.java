package net.stonegomes.commons.module;

import net.stonegomes.commons.module.annotation.Module;
import net.stonegomes.commons.module.annotation.cycle.Disable;
import net.stonegomes.commons.module.annotation.cycle.Enable;
import org.reflections8.Reflections;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class ModuleManager {

    private static final Reflections REFLECTIONS = new Reflections();

    public static void load() {
        invokeMethodsByAnnotation(Enable.class);
    }

    public static void unload() {
        invokeMethodsByAnnotation(Disable.class);
    }

    private static void invokeMethodsByAnnotation(Class<? extends Annotation> annotationClass) {
        for (Class<?> clazz : REFLECTIONS.getTypesAnnotatedWith(Module.class)) {
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
