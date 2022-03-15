package com.yukicris.Redis.LearnNote5;

public class Nosql23 {
    // 发布订阅
    /**
     * Redis发布订阅(pub/sub)是一种消息通信模式:发送者pub发送消息,订阅者(sub)接收消息,微博,微信,关注系统
     *
     * redis 客户端可以订阅任意数量地频道
     *
     * redis-cli -> 发布消息  >redis server(队列) ->{
     *                                             redis cli(消息订阅者 )
     *                                             redis cli(消息订阅者 )
     *                                             redis cli(消息订阅者 )
     *                                             }
     */

    /**
     * 第一个,消息发送者
     * 第二个,频道
     *
     */


    //测试
    /**
     * 订阅端:
     * subscribe yukicris 订阅一个频道yukicris
     * >"subscribe"
     * >"yukicris"
     * >1
     * // 等待读取推送的信息
     * >"message"
     * >"yukicris"     哪个频道的消息
     * >"hello1"       消息的内容
     *
     * 发送端:
     * Publish yukicris "hello1" 发布者发布消息到频道
     * >1
     *
     */

    // 场景 1 实时消息发布系统  2 频道当做聊天室,将信息回显给所有人即可 3 订阅,关注系统


    //稍微复杂的系统用消息中间件来做

}
