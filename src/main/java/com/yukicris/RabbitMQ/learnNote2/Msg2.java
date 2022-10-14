package com.yukicris.RabbitMQ.learnNote2;

public class Msg2 {
    /**
     * 过期时间TTL
     *     过期时间TTL表示可以对消息设置预期的时间,在这个时间内,可以被消费者接收,过期之后消息将被自动删除
     *     rabbitMQ可以对消息队列设置TTL,目前有2种方法设置
     *
     *     见项目,写了一遍,可以运行
     *     方法1 是在配置文件中配置args参数,设置队列的过期时间,web端页面队列中会多个TTL标记
     *     方法2 是在消息发送的时候设置消息的配置信息,设置消息过期时间
     *
     *     当两者都设置了时间,以时间设置最短的为准
     *
     *
     *     消息过期和队列过期的区别在于 消息过期就直接删除了,队列过期可以设置死信队列
     *
     */


    /**
     * 死信队列
     *
     * 消息被拒绝,消息过期,队列到达最大长度的时候
     *
     * 见deadRabitConfiguration 和ttl联合一起处理的
     */

    /**
     * 内存磁盘监控
     * memory 内存极限大小*0.4 就会爆黄bloking和报宏bilocked,导致链接Connection挂起,无法消费
     * 说明达到了预支以及高负荷运行了,赶紧加内存
     *
     * 可以通过命令的方式进行配置(相对值或者绝对值),二者选其一,在Broker重启以后会失效
     * 通过修改配置文件的方式设置的则不会随着重启而消失,但是要重启broker才生效
     * 一般配置相对值 0.4到0.7之间
     *
     *
     * DiskSpace 剩余磁盘容量,同理,少于多少也挂机
     *
     *
     *
     * 内存换页  : 当内存达到阈值的百分之50就会换页处理
     * 比如有1000MB内存,使用率叨叨了400M极限,因为配置换页内存0.5,会在达到200M的时候把内存中的
     * 200MB转移到磁盘中,从而达到稳健运行
     */

    /**
     * 搭建集群这块百度吧 - -
     * 单机部署多应用:
     *     主节点和从节点都会同时处理创建交换机,创建队列,发送消息等等功能
     *     但是从节点挂了,从节点就无法同步消息,但是主节点依然可以保持正常
     *     主节点挂了的话,从节点无法正常使用,队列上会有个down标签
     *
     *  用HA来构建多机多应用集群,这样可以保证高可用,一台机器挂了不影响别的机器
     */

    /*
    * .保证幂等性(重复消费)
要保证消息的幂等性，这个要结合业务的类型来进行处理。下面提供几个思路供参考：
（1）、可在内存中维护一个set，只要从消息队列里面获取到一个消息，先查询这个消息在不在set里面，如果在表示已消费过，直接丢弃；如果不在，则在消费后将其加入set当中。
（2）、如何要写数据库，可以拿唯一键先去数据库查询一下，如果不存在在写，如果存在直接更新或者丢弃消息。
（3）、如果是写redis那没有问题，每次都是set，天然的幂等性。
（4）、让生产者发送消息时，每条消息加一个全局的唯一id，然后消费时，将该id保存到redis里面。消费时先去redis里面查一下有么有，没有再消费。
（5）、数据库操作可以设置唯一键，防止重复数据的插入，这样插入只会报错而不会插入重复数据。
    * */

    /**
     * p38 高级分布式有点看不懂了,先springcloud
     */
}
