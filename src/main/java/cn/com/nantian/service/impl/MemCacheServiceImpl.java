package cn.com.nantian.service.impl;

import cn.com.nantian.common.ObjectUtils;
import cn.com.nantian.common.PropertiesReader;
import cn.com.nantian.service.MemCacheService;
import net.spy.memcached.*;
import net.spy.memcached.internal.BulkFuture;
import net.spy.memcached.internal.GetFuture;
import net.spy.memcached.internal.OperationFuture;
import net.spy.memcached.protocol.binary.BinaryOperationFactory;
import net.spy.memcached.transcoders.SerializingTranscoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.*;

public class MemCacheServiceImpl implements MemCacheService {

    public static final String CACHE_PROP_FILE = "project";
    public static final String ENCODING = "UTF-8";
    private static Logger logger = LoggerFactory.getLogger(MemCacheServiceImpl.class);
    private static ConcurrentHashMap<String, MemCacheService> flyweights = new ConcurrentHashMap();
    private MemcachedClient mc1 = null;
    private MemcachedClient mc2 = null;
    public static final int DEFAULT_MEMCACHED_TIMEOUT = 1;
    private int opTimeout = 1;
    public static final int DEFAULT_MEMCACHED_TIMEOUT_BATCH = 3;
    private int opTimeoutBulk = 3;
    public static final int DEFAULT_READBUF_SIZE = 16384;
    private int readBufSize = 16384;
    public static final int DEFAULT_OPQ_SIZE = 16384;
    private int opQueueLens = 3;
    public static final int DEFAULT_MEMCACHED_EXP_HOURS = 24;
    private int expHour = 24;
    public static final int DEFAULT_MEMCACHED_RETRY = 3;
    private int retry = 3;

    public static MemCacheService getInstance(String prop_file) {
        if (!flyweights.containsKey(prop_file)) {
            synchronized(prop_file) {
                flyweights.put(prop_file, new MemCacheServiceImpl(prop_file));
            }
        }

        return (MemCacheService)flyweights.get(prop_file);
    }

    public MemCacheServiceImpl() {
        String prop_file = "project";
        if (!flyweights.containsKey(prop_file)) {
            synchronized(prop_file) {
                flyweights.put(prop_file, new MemCacheServiceImpl(prop_file));
            }
        }

    }

    public static MemCacheService getInstance() {
        return getInstance("project");
    }

    private MemCacheServiceImpl(String prop_file) {
        String server1 = PropertiesReader.getValue(prop_file, "server1");
        String server2 = PropertiesReader.getValue(prop_file, "server2");

        try {
            this.opTimeout = Integer.parseInt(PropertiesReader.getValue(prop_file, "opTimeout"));
            this.opTimeoutBulk = Integer.parseInt(PropertiesReader.getValue(prop_file, "opTimeoutBulk"));
            this.retry = Integer.parseInt(PropertiesReader.getValue(prop_file, "retry"));
            this.readBufSize = Integer.parseInt(PropertiesReader.getValue(prop_file, "readBufSize"));
            this.opQueueLens = Integer.parseInt(PropertiesReader.getValue(prop_file, "opQueueLen"));
            this.expHour = Integer.parseInt(PropertiesReader.getValue(prop_file, "expHour"));
        } catch (Exception var7) {
            logger.error("loading properties fail, use default config!");
        }

        try {
            this.mc1 = new MemcachedClient(new DefaultConnectionFactory() {
                @Override
                public long getOperationTimeout() {
                    return (long)(MemCacheServiceImpl.this.opTimeout * 1000);
                }
                @Override
                public int getReadBufSize() {
                    return MemCacheServiceImpl.this.readBufSize;
                }
                @Override
                public OperationFactory getOperationFactory() {
                    return new BinaryOperationFactory();
                }
                @Override
                public int getOpQueueLen() {
                    return MemCacheServiceImpl.this.opQueueLens;
                }
                @Override
                public boolean isDaemon() {
                    return true;
                }
            }, AddrUtil.getAddresses(server1));
            this.mc2 = new MemcachedClient(new DefaultConnectionFactory() {
                @Override
                public long getOperationTimeout() {
                    return (long)(MemCacheServiceImpl.this.opTimeout * 1000);
                }
                @Override
                public int getReadBufSize() {
                    return MemCacheServiceImpl.this.readBufSize;
                }

                @Override
                public OperationFactory getOperationFactory() {
                    return new BinaryOperationFactory();
                }
                @Override
                public int getOpQueueLen() {
                    return this.opQueueLen;
                }
                @Override
                public boolean isDaemon() {
                    return true;
                }
            }, AddrUtil.getAddresses(server2));
        } catch (IOException var6) {
            logger.error("DefaultConnectionFactory memcache error:", var6);
        }

        SerializingTranscoder x1 = (SerializingTranscoder)this.mc1.getTranscoder();
        x1.setCharset("UTF-8");
        SerializingTranscoder x2 = (SerializingTranscoder)this.mc2.getTranscoder();
        x2.setCharset("UTF-8");
    }
    @Override
    public Object get(String key) {
        Object result = null;

        try {
            for(int i = 0; i < this.retry; ++i) {
                result = this._get(key);
                if (result != null) {
                    break;
                }

                logger.debug("get info from cache failed begin to retry " + (i + 1));
            }

            if (result == null) {
                logger.debug("[FAIL] completely failed when getting info from cache after " + this.retry + " times");
            }
        } catch (Exception var4) {
            var4.printStackTrace();
        }

        return result;
    }

