package com.yukicris.springCloud.day3;

public class Sc6_Zuul {
    /**
     * ZUUL  包含了对请求的路由和过滤两个最主要的功能
     *
     * 将外部请求转发到具体的微服务上,实现外部访问统一入口的基础
     * 过滤器 则负责对请求的处理过程进行干预,实现请求校验,服务聚合等功能的基础
     *
     *  Zuul和Eureka进行整合,将Zuul自身注册为Eureka服务治理下的应用,同时从Eureka中获取其他微服务的消息
     *  即 以后访问微服务都是通过Zuul跳转后获得
     *  Zuul最终开始会注册进Eureka
     *  提供 代理 + 路由 + 过滤 三大功能
     *
     *
     *
     */
}
