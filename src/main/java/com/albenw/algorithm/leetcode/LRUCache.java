package com.albenw.algorithm.leetcode;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author alben.wong
 * @since 2020/11/10.
 * leetcode 146. LRU缓存机制
 */
@Slf4j
public class LRUCache {

    private LinkedHashMap<Integer, Integer> map;
    private int cacheSize;
    public LRUCache(){};
    public LRUCache(int capacity) {
        this.cacheSize = capacity;
        map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true){
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return this.size() == cacheSize + 1;
            }
        };
    }

    public int get(int key) {
        Integer integer = map.get(key);
        if(integer == null){
            return -1;
        }
        return integer;
    }

    public void put(int key, int value) {
        map.put(key, value);
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.get(1);    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.get(2);    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lRUCache.get(1);    // 返回 -1 (未找到)
        lRUCache.get(3);    // 返回 3
        lRUCache.get(4);    // 返回 4
    }

}
