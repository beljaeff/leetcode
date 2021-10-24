package com.github.beljaeff.leetcode.task146;

import org.junit.jupiter.api.DisplayName;

@DisplayName("#146 LRU Cache (solution1 - hash map)")
class LRUCache1Test extends LRUCacheTest {

    @Override
    LRUCache<Integer, Integer> getCache(int capacity) {
        return new LRUCache1(capacity);
    }
}
