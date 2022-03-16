package com.yukicris.Spring5;

public class sp8 {

    /**
     * 什么是aop
     *
     * 面向切面编程, 通过预编译方式和运行期间动态代理实现程序功能的统一维护的一种技术
     *
     * 切面ASPECT: 横切关注点被模块化的特殊对象,即她是一个类  比如我要给功能中增加的log类
     * 通知Advice: 切面必须完成的工作,即类中的方法    比如log中的方法
     * 目标Target: 被通知对象
     * 代理Proxy: 向目标对象应用通知后创建的对象
     * 切入点PointCut 切面通知执行的"地点" 的定义
     * 链接点JointPoint 与切入点匹配的执行点
     *
     */


    /**
     * 导入包
     *
     * <dependency>
     *     <groupId>org.aspectj</groupId>
     *     <artifactId>aspectjweaver</artifactId>
     *     <version>1.9.4</version>
     * <dependency>
     */

    // 方式一 : 使用spring的api来实现接口

    // 方式二 ; 自定义实现aop(切面定义)

    // 方式三 ; 使用注解实现


}
