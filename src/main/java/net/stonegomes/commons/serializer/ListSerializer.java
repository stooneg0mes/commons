package net.stonegomes.commons.serializer;

import java.util.ArrayList;
import java.util.List;

public class ListSerializer<T> {

    private Serializer<T> serializer;

    public ListSerializer(Serializer<T> serializer) {
        this.serializer = serializer;
    }

    public ListSerializer(Class<?> clazz) {
        try {
            Object instance = clazz.newInstance();
            if (instance instanceof Serializer) this.serializer = (Serializer<T>) instance;
        } catch (InstantiationException | IllegalAccessException ignored) {
        }
    }


    public List<T> deserialize(String key, String delimiter) {
        List<T> list = new ArrayList<>();
        if (key.equals("Empty")) return list;

        for (String split : key.split(delimiter)) {
            list.add(serializer.deserialize(split));
        }

        return list;
    }

    public String serialize(List<T> objects, String delimiter) {
        if (objects.isEmpty()) return "Empty";

        List<String> list = new ArrayList<>();

        for (T object : objects) {
            list.add(serializer.serialize(object));
        }

        return String.join(delimiter, list);
    }

}
