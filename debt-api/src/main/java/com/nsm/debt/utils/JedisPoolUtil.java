package com.nsm.debt.utils;

import java.io.IOException;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPoolUtil {
	private static JedisPoolConfig c=new JedisPoolConfig();
	private static JedisPool jedisPool=null;
	static {
		// c.setBlockWhenExhausted(true); // 连接耗尽则阻塞
		c.setLifo(true); // 后进先出
		c.setMaxIdle(10); // 最大空闲连接数为10
		c.setMinIdle(0); // 最小空闲连接数为0
		c.setMaxTotal(100); // 最大连接数为100
		c.setMaxWaitMillis(-1); // 设置最大等待毫秒数：无限制
		c.setMinEvictableIdleTimeMillis(180); // 逐出连接的最小空闲时间：30分钟
		c.setTestOnBorrow(true); // 获取连接时是否检查连接的有效性：是
		c.setTestWhileIdle(true); // 空闲时是否检查连接的有效性：是
		try {
			jedisPool=new JedisPool(c, MyPropertiesUtil.getProperty("redis.properties", "url"),6379);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Jedis getJedis() {
		return jedisPool.getResource();
	}
}