package com.yukicris.Redis.LearnNote4;

import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

public class Nosql18 {

    // 事务

    public static void main(String[] args) {
        Jedis jedis = new Jedis("",6379);


        JSONObject jsonObject = new JSONObject();
        jsonObject.put("hello","world");
        jsonObject.put("name","yukicris");

        // 开启事务
        Transaction multi = jedis.multi();
        String result = jsonObject.toJSONString();

        try {
            // 如果要加监控,就加watchkey
            // jedis.watch("user1");
            multi.set("user1",result);
            multi.set("user2",result);
            //int i = 1/0; // 代码抛出异常 ,放弃事务
            multi.exec();
        } catch (Exception e) {
            multi.discard();// 放弃事务
            e.printStackTrace();
        }finally {
            System.out.println(jedis.get("user1"));
            System.out.println(jedis.get("user2"));
            //关闭连接
            jedis.close();
        }
    }
}
