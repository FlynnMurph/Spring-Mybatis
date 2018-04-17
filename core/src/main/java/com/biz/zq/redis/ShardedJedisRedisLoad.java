package com.biz.zq.redis;

import com.google.common.collect.Lists;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedisPool;

import java.util.List;

/**
 * 初始化redis连接池
 * @author ZhengQin
 */
public class ShardedJedisRedisLoad {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShardedJedisRedisLoad.class);

    private static ShardedJedisPool shardedJedisPool;

    /**
     *
     * @param redisConfigPath redis配置properties文件路径
     * @return
     */
    synchronized public static ShardedJedisPool getJedisPool(String redisConfigPath) {

        if (shardedJedisPool == null) {
            PropertiesConfiguration configuration = null;

            try {
                if (StringUtils.isNotEmpty(redisConfigPath)) {
                    //configuration = new PropertiesConfiguration(redisConfigPath);
                    configuration = new PropertiesConfiguration("connection/redis.properties");
                }
            } catch (Exception e) {
                e.printStackTrace();

            }
            //该类用来设置连接池的最大连接数等配置
            GenericObjectPoolConfig redisConfig = new GenericObjectPoolConfig();

            //todo 暂时只设置一个redis地址  多个redis可以以分隔符来分割
            String hosts = configuration.getString("redis.host");
            String port = configuration.getString("redis.port");
            String name = configuration.getString("redis.name");
            String password = configuration.getString("redis.password");

            int nowPort = Integer.valueOf(port);

            List<JedisShardInfo> jedisShardInfoList = Lists.newArrayList();

            //超时时间暂设定为3s  讲道理这个也应该是可配置的
            JedisShardInfo jedisShardInfo = null;
            if (StringUtils.isNotEmpty(name)) {
                jedisShardInfo = new JedisShardInfo(hosts, nowPort, 3000, name);
            } else {
                jedisShardInfo = new JedisShardInfo(hosts, nowPort, 3000);
            }

            jedisShardInfo.setPassword(password);

            jedisShardInfoList.add(jedisShardInfo);

            shardedJedisPool = new ShardedJedisPool(redisConfig, jedisShardInfoList);
        }
        return shardedJedisPool;
    }
}
