package com.yukicris.Redis.LearnNote4;

public class Nosql16 {
    //Watch 监控(乐观锁)


    /**
     * 悲观锁,认为什么时候都会出问题,无论什么时候都会去枷锁(性能低)
     *
     */

    /**
     * 很乐观,认为什么时候都不会出问题,所以不会上锁,更新数据的时候才去判断,在此期间是否有人修改过这个数据
     * (mysql里面用的version,每次更新就会带个version字段,来判断是否有更新操作)
     */

    //Redis测监视测试
    /**
     *
     *
     * {
     *     [root@VM-0-6-centos ~]# cd /usr/local/bin
     *      [root@VM-0-6-centos bin]# ls
     *      dump.rdb  redis-benchmark  redis-check-rdb  redis-sentinel
     *      myconfig  redis-check-aof  redis-cli        redis-server
     *      [root@VM-0-6-centos bin]# redis-cli
     *      127.0.0.1:6379> auth flzx3000c
     *      OK
     *      127.0.0.1:6379> watch money    : 使用watch'监视这个money,然后用下面的另起一个客户端对money进行修改
     *      OK
     *      127.0.0.1:6379> multi
     *      OK
     *      127.0.0.1:6379> DECRBY money 20
     *      QUEUED
     *      127.0.0.1:6379> INCRBY money 10
     *      QUEUED
     *      127.0.0.1:6379> exec          :事务正常结束,数据期间如果没有发生改变,那么久正常执行成功
     *      1) (integer) -20
     *      2) (integer) -10
     *      127.0.0.1:6379>
     * }
     */

    //测试多线程修改值,使用watch可以当做redis的乐观锁操作
    /**
     * 这里对money进行修改
     *
     * watch money    : 监视这个money
     *
     * multi
     *
     * Decrby money 10
     * incrby out 10
     *
     * exec        : 执行之前,另外一个线程修改了我们监视的这个值,这个时候,就会导致事务执行失败
     * >nil
     */


    /**
     *
     *
     * {
     *     127.0.0.1:6379> unwatch    //如果发现事务执行失败,就先解锁(exec后,无论是否watch,都会自动解锁)
     *     OK
     *     127.0.0.1:6379> watch money    //获取最新的值,再次进行监视(sql里头的select version)
     *     OK
     *     127.0.0.1:6379> multi
     *     OK
     *     127.0.0.1:6379> DECRBY money 1
     *     QUEUED
     *     127.0.0.1:6379> INCRBY out 1
     *     QUEUED
     *     127.0.0.1:6379> exec       // 对比监视的值是否发生了变化,如果没有变化,就执行成功,如果变化了就执行失败.
     *     1) (integer) -11
     *     2) (integer) 1
     *     127.0.0.1:6379>
     * }
     */
    // 如果修改失败了,获取最新的值就行

}
