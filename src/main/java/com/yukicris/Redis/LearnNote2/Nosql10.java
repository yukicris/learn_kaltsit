package com.yukicris.Redis.LearnNote2;

public class Nosql10 {
    /**
     * Hash 哈希
     */
    /**
     * Map集合,key-map  这个时候值是一个map集合,本质和string类型没有太大区别,还是一个简单的key-value
     */


    /**
     * hset myhash field1 yukicris   :set给一个名字myhash的map一个具体的key-value
     * hget myhash field1
     * >yukicris
     *
     * hmset myhash field1 hello field2 world   : set多个key-value
     * hmget myhash field1 field2 : 获取多个字段值
     *
     *
     * hgetall myhash  : 获取全部的值,不过展,示形式会类似string,按键-值来
     * >field1
     * >"hello"
     * >field2
     * >"world"
     *
     *
     *
     */


    /**
     * 删除
     *
     *hdel myhash field1  : 删除hash指定的key字段,对应的value也消失了
     *
     */

    /**
     * hlen myhash  : 获取hash的字段数量
     */

    /**
     * HEXISTS myhash field1 : 判断hash中的指定字段是否存在
     */


    /**
     * hkeys myhash  : 获取所有的key
     *
     *
     * hvals myhash : 获取所有的value
     */

    /**
     * hset myhash field3 5  指定增量
     *
     * HINCRBY myhash field3 1 指定增加1
     * HINCRBY myhash field3 -1 指定减1,好像没有decrby
     *
     * hsetnx myhash field4 hello 如果key不存在就新建,如果存在则失败
     *
     */
    // hash 变更的数据,user name age 尤其是用户信息之类经常变动的信息,hash更适合用于对象的存储


}
