package com.ritwik.EmployeeService.cacheStores;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.TimeUnit;

/**
 * This class will be used for caching the data in K,V format
 */

public class CacheStore<T> {

    private Cache<Integer, T> cache;

    public CacheStore(int ttl, TimeUnit timeUnit) {
        cache = CacheBuilder.
                newBuilder().expireAfterWrite(ttl, timeUnit)
                .concurrencyLevel(Runtime.getRuntime().availableProcessors())
                .build();
    }

    public T get(int key) {
        return cache.getIfPresent(key);
    }

    public void add(int key, T value) {
        if(key >= 0 && value != null) {
            cache.put(key, value);
        }
    }
}
