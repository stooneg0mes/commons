package net.stonegomes.commons.dao;

import java.util.Collection;

public interface Dao<K, V> {

    void replace(V value);

    void delete(K key);

    V find(K key);

    Collection<V> find();

}
