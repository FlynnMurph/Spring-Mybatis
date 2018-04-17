package com.biz.zq.redis;

import com.biz.zq.BaseRedisObject;

import java.util.Map;

/**
 * redis公共基础类 所有redis操作类都要继承该类
 */
public class ShaededCommonJedisRedis<T extends BaseRedisObject> implements CommonJedisRedis{

    @Override
    public byte[] hget(String key, String field) {
        return new byte[0];
    }

    @Override
    public long hset(String key, String field, byte[] value) {
        return 0;
    }

    @Override
    public String hmset(String key, Map<byte[], byte[]> hash) {
        return null;
    }


}
