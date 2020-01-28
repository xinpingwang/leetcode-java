package com.xinping.leetcode.solutions;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private final Map<Integer, Integer> map;
    private final int[] freq;
    private int size = 0;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.freq = new int[capacity];
    }

    public int get(int key) {
        if (!this.map.containsKey(key)) {
            return -1;
        }
        moveToFirst(this.freq, key);
        return this.map.get(key);
    }

    public void put(int key, int value) {
        // the key already exists, update value and freq
        if (this.map.containsKey(key)) {
            this.map.put(key, value);
            moveToFirst(this.freq, key);
            return;
        }
        // need to remove
        if (this.size == this.freq.length) {
            this.map.remove(this.freq[size - 1]);
            this.freq[size - 1] = key;
            size--;
        }
        this.map.put(key, value);
        this.freq[size] = key;
        moveToFirst(this.freq, key);
        size++;
    }

    private void moveToFirst(int[] array, int key) {
        int keyIndex = 0;
        while (array[keyIndex] != key) {
            keyIndex++;
        }
        for (int i = keyIndex; i > 0; i--) {
            array[i] = array[i - 1];
        }
        array[0] = key;
    }
}
