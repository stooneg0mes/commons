package net.stonegomes.commons.cache;

import com.google.common.collect.ImmutableSet;
import lombok.Getter;

import java.util.*;
import java.util.function.Predicate;

public class SingleCache<T> {

    @Getter
    private final Set<T> elements = new HashSet<>();

    public boolean containsKey(T key) {
        return elements.contains(key);
    }

    public void addElement(T value) { elements.add(value); }

    public T find(Predicate<T> predicate) {
        for (T value : elements) {
            if (predicate.test(value)) return value;
        }

        return null;
    }

    public Collection<T> getElements() {
        return elements;
    }

    public Set<T> toImmutable() {
        return ImmutableSet.copyOf(elements);
    }

    public Iterator<T> iterator() {
        return elements.iterator();
    }

    public int size() {
        return elements.size();
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

}
