package net.stonegomes.commons.replacer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Map.Entry;

public class Replacer {

    private Map<String, String> replaceElements = new HashMap<>();

    public Replacer(String key, Object value) {
        addElement(key, value);
    }

    public Replacer addElement(String key, Object value) {
        replaceElements.put(key, value.toString());

        return this;
    }

    public String apply(String string) {
        for (Entry<String, String> replaceElement : replaceElements.entrySet()) {
            string.replace(replaceElement.getKey(), replaceElement.getValue());
        }

        return string;
    }

    public List<String> apply(List<String> list) {
        for (Entry<String, String> replaceElement : replaceElements.entrySet()) {
            list.replaceAll(string -> string.replace(replaceElement.getKey(), replaceElement.getValue()));
        }

        return list;
    }

}
