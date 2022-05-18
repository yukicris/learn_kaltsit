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
     * 1 配置路由网关 zuul,联动Eureka,加jar包,写启动类,写配置文件
     * 2 启动7001和8001
     * 3 访问http://www.yukicris.com:9527/springcloud-provider-dept/dept/get/1
     *
     * 配置了路由网关以后,就可以通过9527来访问了而不是8001,记得服务名springcloud-provider-dept要小写
     *
     * zuul:
     *   routes:
     *     mydept.serviceId: springcloud-provider-dept
     *     mydept.path: /mydept/**     #这个配置是为了隐藏原来的服务路径
     *     ignored-services: springcloud-provider-dept #加了这个配置以后,就不能再使用这个路径访问,只能使用/mydept/**访问
     *     也就是说springcloud-provider-dept 也是可以被隐藏的,然后用下面这个/mydept/**替代
     *
     *     ignored-services: "*" 隐藏全部
     *     prefix: /yukicris  # 公共前缀,可以不要 加了的话就必须访问http://www.yukicris.com:9527/yukicris/mydept/dept/get/1
     *
     *     如果把zuul 服务器换到80,那9527都没了
     */
}