    private Object _get(String key) {
        Object myObj = null;

        try {
            GetFuture f = this.mc1.asyncGet(key);

            try {
                myObj = f.get((long)this.opTimeout, TimeUnit.SECONDS);
            } catch (TimeoutException var9) {
                var9.printStackTrace();
                f.cancel(false);
            } catch (InterruptedException var10) {
                var10.printStackTrace();
                f.cancel(false);
            } catch (ExecutionException var11) {
                var11.printStackTrace();
                f.cancel(false);
            }

            if (myObj == null) {
                GetFuture f2 = this.mc2.asyncGet(key);

                try {
                    myObj = f2.get((long)this.opTimeout, TimeUnit.SECONDS);
                } catch (TimeoutException var6) {
                    var6.printStackTrace();
                    f2.cancel(false);
                } catch (InterruptedException var7) {
                    var7.printStackTrace();
                    f2.cancel(false);
                } catch (ExecutionException var8) {
                    var8.printStackTrace();
                    f2.cancel(false);
                }
            }
        } catch (Exception var12) {
            var12.printStackTrace();
        }

        if (myObj != null) {
        }

        return myObj;
    }
    @Override
    public Map<String, Object> getBulk(Set<String> keys) {
        logger.debug("[ACCESS]begin to get info from cache in bulk...");
        Map ret = null;

        try {
            BulkFuture f = this.mc1.asyncGetBulk(keys);

            try {
                ret = (Map)f.get((long)this.opTimeoutBulk, TimeUnit.SECONDS);
            } catch (TimeoutException var9) {
                logger.debug("[FAIL]time out when getting objects from cache server1...");
                f.cancel(false);
            } catch (InterruptedException var10) {
                logger.debug("[FAIL]thread been interrupted while waiting when getting object from cache server1...");
                f.cancel(false);
            } catch (ExecutionException var11) {
                logger.debug("[FAIL]exception when getting object from cache server1...");
                f.cancel(false);
            }

            if (ret == null) {
                BulkFuture f2 = this.mc2.asyncGetBulk(keys);

                try {
                    ret = (Map)f2.get((long)this.opTimeoutBulk, TimeUnit.SECONDS);
                } catch (TimeoutException var6) {
                    logger.debug("[FAIL]time out when getting objects from cache server2...");
                    f2.cancel(false);
                } catch (InterruptedException var7) {
                    logger.debug("[FAIL]thread been interrupted while waiting when getting object from cache server2...");
                    f2.cancel(false);
                } catch (ExecutionException var8) {
                    logger.debug("[FAIL]exception when getting object from cache server2...");
                    f2.cancel(false);
                }
            }
        } catch (Exception var12) {
            logger.error("[ERROR]other exception when getting objects from voo@163.com cache...", var12);
        }

        if (ret != null) {
            Iterator i$ = keys.iterator();

            while(i$.hasNext()) {
                String key = (String)i$.next();
                if (ret.get(key) != null) {
                    logger.debug("[GET]SHOOTED\tKey=" + key + "\tValue=" + ret.get(key).toString());
                }
            }
        }

        return ret;
    }
    @Override
    public boolean set(String key, Object value) {
        boolean result = false;

        for(int i = 0; i < this.retry; ++i) {
            result = this._set(key, value);
            if (result) {
                break;
            }

            logger.debug("set info into cache failed begin to retry " + i);
        }

        if (!result) {
            logger.error("[FAIL] completely failed when setting info into cache after " + this.retry + " times");
        }

        return result;
    }

