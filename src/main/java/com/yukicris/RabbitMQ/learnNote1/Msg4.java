package com.yukicris.RabbitMQ.learnNote1;

public class Msg4 {
    /**
     * 4种exchange(交换机)
     *
     *
     */

    /**
     * Publish/Subscribe 对应发布订阅模式(广播模式)
     *
     * exchange 类型选择fanout ,然后绑定多个队列queues
     * 再给exchange推送消息,即可使多个队列都接受到消息 即为发布订阅模式
     */


    /**
     * Route 指定队列模式
     *
     * exchange 类型选择direct ,然后绑定多个队列queues
     * 在发布订阅模式的基础之上,给队列增加一个(或多个)路由key做过滤条件
     * (比如我消息发送给邮箱,短信,但是不想发送给微信,就用路由key作为过滤条件)
     * 再给exchange推送消息,选择对应的routekey,即可使指定路由key的队列都接受到消息 即为路由模式
     */

    /**
     * Topic 主题模式
     *
     * exchange 类型选择topic ,然后绑定多个队列queues
     * 在发布订阅模式的基础之上,给队列增加一个(或多个)路由key做过滤条件(加模糊查询条件)
     *   # 代表0个或者多个   *代表必须有一级且仅有一级
     * (比如我消息发送给邮箱,短信,但是不想发送给微信,就用路由key作为过滤条件)
     * 再给exchange推送消息,选择对应的routekey,即可使指定路由key的队列都接受到消息 即为主题模式
     */


    /**
     * header 头模式
     *
     * exchange 类型选择header,然后绑定多个队列queues
     * 在发布订阅模式的基础之上,给队列增加一个(或多个)argument做过滤条件
     * 再给exchange推送消息,选择对应的headers,即可使指定路由key的队列都接受到消息 即为主题模式
     */

}
