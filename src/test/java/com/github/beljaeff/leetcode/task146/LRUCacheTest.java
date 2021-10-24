package com.github.beljaeff.leetcode.task146;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

abstract class LRUCacheTest {

    private final LRUCache<Integer, Integer> cache = getCache(2);

    abstract LRUCache<Integer, Integer> getCache(int capacity);

    @Test
    void test() {
        Integer actual;

        cache.put(1, 1);          // cache is {1=1}
        cache.put(2, 2);          // cache is {1=1, 2=2}

        actual = cache.get(1);    // return 1
        Assertions.assertEquals(1, actual);

        cache.put(3, 3);          // LRU key was 2, evicts key 2, cache is {1=1, 3=3}

        actual = cache.get(2);    // returns -1 (not found)
        Assertions.assertEquals(-1, actual);

        cache.put(4, 4);          // LRU key was 1, evicts key 1, cache is {4=4, 3=3}

        actual = cache.get(1);    // return -1 (not found)
        Assertions.assertEquals(-1, actual);

        actual = cache.get(3);    // return 3
        Assertions.assertEquals(3, actual);

        actual = cache.get(4);    // return 4
        Assertions.assertEquals(4, actual);
    }
}
