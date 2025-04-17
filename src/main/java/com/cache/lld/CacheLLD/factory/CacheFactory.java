package com.cache.lld.CacheLLD.factory;

import com.cache.lld.CacheLLD.Cache;
import com.cache.lld.CacheLLD.evictionPolicies.LRUEvictionPolicy;
import com.cache.lld.CacheLLD.storage.HashMapBasedStorage;


public class CacheFactory<Key,Value> {

    public Cache<Key,Value> defaultCache(final int capacity) {
        return new Cache<Key,Value>(new HashMapBasedStorage<Key,Value>(capacity), new LRUEvictionPolicy<Key>());
    }
}