    private boolean _set(String key, Object value) {
        boolean ret = false;
        Future<Boolean> f = this.mc1.set(key, this.expHour * 60 * 60, value);
        OperationFuture f2 = this.mc2.set(key, this.expHour * 60 * 60, value);

        try {
            boolean fs1 = (Boolean)f.get((long)this.opTimeout, TimeUnit.SECONDS);
            boolean fs2 = (Boolean)f2.get((long)this.opTimeout, TimeUnit.SECONDS);
            ret = fs1 || fs2;
            if (!fs1) {
                logger.debug("[FAIL]CACHE SET FAIL:server1 set failed: Key=" + key + "\tValue=" + value.toString());
            } else if (!fs2) {
                logger.debug("[FAIL]CACHE SET FAIL:server2 set failed: Key=" + key + "\tValue=" + value.toString());
            }
        } catch (TimeoutException var8) {
            logger.debug("[FAIL]time out when getting objects from cache server2...");
            f.cancel(false);
            f2.cancel(false);
        } catch (InterruptedException var9) {
            logger.error("[ERROR]exception when setting voo@163.com cache - thread been interrupted...", var9);
            f.cancel(false);
            f2.cancel(false);
        } catch (ExecutionException var10) {
            logger.error("[ERROR]exception when setting voo@163.com cache - exception when getting status...", var10);
            f.cancel(false);
            f2.cancel(false);
        } catch (Exception var11) {
            logger.error("[ERROR]exception when setting voo@163.com cache - other exceptions...", var11);
            f.cancel(false);
            f2.cancel(false);
        }

        if (value != null) {
            logger.debug("MemCacheServiceImpl.set,key=" + key + ",value=" + value.getClass());
        } else {
            logger.debug("MemCacheServiceImpl.set,key=" + key + ",value=null");
        }

        return ret;
    }
    @Override
    public boolean remove(String key) {
        boolean ret = false;
        Future<Boolean> f = this.mc1.delete(key);
        OperationFuture f2 = this.mc2.delete(key);

        try {
            ret = (Boolean)f.get((long)this.opTimeout, TimeUnit.SECONDS) && (Boolean)f2.get((long)this.opTimeout, TimeUnit.SECONDS);
        } catch (TimeoutException var6) {
            logger.debug("[FAIL]time out when getting objects from cache server2...");
            f.cancel(false);
            f2.cancel(false);
        } catch (InterruptedException var7) {
            logger.error("[ERROR]exception when deleting voo@163.com cache - thread been interrupted...", var7);
            f.cancel(false);
            f2.cancel(false);
            ret = false;
        } catch (ExecutionException var8) {
            logger.error("[ERROR]exception when deleting voo@163.com cache - exception when getting status...", var8);
            f.cancel(false);
            f2.cancel(false);
            ret = false;
        } catch (Exception var9) {
            logger.error("[ERROR]exception when deleting voo@163.com cache - other exceptions...", var9);
            f.cancel(false);
            f2.cancel(false);
            ret = false;
        }

        logger.debug("[REMOVE]" + ret + "\tKey=" + key);
        return ret;
    }
    @Override
    public boolean set(String key, Object value, int exp) {
        if (value == null) {
            return false;
        } else {
            boolean ret = false;
            Future<Boolean> f = this.mc1.set(key, exp, value);
            OperationFuture f2 = this.mc2.set(key, exp, value);

            try {
                boolean fs1 = (Boolean)f.get((long)this.opTimeout, TimeUnit.SECONDS);
                boolean fs2 = (Boolean)f2.get((long)this.opTimeout, TimeUnit.SECONDS);
                ret = fs1 || fs2;
                if (!fs1) {
                    logger.debug("[FAIL]CACHE SET FAIL:server1 set failed: Key=" + key + ",Value=" + value.toString());
                } else if (!fs2) {
                    logger.debug("[FAIL]CACHE SET FAIL:server2 set failed: Key=" + key + ",Value=" + value.toString());
                }
            } catch (Exception var9) {
                if (!"LOGIN_IP".equalsIgnoreCase(key)) {
                    logger.debug("MemCacheServiceImpl.set,key=" + key + ",value=" + value + ",Exception");
                }

                var9.printStackTrace();
                f.cancel(false);
                f2.cancel(false);
            }

            logger.debug("MemCacheServiceImpl.set,key=" + key + ",value=" + value.getClass());
            return ret;
        }
    }
    @Override
    public MemcachedClient getMemcachedClient() {
        return ObjectUtils.isNotNull(this.mc1) ? this.mc1 : this.mc2;
    }
    @Override
    public Object getAndTouch(String key, int exp) {
        Object result = null;

        try {
            CASValue casValue = this.mc1.getAndTouch(key, exp);
            if (casValue != null) {
                result = casValue.getValue();
            }

            if (result == null) {
                casValue = this.mc2.getAndTouch(key, exp);
                if (casValue != null) {
                    result = casValue.getValue();
                }
            }

            if (result == null) {
                logger.debug("[FAIL] completely failed when getAndTuch  from cache after " + this.retry + " times");
            }
        } catch (Exception var5) {
            logger.error("[FAIL] completely failed when getAndTuch  from cache after ", var5);
        }

        return result;
    }
}
