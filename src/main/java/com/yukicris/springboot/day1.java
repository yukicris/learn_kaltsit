package com.yukicris.springboot;

public class day1 {
    //复习springboot启动流程
    //https://www.bilibili.com/video/BV1NY411P7VX?spm_id_from=333.337.search-card.all.click&vd_source=240bc6288b8bd53454a480f0c5e8e3e7
    /**
     * 1 springApplication.run(...)->1创建IOC容器,createApplicationContext
     * 2 加载"源"配置类 loadSourceClass (通常是main方法所在的类,一般被注解@SpringBootApplication所修饰,也称之为主类)
     * 3 加载并处理所有的配置类processConfigurationClasses Springboot会找到所有的配置类,然后加载和处理他们,"自动配置"属于其中一环
     * 4 实例化所有的单例bean instantiateSingletonBeans  实例化所有的单例Bean,依赖注入和自动装配属于其中的环节
     * 5 启动web服务器 startWebServer  tomcat啥的
     *
     */


    /**
     * 自动配置
     * 加载并处理所有的配置类processConfigurationClasses
     *
     * 1 处理@ComponentScan  根据@ComponentScan 扫描指定的package, 递归处理得到一系列的配置类
     * 2 处理注解@Import  根据注解@Import,得到一系列被导入的配置类
     * 3 处理@Bean方法
     * 4 处理@Import导入的ImportBeanDefinitionRegistrar 注册器
     * 5 加入一个全局的配置类集合中
     *
     * 通俗说,就是通过不断遍历@ComponentScan和@IMPORT注解递归遍历所有的配置类,直到没有,然后把配置类集合注册到IOC容器中
     * 再处理配置类中的@Bean方法,将其返回类型注册到IOC容器中,并将得到的BeanDefinition注册到IOC容器中
     */


    /**
     * @ComponentScan  是来自Spring框架的一个注解(一般启动类会放一个)
     *  对指定的package进行扫描,找到其中符合条件的类,默认搜索@component修饰的配置类
     *  通过属性basePackages或者basePackageClass,来指定要进行扫描的pacakge
     *  如果未指定,则默认扫描当前@ComponentScan所修饰的类所在的package
     */

    /**
     * @Import
     * 他是提供一种显式的从其他地方加载配置类的方式,可以避免使用性能较差的组件扫描(Component Scan)
     *
     * 支持导入:
     * 普通类
     * 接口ImportSelector的实现类
     * 接口ImportBeanDefinitionRegistrar的实现类
     */


    /**
     * 原理解析
     *
     * @SpringBootApplication ->{
     *     1 @SpringBootConfiguration->@Configuration
     *     2 @EnableAutoCinfiguration->@Import(AutoConfigurationImportSelector.class)
     *     3 @ComponentScan
     *
     * }
     *
     * 1 @SpringBootApplication 修饰的类,也会被Configuration 间接修饰,即 '源配置类'
     * 2 所以,SpringBoot框架会对源配置类所在的package进行组件扫描(Component Scan)
     * 3 SpringBoot框架最终会导入AutoConfigurationImportSelector的选择器来实现自动配置
     *
     * 而这个AutoConfigurationImportSelector的实现,使用到了SpringFactories机制
     * 它是JavaSpi机制的延伸与扩展,而且在spring以及sprignboot源码中随处可见
     * 可以基于它来实现Springbot的自动配置功能
     *
     *
     * SpringFactories机制:核心逻辑是从classpath中读取到所有的Jar包中的配置文件META-IF/spring.factories,然后根据指定的key从
     * 配置文件中解析出对应的value值
     *
     */

    /**
     * 注解@Conditional是来自spring框架的一个注解
     * 它的作用是实现 只有在特定条件满足是,才会想IOC容器注册指定的组件
     * 可以将@Conditional理解为某种IF语句
     */

    // 原理图https://www.processon.com/view/link/5efc4ffa6376891e81f3895d
}
