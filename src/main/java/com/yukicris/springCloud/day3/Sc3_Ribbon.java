package com.yukicris.springCloud.day3;

public class Sc3_Ribbon {
    /**
     * 客户端负载均衡的工具
     *
     *  代码看80端口客户端项目
     *
     * LoadBalance  负载均衡 lb
     *
     * 将用户的请求平均摊到多个服务商,从而达到系统的HA(高可用)
     * 常见负载均衡软件 Nginx.Lvs等
     *
     * dubbo和springCloud都提供了负载均衡,SpringCloud的负载均衡算法可以自定义
     *
     *
     * 分类:
     *      1 集中式LB
     *          即在服务的消费方和提供方之间使用独立的LB设施,如Nginx; 反向代理服务器,由该设施负责把访问请求通过某种策略转发至服务提供方
     *      2 进程式LB
     *          将LB逻辑集成到消费方,消费方从服务注册中心获知有哪些地址可用,再自己从这些地址中选择合适的服务器
     *          Ribbon属于进程内LB ,它只是一个类库,集成消费方进程,消费方通过它来获取服务提供方的地址
     *
     *
     *  配置方法
     *      1 导包,ribben的包+记得导Eureka的包
     *      2 配置文件,客户端不注册到Eureka中,再关联服务提供者
     *      3 RestTemplate增加配置@LoadBalanced
     *      4 接口中写死的ip端口服务地址改成动态获取
     *
     *  看机制搜全局 IRule 看它中间的实现方式
     *
     *
     *  核心测试:    在搭建了3台集群服务器provider 8001-8003以后(3台访问不同数据库),并打开1-3台(随便几台)注册中心,再访问客户端80服务
     *  http://localhost/consumer/dept/list   多刷几次,就可以得到不同的数据源的数据,即分布式,负载均衡
     *
     *
     *  有关自定义负载均衡策略
     *  1 启动类配置自己配置类
     *  // 按需加载,加载负载均衡服务以及配置,在微服务启动的时候就能加载自定义的Ribbon类
     * @RibbonClient(name = "SPRINGCLOUD-PROVIDER-DEPT",configuration = MyRule.class)
     *
     *  2 自己的配置类需要放在启动类的上级目录以免被扫描到,导致冲突
     *  3 自定义启动类yukicrisRule
     *  4 完成每请求5次就更换服务提供者
     *  5 这部分主要参考yukicrisRule配置
     *
     */
}
