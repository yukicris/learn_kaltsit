package com.yukicris.RabbitMQ.learnNote1;

public class Msg3 {
    // 核心概念
    /**
     * 下图是RabbitMQ 的消息模型，生产者将消息交给交换机，
     * 交换机根据路由规则将不同的消息路由到不同的队列（路由规则继续看），
     * 消费者订阅\监听队列，当有消息过来，立即消费。
     */

    /**
     * Broker
     * Broker 简单理解就是 com.yukicris.RabbitMQ 服务器，图中整个灰色部分.
     *
     * vHost 虚拟主机
     * 每一个 com.yukicris.RabbitMQ 可以开设多个vHost，每个vHost是一个mini版的RabbitMQ，拥有自己的交换机Exchange，绑定Bidding，队列Queue。更重要的是每个RabbitMQ里面都有独立的权限机制，这样就可以是使用RabbitMQ来服务多个独立的应用，其中每个vHost服务一个应用程序。
     * 每一个RabbitMQ 都有一个默认的虚拟主机"/",客户端连接RabbitMQ必须指定vHost，如果不指定的话，默认连接"/"。
     *
     * Exchange 交换机
     * 交换机的作用就是根据路由消息将消息发到对应的队列上。
     *
     * Connection
     * 无论是生产者还是消费者，都需要与Broker建立连接，这个连接就是Connection，他是一条TCP连接，一个生产者或消费者与Broker 之间只有一个Connection，即一个TCP连接。
     *
     * ConnectionFactory
     * Connection工程，负责创建和管理Connection。
     *
     * Channel
     * Channel 是建立在真实的TCP连接内的虚拟连接（图中白色部分）
     * AMQP 都是通过信道完成的，每条信道都有一个唯一ID，不论是订阅队列、发布消息还是接收消息都是通过信道完成的。每一个TCP都有多个信道，避免了TCP的创建与销毁。
     *
     * Routing key
     * Routing key 是消息头的属性，当生产者将消息发送到交换机的时候，会在消息头上带一个key，这个key就是Routing key，来指定这个消息的路由规则。
     *
     * Binding
     * 绑定，可以理解成一个动词，把Exchang 和 Queue(队列) 绑定起来。
     *
     * Binding key
     * 在绑定Exchange 和 Queue 的时候，需要指定一个 Binding key,生产者将消息发送给Exchange 的时候，会带一个 Roution key,当Routing key 和 Binding key匹配成功，消息会被路由到相应的Queue 中
     *
     * 作者：你的眼里躺着海
     * 链接：https://www.jianshu.com/p/fadcb916cce8
     * 来源：简书
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     *
     */


    // 重点应答模式  Nack 不做应答,
    // ack做应答 ,做应答后会删除调队列,别瞎选

    // 消息发送给交换机(一定要一个交换机exchange!!)即使不选交换机也会分配一个默认交换机
       // 然后再由交换机推送给队列,再推给消费者
}
