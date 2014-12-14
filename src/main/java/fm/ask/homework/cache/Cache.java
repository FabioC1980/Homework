package fm.ask.homework.cache;

public interface Cache<K, V> {

    public V get(K key);

    public void put(K key, V value);

}