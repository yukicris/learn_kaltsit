package com.yukicris.Thread.ThreadDay5;

public class Knowledge3 {
   /* 2.1 什么是分布式锁
    单机锁（线程锁） synchronized、Lock

    分布式锁（多服务共享锁） 在分布式的部署环境下，通过锁机制来让多客户端互斥的对共享资源进行访问

2.2 分布式锁的基本概念
            基本概念

    多任务环境中才需要

    任务都需要对同一共享资源进行写操作；

    对资源的访问是互斥的（串行化）

    状态

    任务通过竞争获取锁才能对该资源进行操作(①竞争锁)；

    当有一个任务在对资源进行更新时（②占有锁），

    其他任务都不可以对这个资源进行操作（③任务阻塞），

    直到该任务完成更新(④释放锁)；

    特点

    排他性：在同一时间只会有一个客户端能获取到锁，其它客户端无法同时获取

    避免死锁：这把锁在一段有限的时间之后，一定会被释放（正常释放或异常释放）

    高可用：获取或释放锁的机制必须高可用且性能佳

2.3 锁和事务的区别
    锁 单进程的系统中，存在多线程同时操作一个公共变量，此时需要加锁对变量进行同步操作，保证多线程的操作线性执行消除并发修改。解决的是单进程中的多线程并发问题。 分布式锁 只要的应用场景是在集群模式的多个相同服务，可能会部署在不同机器上，解决进程间安全问题，防止多进程同时操作一个变量或者数据库。解决的是多进程的并发问题 事务 解决一个会话过程中，上下文的修改对所有数据库表的操作要么全部成功，要不全部失败。所以应用在service层。解决的是一个会话中的操作的数据一致性。 分布式事务 解决一个联动操作，比如一个商品的买卖分为添加商品到购物车、修改商品库存，此时购物车服务和商品库存服务可能部署在两台电脑，这时候需要保证对两个服务的操作都全部成功或者全部回退。解决的是组合服务的数据操作的一致性问题

3 DB实现分布式锁方案
3.1 乐观锁
3.2 悲观锁
4 Redis实现分布式锁方案
4.1 获取锁

    根据以上图示及思考，可的以下加锁代码∶

    public static void rongGetock(Jedis jedis String lockkey String requestid,int expireTime){
        Long result= jedis.setnx(lockKey,rquestid);
        if(result == 1){
// 若在这里程序突然崩溃，则无法设置过期时间，将发生死锁
            jedis.expire(lockKey, expireTime);
        }
    }
    非原子操作
            setnx和expire的非原子性

    解决方案
    SET my_key my_value NX PX milliseconds （加锁）

    *//**
     * 尝试获取分布式锁
     * @param jedis Redis 客户端
     * @param lockKey 锁
     * @param requestid 请求标识。
     * @param expireTime 超期时间
     *//*
    public bolean trySetDitibutedLock(Jedis jedis, String lockKey,
                                      String requestid, int expireTime){
        String result = jedis.set(lockkey, requestid, SET_IF_NOTEXIST,
                SET_WITH_EXPIRE_TIME, expireTime);
        if (LOCK_SUCESS.equals(result)) {
            return true;
        }
        return false;
    }
4.2 释放锁
            错误删除锁
    线程成功得到了锁，并且设置的超时时间是30秒。 线程A执行的很慢很慢，过了30秒都没执行完，这时候锁过期自动释放，线程B得到了锁。 线程A执行完了任务，线程A接着执行del指令来释放锁。 但这时候线程B还没执行完，线程A实际上删除的是线程B加的锁。

    解决方案
    加锁的时候把当前的线程ID当做value，并在删除之前验证key对应的value是不是自己线程的ID。
    String threadId= Thread.currentThread().getld()
    // 加锁
    set(key,threadId,30,NX);
// 解锁
if(threadId.equals(redisClient.get(key)){
        del(key)
    }
    但是，这样做又隐含了一个新的问题，if判断和释放锁是两个独立操作，不是原子性。

    Lua脚本释放锁，保证释放锁的方法的原子性

    *//*


     * @param requestld 请求标识
     * @return 是否释放成功
     *//*
    public static bolean releaseDistributedLock(Jedis jedis,String lockKey,String requestid){
        String script =
                "if redis.call('get',KEYs[1)== ARGV[1])
        then return redis.call('del',KEYs[1])
else return 0 end";
        Object result =
                jedis.eval(script, Colletions.singletonList(lockKey),Colletions.sigletonList(requestd));
        if (RELEASE_SUCCESS.equals(result)){
            return true;
        }
        return false;
    }
    锁续航问题
    获得锁的线程开启一个守护线程，用来给快要过期的锁“续航” 过去了29秒，线程A还没执行完，这时候守护线程会执行expire指令，为这把锁“续命”20秒。 守护线程从第29秒开始执行，每20秒执行一次 当线程A执行完任务，会显式关掉守护线程。

    @Test
    public void executiveBusiness() {
        String lockKey = "order";
        String lockValue = Thread.currentThread().getId()+"";
        long time = 30 ;
        while(true) {
            if (tryLock(lockKey, lockValue, time)) {
                Thread daemonThread = new Thread("守护线程") {
                    @Override
                    public void run() {
                        int i = 0;
                        while(true){
                            if(redisTemplate.opsForValue().getOperations().getExpire(lockKey).intValue()<1){
                                while (i++ <= 3) {//续命三次
                                    redisTemplate.expire(lockKey, 20, TimeUnit.SECONDS);//每次续命20秒
                                }
                            }
                            try {
                                Thread.sleep(1000);//每秒查询一次
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                };
                daemonThread.setDaemon(true);
                daemonThread.start();
                try {
                    Thread.sleep(31000);//业务执行31秒
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Boolean tryLock(String lockKey ,String lockeValue, long time){
        return redisTemplate.opsForValue().setIfAbsent(lockKey, lockeValue, time, TimeUnit.SECONDS);
    }
4.3 要点回顾
    一定要用SET key value NX PX milliseconds 命令

            value要具有唯一性

    释放锁一定要使用lua脚本

4.4 Redis分布式锁的可靠性思考
    redis有3种部署方式：

    单机模式

    master-slave + sentinel选举模式

    redis cluster模式

    RedLock
    分布式缓存锁—Redlock

5 Zookeeper实现分布式锁方案
5.1 Zookeeper实现分布式锁逻辑

06.png

5.2 Zookeeper实现分布式锁的实现流程
    client1获取锁： <center>



</center> client2获取锁：



    client3获取锁：



    client1释放锁：



    client2获取锁及释放锁：



    性能上可能并没有缓存服务那么高，因为每次在创建锁和释放锁的过程中，都要动态创建、销毁临时节点来实现锁功能

    ZK 中创建和删除节点只能通过 Leader 服务器来执行，然后将数据同步到所有的 Follower机器上

    取舍

5.3 分布式锁可靠性思考
6 三种分布式锁方案小结
    上面几种方式，哪种方式都无法做到完美。就像CAP一样，在复杂性、可靠性、性能等方面无法同时满足。所以，根据不同的应用场景选择最适合自己的才是王道。
    从理解的难易程度角度（从低到高） 数据库 > 缓存 > Zookeeper

    从实现的复杂性角度（从低到高） Zookeeper >= 缓存 > 数据库

    从性能角度（从高到低） 缓存 > Zookeeper >= 数据库

    从可靠性角度（从高到低） Zookeeper > 缓存 > 数据库

7 幂等性接口设计
7.1 幂等操作
    多个线程（并发）操作同一个接口（同一个方法），对最终的结果没有影响，这样的操作叫做幂等性操作。
    基本的CURD操作，哪些是幂等性的操作？ 1、查询 --- 幂等性操作 select* from user where id = 1 如∶ 1000线程同时访问以上SQL语句，得到结果都一样，对最终的结果没有影响。 2、添加 -- 非幂等性操作 insert into user values(xx); 如∶1000线程同时访问以上SQL语句，对操作结果有影响，将会向数据库插入新的数据。 3、更新 -- 非幂等性操作 update user set. where id = 1 如∶1000 线程同时访问以上SQL语句，对操作结果有影响，将会改变数据。 4、删除 -- 幂等性操作 delete from user where id =1

7.2 应用场景
    在什么业务场景下才使用幂等性接口? 1、项目分层架构模式下，由于网络抖动，超时请求重发（退款接口） 2、SOA、微服务架构模式下，跨服务调用（为了保证服务高可用，采用了超时重发机制）的超时重发 3、利用消息中间件将任务进行异步处理时，任务消息一旦重发，消费者业务操作重复处理

7.3 如何设计幂等性接口
    以退款为例。在单机模式下，并发请求退款接口，退款接口当中先校验是否存在重复性的id，然后再决定是否进行退款处理。
    重复性的校验借助于第三方的库，比如使用MySQL、Redis。
    如果是MySQL，可以设计一张去重表，把orderId设计为表的主键，根据orderId查询去重表。如果不存在的话则可以执行退款操作，先将数据插入，然后执行退款；如果存在的话，则证明已经退过款了，则直接返回。当然，由于是并发操作，项目中需要设计本地锁。
    如果使用Redis则直接利用分布式锁的特点即可使用，不需要使用本地锁。

    如果项目是集群服务，利用MySQL进行重复性校验，则需要借助本地锁保证接口的幂等性了。*/
}
