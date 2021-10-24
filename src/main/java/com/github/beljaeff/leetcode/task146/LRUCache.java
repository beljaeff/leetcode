package com.github.beljaeff.leetcode.task146;

public interface LRUCache<K, V> {
    V get(K key);
    void put(K key, V value);
}
