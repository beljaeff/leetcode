package com.github.beljaeff.leetcode.task146;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * See <a href="https://leetcode.com/problems/lru-cache/">146. LRU Cache</a>.
 * This implementation based on linked hash map.
 */
public class LRUCache2 implements LRUCache<Integer, Integer> {

    private final int capacity;

    private final LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>(16, .75f, true) {
        @Override
        protected boolean removeEldestEntry(Map.Entry eldest) {
            return size() > capacity;
        }
    };

    public LRUCache2(int capacity) {
        if (capacity < 1 || capacity > 3000) {
            throw new IllegalArgumentException("capacity should be from interval [1 .. 3000]");
        }
        this.capacity = capacity;
    }

    @Override
    public Integer get(Integer key) {
        Integer value = cache.get(key);
        return value == null ? -1 : value;
    }

    @Override
    public void put(Integer key, Integer value) {
        cache.put(key, value);
    }
}
