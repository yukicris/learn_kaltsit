package com.yukicris.Redis.LearnNote2;

public class Nosql9 {
    /**
     * set中的值是不可重复的
     *
     */


    /**
     *
     *
     * 添加
     *
     *
     * [root@VM-0-6-centos /]# cd /usr/local/bin
     * [root@VM-0-6-centos bin]# ls
     * dump.rdb  redis-benchmark  redis-check-rdb  redis-sentinel
     * myconfig  redis-check-aof  redis-cli        redis-server
     * [root@VM-0-6-centos bin]# redis-cli
     * 127.0.0.1:6379> auth passowrd
     * OK
     * 127.0.0.1:6379> flushdb
     * OK
     * 127.0.0.1:6379> sadd myset "hello"  :   set集合总添加元素
     * (integer) 1
     * 127.0.0.1:6379> sadd myset "yukicris"
     * (integer) 1
     * 127.0.0.1:6379> sadd myset "learnredis"
     * (integer) 1
     * 127.0.0.1:6379> SMEMBERS myset   :  查看指定set的所有元素
     * 1) "yukicris"
     * 2) "hello"
     * 3) "learnredis"
     * 127.0.0.1:6379> SISMEMBER myset hello   : 判断某个值是不是在set中(set is memner)
     * (integer) 1
     * 127.0.0.1:6379> SISMEMBER myset world
     * (integer) 0
     * 127.0.0.1:6379> scard myset           : 获取set集合中的内容元素个数
     * (integer) 3
     */


    /**
     * 移除
     *
     * 127.0.0.1:6379> srem myset hello   : 移除set中的指定元素
     * (integer) 1
     * 127.0.0.1:6379> SMEMBERS myset
     * 1) "yukicris"
     * 2) "learnredis"
     * 127.0.0.1:6379>
     */


    // set是无序不重复集合,抽随机
    /**
     * SRANDMEMBER myset  : 随机抽出一个元素
     *
     * SRANDMEMBER myset 2 : 随机抽出2个元素
     *
     * SPOP myset : 随机删除一个set集合中的元素
     * SPOP myset 3: 随机删除3个set集合中的元素
     *
     * 127.0.0.1:6379> sadd myset hello
     * (integer) 1
     * 127.0.0.1:6379> SMEMBERS myset
     * 1) "yukicris"
     * 2) "hello"
     * 3) "learnredis"
     * 127.0.0.1:6379> spop myset
     * "hello"
     * 127.0.0.1:6379> SMEMBERS myset
     * 1) "yukicris"
     * 2) "learnredis"
     */

    /**
     * 讲一个指定的值,移动到另外一个set集合中
     *
     * smove myset myset2 hello  将myset 中的hello移动到myset2里面去
     *
     *
     */

    //一些网站的共同关注
    // 微博等,A用户将所有的关注的人仿制一个set集合中,将他的粉丝也放在一个集合中,做共同关注
    /**
     * SDIFF key1 key2 : 查询2个集合的差集,即key1{a,b,c} key2{c,d,e},以key1为主返回差集{a,b}
     *
     * SINTER key1 key2 :查询交集,返回{c} ,共同好友,共同关注等
     *
     * SUNION key1 key2 : 查询并集,返回{a,b,c,d,e} (这里已经去重)
     *
     */


}
