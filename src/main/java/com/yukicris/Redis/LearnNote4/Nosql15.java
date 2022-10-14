package com.yukicris.Redis.LearnNote4;

public class Nosql15 {

    //事务

    {
        //a c i d
        /**
         * Redis 的本质是一组命令的集合,一个事务中的所有命令都会被序列化,在事务执行的过程中,会按照顺序执行
         * 一次性,顺序性,排他性
         *
         *
         *
         * 要么同时成功,要么同时失败,原子性
         *
         *
         * Redis事务是没有隔离级别的概念的
         * 所有的命令在事务中并没有直接被执行,只有发起执行命令的时候才会执行
         * Redis 的单条命令是保证原子性的,但是事务是不保证原子性的
         *
         */

        /**
         * redis的事务
         *
         * 开启事务 (multi)
         * 命令入队 ()
         * 执行事务 (exec)Exec 命令用于执行所有事务块内的命令。,就是一次性把所有请求执行完毕
         *
         *
         *
         *
         *
         * {
         *     127.0.0.1:6379> flushdb
         * OK
         * 127.0.0.1:6379> MULTI  : 开启事务
         * OK
         * 127.0.0.1:6379> set k1 v1   : 命令入队
         * QUEUED
         * 127.0.0.1:6379> set k2 v2
         * QUEUED
         * 127.0.0.1:6379> get k2
         * QUEUED
         * 127.0.0.1:6379> set k3 v3
         * QUEUED
         * 127.0.0.1:6379> set k2 v4
         * QUEUED
         * 127.0.0.1:6379> exec   : 事务一次性按顺序执行
         * 1) OK
         * 2) OK
         * 3) "v2"
         * 4) OK
         * 5) OK
         * 127.0.0.1:6379> get k2
         * "v4"
         * 127.0.0.1:6379>
         * }
         *
         *
         *
         *
         *
         *
         *
         */


        /**
         * 放弃事务
         * DISCARD
         *
         * {
         *     127.0.0.1:6379> multi   :开启事务
         * OK
         * 127.0.0.1:6379> set k1 v2
         * QUEUED
         * 127.0.0.1:6379> set k2 v3
         * QUEUED
         * 127.0.0.1:6379> set k4 v5
         * QUEUED
         * 127.0.0.1:6379> DISCARD   : 取消事务
         * OK
         * 127.0.0.1:6379> get keys *
         * (error) ERR wrong number of arguments for 'get' command
         * 127.0.0.1:6379> get keys
         * (nil)
         * 127.0.0.1:6379> keys *  : 没有k4 ,事务中的命令都不会被执行
         * 1) "k3"
         * 2) "k1"
         * 3) "k2"
         * 127.0.0.1:6379>
         * }
         *
         *
         */


        /**
            编译型异常,(代码有问题,命令有错) ,事务中所有的命令都不会被执行

         {
             127.0.0.1:6379> multi
             OK
             127.0.0.1:6379> set k1 v1
             QUEUED
             127.0.0.1:6379> set k2 v2
             QUEUED
             127.0.0.1:6379> set k3 v3
             QUEUED
             127.0.0.1:6379> getset k3   :此处错误命令,语法上错误
             (error) ERR wrong number of arguments for 'getset' command
             127.0.0.1:6379> set k5 v5
             QUEUED
             127.0.0.1:6379> exec   :因为命令有误,导致事务无法执行
             (error) EXECABORT Transaction discarded because of previous errors.```

         }
         */


        /**
         * 运行时异常(I/O) ,如果事务队列中存在语法性错误,那么执行命令的时候,其他命令是可以正常执行的,错误命令抛出异常
         * 条错了不影响事务整体,所以无法保证事务原子性,与mysql不同!
         *
         *  {
         *      127.0.0.1:6379> set k1 v1
         *      OK
         *      127.0.0.1:6379> multi
         *      OK
         *      127.0.0.1:6379> incr k1   : string无法自增,所以他报错了,但是语法没问题,可以正常执行
         *      QUEUED
         *      127.0.0.1:6379> set k2 v2
         *      QUEUED
         *      127.0.0.1:6379> set k3 v3
         *      QUEUED
         *      127.0.0.1:6379> get k3
         *      QUEUED
         *      127.0.0.1:6379> exec
         *      1) (error) ERR value is not an integer or out of range    :一条错了不影响事务整体,所以无法保证事务原子性,与mysql不同!
         *      2) OK
         *      3) OK
         *      4) "v3"
         *      127.0.0.1:6379>
         *  }
         *
         *
         */

        /**
         * 锁
         */
    }
}
