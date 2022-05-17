package com.yukicris.springCloud.day3;

public class Sc5_Hystrix {
    /**
     * 难以理解看看这个笔记
     * https://www.kuangstudy.com/bbs/1374942542566551554
     *
     * 多个微服务之间调用的时候,A调用B和C,B和C又调用其他的微服务,这就是所谓的扇出
     *
     * 服务雪崩:
     *      如果扇出链路上某个微服务的调用响应时间过长或者不可用,那么对微服务A的调用就会占用越来越多的系统资源,进而引起崩溃,然后导致其他服务发生
     *      类似故障和延迟,堆积起来造成整体服务崩溃,即雪崩效应
     *
     *
     * Hystrix
     *    是一个用于处理分布式系统的延迟和容错的开源库,在分布式系统中,许多依赖不可避免的会调用失败,比如超时,异常,
     *    Hystrix能够保证一个依赖出问题的情况下,不会导致整体的服务失败,避免级联故障,提高分布式系统的弹性
     *
     *    "断路器" 本身是一种开关装置,当某个服务单元发生故障以后,通过断路器的故障监控,[向调用的方法返回一个服务预期的,可处理的备选响应,Fallback,而不是长时间按的等待或者
     *    抛出调用方法无法处理的异常,就可以保证服务调用方的线程不会被长时间不必要的占用] 从而避免故障在分布式系统中的蔓延,乃至雪崩
     *
     * 能干嘛:
     *      服务降级
     *      服务熔断
     *      服务限流
     *      接近实时的监控
     *
     *      https://github.com/Netflix/Hystrix/wiki
     *
     *
     *服务熔断:
     *  熔断机制是对雪崩效应的一种微服务链路保护机制
     *  当扇出链路某个微服务不可用,或者响应时间太长,会进行服务降级
     *  进而熔断该节点服务调用,快速返回错误的响应信息.正常后恢复链路
     *  注解@HystrixCommand
     *
     *  使用注解@HystrixCommand(fallbackMethod = "hystrixGet") ,然后调用备选方案hystrixGet方法
     *
     *  然后在启动类增加注解: @EnableCircuitBreaker //添加对熔断的支持
     *
     *
     *服务降级:
     *  服务降级要用feign实现
     *  在某种情况下需要关闭某个服务以应对大负荷占用时,且不影响其他功能的解决策略,让服务器专心做一个业务(比如淘宝双11关闭退款服务)
     *
     *
     * 服务熔断和降级的区别
     * 一个主动(降级)一个被动(熔断)
     *      服务熔断—>服务端：某个服务超时或异常，引起熔断~，类似于保险丝(自我熔断)
     *      服务降级—>客户端：从整体网站请求负载考虑，当某个服务熔断或者关闭之后，服务将不再被调用，此时在客户端，我们可以准备一个 FallBackFactory ，返回一个默认的值(缺省值)。会导致整体的服务下降，但是好歹能用，比直接挂掉强。
     *      触发原因不太一样，服务熔断一般是某个服务（下游服务）故障引起，而服务降级一般是从整体负荷考虑；管理目标的层次不太一样，熔断其实是一个框架级的处理，每个微服务都需要（无层级之分），而降级一般需要对业务有层级之分（比如降级一般是从最外围服务开始）
     *      实现方式不太一样，服务降级具有代码侵入性(由控制器完成/或自动降级)，熔断一般称为自我熔断。
     *      熔断，降级，限流：
     *
     *      限流：限制并发的请求访问量，超过阈值则拒绝；
     *
     *      降级：服务分优先级，牺牲非核心服务（不可用），保证核心服务稳定；从整体负荷考虑；
     *
     *      熔断：依赖的下游服务故障触发熔断，避免引发本系统崩溃；系统自动执行和恢复
     *
     *
     *      1 先在api项目里面写
     *      DeptClientServiceFallbackFactory 处理对策方法(备选方案),然后去DeptClientService里面增加
     *      @FeignClient(value="SPRINGCLOUD-PROVIDER-DEPT",fallbackFactory = DeptClientServiceFallbackFactory.class)注解
     *      2 再去feign客户端增加降级配置 application
     *      feign:
     *        hystrix:
     *          enabled: true
     *
     *      3 测试方法 : 打开eureka ,打开8001服务,打开feign-80客户端,然后访问80客户端的服务
     *      http://localhost/consumer/dept/get/1   调用8001的接口,此时成功
     *      然后关闭8001的服务,再访问,依然成功,虽然没有数据,但是会调用备选方案的接口,不会报错,也不会影响其他功能
     *
     *
     *      在解释下api这个类(工程),api就是提供一些基础的类,像dept类服务提供端,消费者都要用,就放api里面
     *      为了提高代码的可用性,如果任何一端需要某个特殊的类,但是又不想破坏自己作为一个单独的功能模块,就放在api里面
     *
     *
     *
     *#dashboard
     *        1 需要在服务端配置这个监控配置,一般随Eureka配好了
     *        <dependency>
     *             <groupId>org.springframework.boot</groupId>
     *             <artifactId>spring-boot-starter-actuator</artifactId>
     *         </dependency>
     *
     *        2 自定义一个监控项目,然后配置
     *          <dependency>
     *             <groupId>org.springframework.cloud</groupId>
     *             <artifactId>spring-cloud-starter-hystrix-dashboard</artifactId>
     *             <version>1.4.7.RELEASE</version>
     *         </dependency>
     *         并配置端口以及启动类,即可启动
     *         http://localhost:9001/hystrix
     *
     *         3 测试时,为了看的明显,增加hystrix_8001项目启动类里,增加一个bean(ServletRegistrationBean) servlet注册bean
     *         记得导hystrix包
     *
     *         4 开启熔断器的支持 8001 启动类 @EnableCircuitBreaker //添加对熔断的支持
     *
     *测试: 先访问http://localhost:8001/actuator/hystrix.stream
     * 如果一直ping空的,说明没有请求的东西,随便回去请求一个接口
     * 然后在访问,ping就会有数据了,再把这个地址丢到熊那里去,就可以正常访问了,不然就会一直loading
     *
     *
     *
     * 看图 : 圆
     * 实心圆 ,公有2种含义,通过颜色的变化代表了实例的健康程度
     * 其健康程度从绿色<黄色<橙色<红色  递减
     * 大小也会随着实例的请求发生变化,流量越大,实心圆就越大,可以快速发现故障实例和高压力实例
     *
     *  线  记录2分钟内流量的变化,观察流量上升和下降趋势
     *
     *  数字 ; 绿色: 成功(请求)数   橙色 (超时) 蓝色 熔断数 紫色 线程池拒绝数 青色 错误请求 红色 失败/异常
     *
     *  灰色百分比 :最近10s内错误百分比
     *
     *  Host: 0.1/s 服务请求频率
     *  Cluster: 0.1/s
     *  Circuit: Closed 断路状态
     *
     *
     */



}
