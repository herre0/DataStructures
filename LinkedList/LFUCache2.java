package com.mert.LinkedList;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class LFUCache2 {
    // key -> value
    HashMap<Integer, Integer> cache;
    // key -> count
    HashMap<Integer, Integer> keyToCount;
    // count -> [keys]
    HashMap<Integer, LinkedHashSet<Integer>> freqMap;

    int min;
    int capacity;

    public LFUCache2(int capacity) {
        min = -1;
        this.capacity = capacity;

        cache = new HashMap();
        keyToCount = new HashMap();
        freqMap = new HashMap();
    }

    public int get(int key) {
        if (!cache.containsKey(key))
            return -1;

        int count = keyToCount.get(key);
        freqMap.get(count).remove(key);
        if (count == min && freqMap.get(count).size() == 0)
            min++;

        keyToCount.put(key, count + 1);
        if (!freqMap.containsKey(count + 1))
            freqMap.put(count + 1, new LinkedHashSet());

        freqMap.get(count + 1).add(key);
        return cache.get(key);
    }

    public void put(int key, int value) {
        if (capacity <= 0)
            return;

        if(cache.containsKey(key)) {
            cache.put(key, value);
            get(key);
            return;
        }

        // remove lru
        if(cache.size() == capacity) {
            int lruKey = freqMap.get(min).iterator().next();
            cache.remove(lruKey);
            keyToCount.remove(lruKey);
            freqMap.get(min).remove(lruKey);
        }

        int min = 1;
        cache.put(key, value);
        keyToCount.put(key, min);
        if(!freqMap.containsKey(min))
            freqMap.put(min, new LinkedHashSet());

        freqMap.get(min).add(key);
    }

    public static void main(String[] args) {
        LFUCache2 lfu = new LFUCache2(2);
        lfu.put(1, 1);
        lfu.put(2, 2);
        lfu.get(1);
        lfu.put(3, 3);
        lfu.get(2);
        lfu.get(3);
        lfu.put(4, 4);
        lfu.get(1);
        lfu.get(3);
        lfu.get(4);
    }

}