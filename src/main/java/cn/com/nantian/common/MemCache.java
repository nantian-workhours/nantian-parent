package cn.com.nantian.common;

import cn.com.nantian.service.MemCacheService;
import cn.com.nantian.service.impl.MemCacheServiceImpl;
import net.spy.memcached.MemcachedClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Set;

public class MemCache {

    private Logger logger = LoggerFactory.getLogger(MemCache.class);
    private static MemCacheService memCacheService = null;
    private static MemCache memCache = new MemCache();

    public static MemCache getInstance() {
        return memCache;
    }

    private MemCache() {
        memCacheService = MemCacheServiceImpl.getInstance();
    }

    public Object get(String key) {
        try {
            if (memCacheService != null) {
                return memCacheService.get(key);
            }
        } catch (Exception var3) {
            this.handleException(var3, key);
        }

        return null;
    }

    public boolean set(String key, Object value) {
        try {
            if (memCacheService != null) {
                return memCacheService.set(key, value);
            }
        } catch (Exception var4) {
            this.handleException(var4, key);
        }

        return false;
    }

    public Map<String, Object> getBulk(Set<String> keys) {
        try {
            if (memCacheService != null) {
                return memCacheService.getBulk(keys);
            }
        } catch (Exception var3) {
            this.handleException(var3, keys.toString());
        }

        return null;
    }

    public boolean remove(String key) {
        try {
            if (memCacheService != null) {
                return memCacheService.remove(key);
            }
        } catch (Exception var3) {
            this.handleException(var3, key);
        }

        return false;
    }

    public boolean set(String key, Object value, int exp) {
        try {
            if (memCacheService != null) {
                return memCacheService.set(key, value, exp);
            }
        } catch (Exception var5) {
            this.handleException(var5, key);
        }

        return false;
    }

    private void handleException(Exception e, String key) {
        this.logger.warn("spymemcached client receive an exception with key:" + key, e);
    }

    public MemcachedClient getMemcachedClient() {
        return memCacheService.getMemcachedClient();
    }

    public Object getAndTouch(String key, int exp) {
        return memCacheService.getAndTouch(key, exp);
    }
}
