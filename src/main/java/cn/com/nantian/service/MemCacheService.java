package cn.com.nantian.service;

import net.spy.memcached.MemcachedClient;

import java.util.Map;
import java.util.Set;

public interface MemCacheService {

    Object get(String var1);

    boolean set(String var1, Object var2);

    Map<String, Object> getBulk(Set<String> var1);

    boolean remove(String var1);

    boolean set(String var1, Object var2, int var3);

    MemcachedClient getMemcachedClient();

    Object getAndTouch(String var1, int var2);
}
