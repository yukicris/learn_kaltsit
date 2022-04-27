package com.yukicris.RabbitMQ.learnNote1;

public class Msg5 {
    // 公平分发与轮询分发
    //默认轮询,无论服务器快慢,都分发相同数量.自动应答

    // autoAck

    /**
     * true 自动应答:一旦消费者接受到了消息,就视为自动应答了消息
     *       优点是快,但是会有消息丢失的风险,因为即便出错了,也会确认并消费掉该信息
     *
     *
     * false 手动应答: 在消息处理成功后,再确认消息
     * 等待消费者手动发送回ack信号后,才从内存(和磁盘-持久化的信息)中移除消息
     * 一直持有消息直到消费者channel.basicAck()为止,然后再通过channel.basicPublish重新发布
     */


    // 公平分发 就是(必须)把应答机制改成手动应答

    // 设置 指标: qos=1  一次从队列取1条,如果服务器性能够快,则先抢到这1条数据,服务器性能越快抢的越多越快
              //  finalChannel.basicQos(1);

    /*
     * 手动应答
     * @param1 deliveryTag 消息应答标记，消息的ID
     * @param2 multiple:(false、只应答接收到的那个消息 true、应答所有传递过来的消息，批量应答)
     *         假如有5，6，7，8四个消息被传递过来，当前消息为8
     *         false时：只会应答8这个消息，5，6，7三个消息不会进行应答
     *         true时：会将5，6，7，8这四个消息全部应答。
     */
     // finalChannel.basicAck(delivery.getEnvelope().getDeliveryTag(),false);

}
