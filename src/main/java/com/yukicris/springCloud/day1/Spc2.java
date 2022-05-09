package com.yukicris.springCloud.day1;

public class Spc2 {

    /**
     * 微服务架构的4个核心问题
     *
     * 1 服务很多 ,客户端怎么访问
     * 2 这么多服务,服务之间如何通信(http/rpc )
     * 3 这么多服务,如何治理
     * 4 服务挂了怎么办
     *
     * (图翻官网去)
     * 解决方案:
     *      spring cloud 是一个生态,用于解决上述4个问题
     *
     *      1 spring cloud netflix   一站式解决方案
     *          api网关: zuul组件
     *          Feign   --HttpClient  --- Http通信方式 ,铜币 ,阻塞
     *          服务注册与发现: Eureka
     *          熔断机制 : Hystrix
     *
     *      2 Apache Dubbo Zookeeper    半自动,需要整合别人的
     *          Api: 没有,找第三方组件,扩展,或者自己实现
     *          Dubbo: RPC通信框架
     *          Zookeeprer
     *          没有: 借助别人的
     *
     *          Dubbo这个方案并不完善
     *
     *
     *      3 Spring Cloud Alibaba      最新的一站式解决方案,更简化了
     *
     *
     * 新概念: 服务网格 --Server Mesh
     *      istio
     *
     * 万变不离其宗
     *
     *
     *
     * 常见面试题:
     * 1 什么是微服务
     * 2 微服务之间如何独立通讯
     * 3 SpringCloud 和Dubbo的区别
     * 4 SpringBoot 和Spring Cloud 请你谈谈理解\
     * 5 什么是服务熔断,什么是服务降级
     * 6 微服务的优缺点是什么,说下在项目开发中遇到的坑
     * 7 你所知道的微服务技术栈有哪些,列举
     * 8 eureka和zookeeper都可以提供服务的注册与发现功能,说说这俩的区别
     *
     *
     *
     *
     */
}
