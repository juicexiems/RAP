package com.taobao.rigel.rap.common.utils;


import com.taobao.rigel.rap.common.config.SystemConstant;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;

class JedisFactory {
    private static JedisPool jedisPool;
    private static JedisFactory instance = null;

    public JedisFactory() {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxWaitMillis(3000);
        String host = SystemConstant.getConfig("redis.host");
        int port = Integer.parseInt(SystemConstant.getConfig("redis.port"));
        jedisPool = new JedisPool(poolConfig, host, port, 3000);
    }

    public JedisPool getJedisPool() {
        return jedisPool;
    }

    public static JedisFactory getInstance() throws IOException {

        if (instance == null) {
            instance = new JedisFactory();
        }
        return instance;
    }
}

