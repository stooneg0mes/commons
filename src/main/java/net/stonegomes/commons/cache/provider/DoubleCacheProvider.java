package net.stonegomes.commons.cache.provider;

import net.stonegomes.commons.cache.DoubleCache;

import java.util.HashMap;
import java.util.Map;

public class DoubleCacheProvider {

    private static final Map<Class<?>, DoubleCache<?, ?>> elements = new HashMap<>();

    public static void register(DoubleCache<?, ?> doubleCache) {
        elements.put(doubleCache.getClass(), doubleCache);
    }

    public DoubleCache<?, ?> provide(Class<?> clazz) {
        if (elements.containsKey(clazz)) return elements.get(clazz);

        try {
            if (clazz.isAssignableFrom(DoubleCache.class)) {
                elements.put(clazz, (DoubleCache<?, ?>) clazz.newInstance());
            }
        } catch (InstantiationException | IllegalAccessException exception) {
            return null;
        }

        return null;
    }

}
