package com.ldq.study.jedis.client;

import redis.clients.jedis.Jedis;

public class JedisClient {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1",6379);
        jedis.set("ldq", "smart");
        System.out.println("jedis.get(\"ldq\") = " + jedis.get("ldq"));
    }
}
