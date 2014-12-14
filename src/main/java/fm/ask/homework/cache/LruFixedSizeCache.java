package fm.ask.homework.cache;

import com.googlecode.concurrentlinkedhashmap.ConcurrentLinkedHashMap;

public class LruFixedSizeCache<K, V> implements Cache<K, V> {

    private final ConcurrentLinkedHashMap<K, V> cache;

    public LruFixedSizeCache(int maxEntries) {
        cache = new ConcurrentLinkedHashMap.Builder<K, V>()
                .maximumWeightedCapacity(maxEntries)
                .build();
    }

    @Override
    public V get(K key) {
        return cache.get(key);
    }

    @Override
    public void put(K key, V value) {
        cache.put(key, value);
    }

}
