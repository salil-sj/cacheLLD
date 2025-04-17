package com.cache.lld.CacheLLD.evictionPolicies;

public interface EvictionPolicy<Key> {

    public void keyAccessed(Key key);
    public Key evict();
}
