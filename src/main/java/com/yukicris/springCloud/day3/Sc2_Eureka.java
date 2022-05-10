package com.yukicris.springCloud.day3;

public class Sc2_Eureka {
    //Eureka

    /**
     *
     * Euraka遵循的AP原则
     *
     *  是一个基于REST的服务,用于定位服务,以实现云端中间层服务发现和故障转移
     *  ,服务注册与发现对于微服务来说十分重要,有了服务发现与注册,只需要使用服务的标识符,就可以访问到服务,不需要修改服务调用的配置文件,类似Zookeeper
     *
     *
     *
     *  基本架构:
     *    SpringCloud封装了NetFlix公司开发的Eureka模块来实现服务注册与发现
     *
     *    Eureka采用cs架构,EurekaServer作为服务注册功能的服务器,他是服务注册中心
     *
     *    系统中其他的微服务,使用Eureka的客户端来链接到EurekaServer保持心跳连接,这样系统的维护人员可以通过Eureka
     *    Srtver来监测系统中的各个微服务是否正常运行,Spring cloud中的一些其他模块(比如Zuul)可以通过EurekaServer来发现系统中其他微服务
     *
     *    和Dubbo架构对比
     *
     *
     *  三大角色:
     *     Eureka Server : 提供服务注册与发现. 类似Zookeeper
     *     Service Provider: 将自身服务注册到Eureka中,从而使消费方可以找到
     *     Server Consumer: 服务消费方从Eureka中获取注册服务列表,从而找到消费服务
     *
     *
     * (配置这鬼玩意如果找不到bean很可能是版本的问题,要检查spring_boot和springcloud的版本对应关系)
     *
     *
     *
     *
     */
}
