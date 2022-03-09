package com.yukicris.Redis.LearnNote1;

public class Nosql6 {
    /**
     * 五大数据类型
     * 以下命令一定要全部记住!!!,后面用springboot,jedis都要用这些命令
     * Redis-key:{
     *     Exists name  : name是否存在
     *     move name 1 : 移动name到1号数据库
     *     del name : 清除
     *     EXPIRE name 10  : 设置过期时间为10s (输入ttl name 看过期时间,时间到了就没了(time to deline))
     *     type key : 查看当前key的类型
     *     (遇到不会的命令在官网查看)
     * }
     *
     *
     * String
     * list
     * set
     * Hash
     * Zset
     */
}
