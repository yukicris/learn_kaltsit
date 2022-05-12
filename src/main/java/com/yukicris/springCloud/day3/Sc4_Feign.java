package com.yukicris.springCloud.day3;

public class Sc4_Feign {
    /**
     * feign
     * 是声明式的web service 客户端,使微服务之间的调用变得简单,类似controller调用service
     * SpringCloud  集成了Ribbon和Eureka,可以使用Feign提供负载均衡的http客户端
     * 只需要创建一个接口,然后添加注解
     *
     *
     * Feign主要是社区,现在大家习惯面向接口编程,调用微服务访问2中方法,
     * 1 微服务名字   ribbon
     * 2 接口和注解   feign
     *
     * 即 使用一个注解即可完成对服务提供方的接口绑定,简化使用spring Cloud Ribbon时自动封装服务调用客户端的开发量
     *
     * Feign 集成了Ribbon
     * 本质是封装了RestTemplate远程过程调用实现Ribbon负载均衡
     *
     *
     * 使用方法
     *
     * 1 编写的service上加注解@FeignClient(value="SPRINGCLOUD-PROVIDER-DEPT") 绑定服务
     * 2 编写的service接口上加接口注解
     *      @GetMapping("/dept/get/{id}")
     *      public Dept queryById(@PathVariable("id") Long id);
     *
     * 3 消费者启动类增加扫描包@EnableFeignClients(basePackages = {"com.yukicris.springcloud"})
     *
     * 4 消费者controller直接调用接口使用
     *     @Autowired
     *     private DeptClientService deptClientService = null;
     *
     * 5 负载均衡策略改RestTemplate中的注解,默认loadbalance 轮询
     *
     *
     */
}
