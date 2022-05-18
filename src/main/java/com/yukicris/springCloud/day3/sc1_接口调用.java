package com.yukicris.springCloud.day3;

public class sc1_接口调用 {
    /**
     *
     * 分布式难点主要是在于分布式锁和分布式缓存,这部分视频没有详细讲解,需要以后自己慢慢看慢慢学
     *
     *
     * 1 分布式为了实现网络通信,需要给实体类进行序列化Serizable (必须)
     *
     *
     *
     * 根据教程,感觉需要拆分项目,旧练习项目或许不再合适
     *
     * 写了一个springcloud项目
     *
     * 先看基础module
     *    springboot-api,其中定义了一个pojo对象
     *
     *    然后写了个完整的springboot项目,springboot-8001,在引包的时候引入了springboot-api这个包,并且
     *    在mybatis中使用了这个包内部的pojo对象
     *
     *    在看消费者consumer-80项目
     *         ( tips: 此处有个RestTemplate,没有被注册成bean,无法被Autowired
     *          需要被@Configuration修饰的配置类中进行注册,才能被使用)
     *         ( tips2 : @Controller和@RestController的区别,就是后者是@Responsebody和@Controller的结合)
     *
     *
     *
     *
     * */
}
