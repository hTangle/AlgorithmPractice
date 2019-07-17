package com.nevergetme.algorithmCompetition.second;

import java.util.LinkedHashMap;

class LRUCache {
    private int capacity;
    private LinkedHashMap<Integer,Integer> map;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        this.map=new LinkedHashMap<>();
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        int value=map.remove(key);
        map.put(key,value);
        return value;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.remove(key);
        }else if(map.size()==capacity){
            map.remove(map.entrySet().iterator().next().getKey());
        }
        map.put(key,value);
    }
}