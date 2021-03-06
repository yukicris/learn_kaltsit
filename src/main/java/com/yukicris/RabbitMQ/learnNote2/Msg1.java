package com.yukicris.RabbitMQ.learnNote2;

public class Msg1 {
    // 为什么使用rabbitmq(使用场景)
    // 解耦,削峰(缓解数据库的压力),异步


    /**
     * 1 同步异步的问题(串行)
     *      串行方式: 将订单写入数据库成功后,发送注册邮件,发送注册短信,以上三个任务全部完成后,返回给客户端(缺点:执行完所有的耗时较长)
     *      异步线程池: 可以让一部分(发送注册邮件,发送短信)并行执行(多线程异步) 可以加快速度(缺点,需要自己维护线程池,持久性高可靠,高可用都要自己去实现,最重要是耦合在应用面程序中)
     *
     *      所以使用了中间件,构成异步消息队列: 1 完全解耦,用mq建立桥梁 2 有独立的线程池和运行模型 3 出现了消息可能会丢失,mq有持久化的功能
     *      4 如何保证消息的可靠性,死信队列和消息转移等  5 如果服务器承载不了,需要自己去写高可用,HA镜像模型高可用
     *
     * 2 高内聚低耦合
     *
     * 3 流量削峰
     *
     * 4 分布式事务的可靠消费和可靠生产
     *
     * 5 索引,缓存,静态处理的数据同步
     *
     * 6 流量监控
     *
     * 7 日志监控(ELK)
     *
     * 8 下单,订单分发,抢票
     *
     */


    /**
     * 整合spring 见项目write_learn
     *
     * 注解形式绑定见Topic模型
     *
     * 手动配置类 见fanout 和diret模型
     *
     * 其次也可以直接使用web可视化页面端的配置,不过实际环境中可能没访问权限,不利于开发者维护
     *
     */

}

