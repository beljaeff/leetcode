package com.github.beljaeff.leetcode.task146;

import org.junit.jupiter.api.DisplayName;

@DisplayName("#146 LRU Cache (solution1 - linked hash map)")
class LRUCache2Test extends LRUCacheTest {

    @Override
    LRUCache<Integer, Integer> getCache(int capacity) {
        return new LRUCache2(capacity);
    }
}
