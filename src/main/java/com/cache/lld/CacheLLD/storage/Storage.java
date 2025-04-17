package com.cache.lld.CacheLLD.storage;

import java.security.Key;

public interface Storage<Key,Value> {

    public void put(Key key, Value value);
    public Value get(Key key);
    public void remove(Key key);
}
