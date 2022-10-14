package com.yukicris.Redis.LearnNote4;

import redis.clients.jedis.Jedis;

import java.util.Set;

public class Nosql17 {
    //使用java来操作Redis
    /**
     *  {
     *      Jedis是Redis官方推荐的链接开发工具,使用Java操作redis中间件
     *
     *      如果要使用java操作redis.则需要对jedis十分熟悉
     *
     *      学习要慢慢来,不能急躁,慢慢来会很快
     *  }
     *
     *  {
     *      1 导入依赖
     *      <dependency>
     *             <groupId>redis.clients</groupId>
     *             <artifactId>jedis</artifactId>
     *             <version>3.7.0</version>
     *         </dependency>
     *
     *
     *
     *      2 编码测试
     *
     *  }
     *
     *
     */

    public static void main(String[] args) {
        // new一个jedis对象
        Jedis jedis = new Jedis("119.29.104.21", 6379);
        // 输入密码
        jedis.auth("xx");
        //jedis 所有指令都是我们之前所学习到的指令,所以之前的指令学习很重要


        // 基本语法
        System.out.println("清空数据"+ jedis.flushDB());
        System.out.println("判断某个键是否存在"+ jedis.exists("username"));
        System.out.println("新增<'username','yukicris'>的键值对"+ jedis.set("username","yukicirs"));
        System.out.println("系统中的所有键如下");
        Set<String> keys = jedis.keys("*");
        System.out.println(keys);
        System.out.println("删除键password"+jedis.del("password"));
        System.out.println("判断键是否存在"+ jedis.exists("password"));
        System.out.println("查看键username 所存储的值的类型"+ jedis.type("username"));
        System.out.println("随机返回key空间的一个"+jedis.randomKey());
        System.out.println("重命名key"+jedis.rename("username","name"));
        System.out.println("取出改后的name"+jedis.get("name"));
        System.out.println("切换数据库" +jedis.select(0));
        System.out.println("删除当前选择数据库的所有key"+jedis.flushDB());
        System.out.println("返回当前数据库的key数目"+ jedis.dbSize());
        System.out.println("删所有数据库的所有key"+jedis.flushAll());

        //测试特殊类型
        /*jedis.geoadd();
        jedis.pfadd();
        jedis.setbit();*/




        System.out.println(jedis.ping());
    }


    /**
     * 常用API
     *
     * String List Hash Set zSet
     */
}

