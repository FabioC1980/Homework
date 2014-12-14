package fm.ask.homework.cache;

import static org.junit.Assert.*;

import org.junit.Test;

import fm.ask.homework.cache.Cache;
import fm.ask.homework.cache.LruFixedSizeCache;

public class LruFixedSizeCacheTest {

    @Test
    public void putAndThenGet() {
        Cache<String, String> cache = new LruFixedSizeCache<String, String>(2);
        cache.put("1", "1");
        cache.put("2", "2");
        assertEquals("1", cache.get("1"));
        assertEquals("2", cache.get("2"));
    }

    @Test
    public void eldestEntryRemovedWhenMaxSizeExceeded() {
        Cache<String, String> cache = new LruFixedSizeCache<String, String>(2);
        cache.put("1", "1");
        cache.put("2", "2");
        cache.put("3", "3");

        assertNull(cache.get("1"));
        assertEquals("2", cache.get("2"));
        assertEquals("3", cache.get("3"));
    }

}