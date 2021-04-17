package net.stonegomes.commons.dao.provider;

import net.stonegomes.commons.dao.Dao;

import java.util.HashMap;
import java.util.Map;

public class DaoProvider {

    private static final Map<Class<?>, Dao<?, ?>> elements = new HashMap<>();

    public static void register(Dao<?, ?> dao) {
        elements.put(dao.getClass(), dao);
    }

    public Dao<?, ?> provide(Class<?> clazz) {
        if (elements.containsKey(clazz)) return elements.get(clazz);

        try {
            if (clazz.isAssignableFrom(Dao.class)) {
                elements.put(clazz, (Dao<?, ?>) clazz.newInstance());
            }
        } catch (InstantiationException | IllegalAccessException exception) {
            return null;
        }

        return null;
    }

}
