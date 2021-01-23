package net.stonegomes.commons.serializer;

public interface Serializer<K, V> {

    K serialize(V value);

    V deserialize(K key);

}
