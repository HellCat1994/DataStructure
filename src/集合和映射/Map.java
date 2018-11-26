package 集合和映射;

public interface Map<K,V> {
    void add(K key, V value);
    void remove(K key);
    V get(K key);
    void set(K key, V value);
    boolean contains(K key);
}
