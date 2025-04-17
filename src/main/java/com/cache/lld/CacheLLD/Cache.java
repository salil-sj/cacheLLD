package com.cache.lld.CacheLLD;

import com.cache.lld.CacheLLD.evictionPolicies.EvictionPolicy;
import com.cache.lld.CacheLLD.exceptions.DataNotFoundException;
import com.cache.lld.CacheLLD.exceptions.StorageFullException;
import com.cache.lld.CacheLLD.storage.Storage;

public class Cache<Key,Value> {

    private Storage<Key,Value> storage;
    private EvictionPolicy<Key>  evictionPolicy;

    public Cache(Storage<Key, Value> storage, EvictionPolicy<Key> evictionPolicy) {
        this.storage = storage;
        this.evictionPolicy = evictionPolicy;
    }

    public void put(Key key, Value value){
        try{
            storage.put(key, value);
            evictionPolicy.keyAccessed(key);
        }
        catch(StorageFullException e){
            System.out.printf("Storage full exception: %s\n", e.getMessage());
            Key evictedKey = evictionPolicy.evict();
            storage.remove(evictedKey);
            put(key, value);
        }
    }

    public Value get(Key key){
       try{
           Value value =storage.get(key);
           evictionPolicy.keyAccessed(key);
           return value;
       }
       catch(DataNotFoundException e){
           System.out.printf("Data not found: %s\n", e.getMessage());
           return null;
       }
    }
}
