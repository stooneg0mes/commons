package net.stonegomes.commons.cache.provider;

import net.stonegomes.commons.cache.SingleCache;

import java.util.HashMap;
import java.util.Map;

public class SingleCacheProvider {

    private static final Map<Class<?>, SingleCache<?>> elements = new HashMap<>();

    public static void register(SingleCache<?> singleCache) {
        elements.put(singleCache.getClass(), singleCache);
    }

    public SingleCache<?> provide(Class<?> clazz) {
        if (elements.containsKey(clazz)) return elements.get(clazz);

        try {
            if (clazz.isAssignableFrom(SingleCache.class)) {
                elements.put(clazz, (SingleCache<?>) clazz.newInstance());
            }
        } catch (InstantiationException | IllegalAccessException exception) {
            return null;
        }

        return null;
    }

}
