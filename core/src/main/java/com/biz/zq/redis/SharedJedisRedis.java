package com.biz.zq.redis;

import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.ShardedJedisPool;

import java.util.Map;

public class SharedJedisRedis implements CommonJedisRedis{

    @Autowired
    private ShardedJedisPool shardedJedisPool;

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
