package com.github.beljaeff.leetcode.task146;

import java.util.HashMap;
import java.util.Map;

/**
 * See <a href="https://leetcode.com/problems/lru-cache/">146. LRU Cache</a>.
 * This implementation based on hash map with values forming linked list
 * sorted from the last used item at the head to the least used item at
 * the tail.
 */
public class LRUCache1 implements LRUCache<Integer, Integer> {

    private final int capacity;

    private final Map<Integer, CacheItem<Integer, Integer>> cache = new HashMap<>();

    /**
     * Head always contains the last used cache item
     */
    private CacheItem<Integer, Integer> head;

    /**
     * Tail always contains the least recently used cache
     */
    private CacheItem<Integer, Integer> tail;

    public LRUCache1(int capacity) {
        if (capacity < 1 || capacity > 3000) {
            throw new IllegalArgumentException("capacity should be from interval [1 .. 3000]");
        }
        this.capacity = capacity;
    }

    /**
     * Returns the value for given key.
     * @param key cache key
     * @return the value of the key if the key exists, otherwise return -1.
     */
    @Override
    public Integer get(Integer key) {
        CacheItem<Integer, Integer> item = cache.get(key);
        if (item == null) {
            return -1;
        }
        moveToHead(item);
        return item.getValue();
    }

    /**
     * Updates the value of the key if the key exists.
     * Otherwise, adds the key-value pair to the cache.
     * If the number of keys exceeds the capacity from
     * this operation, evict the least recently used key.
     * @param key cache key
     * @param value value for given key
     */
    @Override
    public void put(Integer key, Integer value) {
        if (this.cache.size() == 0) {
            putIfEmpty(key, value);
            return;
        }

        CacheItem<Integer, Integer> item = this.cache.get(key);
        if (item == null) {
            item = new CacheItem<>(key, value);
            setAsHead(item);
        }
        else {
            item.setValue(value);
            moveToHead(item);
        }
        this.cache.put(key, item);

        if (this.cache.size() > this.capacity) {
            removeTail();
        }
    }

    private void putIfEmpty(int key, int value) {
        CacheItem<Integer, Integer> item = new CacheItem<>(key, value);
        this.head = item;
        this.tail = item;
        this.cache.put(key, item);
    }

    private void setAsHead(CacheItem<Integer, Integer> item) {
        this.head.setNext(item);
        item.setPrev(this.head);
        this.head = item;
    }

    private void moveToHead(CacheItem<Integer, Integer> item) {
        if (cache.size() == 1 || item == this.head) {
            return;
        }

        if (item == this.tail) { // when tail
            this.tail = this.tail.getNext();
            this.tail.setPrev(null);
        }
        else { // when item somewhere in the middle - not in the tail and not in the head
            item.getPrev().setNext(item.getNext());
            item.getNext().setPrev(item.getPrev());
        }
        setAsHead(item);
    }

    private void removeTail() {
        if (this.cache.size() > this.capacity) {
            int tailKey = this.tail.getKey();
            this.tail = this.tail.getNext();
            this.tail.setPrev(null);
            this.cache.remove(tailKey);
        }
    }

    private static class CacheItem<K, V> {
        private CacheItem<K, V> prev;
        private CacheItem<K, V> next;

        // TODO: this value also contains as key inside LRUCache#cache
        private final K key;
        private V value;

        public CacheItem(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public CacheItem<K, V> getPrev() {
            return prev;
        }

        public void setPrev(CacheItem<K, V> prev) {
            this.prev = prev;
        }

        public CacheItem<K, V> getNext() {
            return next;
        }

        public void setNext(CacheItem<K, V> next) {
            this.next = next;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}
