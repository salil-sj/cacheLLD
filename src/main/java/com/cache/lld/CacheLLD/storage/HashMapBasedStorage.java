package com.cache.lld.CacheLLD.storage;

import com.cache.lld.CacheLLD.exceptions.DataNotFoundException;
import com.cache.lld.CacheLLD.exceptions.StorageFullException;

import java.util.HashMap;
import java.util.Map;

public class HashMapBasedStorage<Key,Value> implements Storage<Key,Value> {

    private Map<Key,Value> map;
    private int capacity;

    public HashMapBasedStorage(int capacity) {
        this.map = new HashMap<>();
        this.capacity = capacity;
    }

    @Override
    public void put(Key key, Value value) {
        if(isStorageFull()){
            throw new StorageFullException("Storage full");
        }
        map.put(key, value);
    }

    @Override
    public Value get(Key key) {
        if(!map.containsKey(key)){
            throw new DataNotFoundException("Data not found");
        }
        return map.get(key);
    }

    @Override
    public void remove(Key key) {
        if(!map.containsKey(key)){
            throw new DataNotFoundException("Key not found");
        }
        map.remove(key);
    }

    private boolean isStorageFull(){
        return map.size() == capacity;
    }
}
