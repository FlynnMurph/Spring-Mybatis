package com.biz.zq.redis;


import java.util.Map;

/**
 * 基础redis操作类
 * @author ZhengQin
 */
public interface CommonJedisRedis {
    /**
     * 返回hash结构的某个field的值
     * @param key
     * @param field
     * @return
     */
    byte[] hget(String key, String field);

    /**
     * 对hash结构某个字段赋值
     * @param key
     * @param field
     * @param value
     * @return
     */
    long hset(String key, String field, byte[] value);

    /**
     * 对hash的多个field赋值
     * @param key
     * @param hash
     * @return
     */
    String hmset(String key, Map<byte[], byte[]> hash);

}
