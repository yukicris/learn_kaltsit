package com.yukicris.Spring5;

public class sp4 {
    // 依赖注入
    /**
     *
     * 1 构造器注入
     *
     *
     * 2 set 注入(重点)
     *    1  依赖注入: set注入
     *       依赖: bean对象的创建依赖于容器
     *       注入: bean对象的所有属性由容器来注入
     *
     *       环境搭建: {
     *
     *       }
     *
     *
     *
     * 3 其他方式
     *   c明明和p命名空间注入等..
     *
     */


    /**
     * Bean的作用域 scope
     *
     * singleton : 全局只创建一个实例(单例模式)默认是单例的
     *
     *
     * prototype : (原型模式) scope=prototype ,每次从容器中get的时候都是创建新的对象
     *
     * request   :只在web中实现
     *
     * session    :只在web中实现
     *
     * application :只在web中实现
     *
     * websocket
     */

    /**
     * Bean的自动装配      对应   tst4 以及beans4.xml的配置!!!!!!!
     *
     * 自动装配是spring 满足bean依赖的一种方式
     *
     * spring 会在上下文中自动寻找,自动给bean装配属性
     *
     *
     * spring 中有3种装配的方式
     *
     * 1 xml中显示的配置
     *
     * 2 java中显示的配置
     *
     * 3 隐示的自动装配bean
     *
     *
     *      {
     *           <!--byname  会自动在容器上下文中查找和自己set方法后面的值对应的beanId-->
             *     <bean id="person" class="com.yukicris.Spring5.tst4.pojo.Person" autowire="byName">
             *         <property name="name" value="yukicris"/>
             *       <!--  <property name="cat" ref="cat"/>
             *         <property name="dog" ref="dog" />-->
             *     </bean>
     *      }
     *
     *
     *       <!--byType  会自动在容器上下文中查找和自己对象属性类型(Dog,Cat)相同的bean,且类型必须唯一-->
     *     <bean id="person" class="com.yukicris.Spring5.tst4.pojo.Person" autowire="byType">
     *         <property name="name" value="yukicris"/>
     *         <!--  <property name="cat" ref="cat"/>
     *           <property name="dog" ref="dog" />-->
     *     </bean>
     *
     *
     *     byname 的时候,需要保证所有bean的id唯一,且这个bean需要和自动注入的属性的set方法值一致
     *     byType 的时候,需要保证所有bean的class唯一,且这个bean需要和自动注入的属性的类型一致
     *
     *
     *
     *
     *
     */


    /**
     * @Autowired  自动装配
     *
     * 使用注解实现自动装配
     *
     * 使用注解须知:
     *   1 导入约束
     *   2 配置注解的支持
     *
     * <?xml version="1.0" encoding="UTF-8"?>
     * <beans xmlns="http://www.springframework.org/schema/beans"
     *        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
     *    这里     xmlns:context="http://www.springframework.org/schema/context"
     *        xsi:schemaLocation="http://www.springframework.org/schema/beans
     *        http://www.springframework.org/schema/beans/spring-beans.xsd
     *  这里      http://www.springframework.org/schema/context
     *    这里     http://www.springframework.org/schema/context/spring-context.xsd
     * ">
     *
     * // 开启注解的支持以及定义注解所扫描的包
     *  <context:component-scan base-package="com.yukicris.Spring5"/>
     *     <context:annotation-config/>
     *
     * @Autowired 注解
     * 1 直接在属性上使用即可,也可以在set方法上使用
     * 2 使用Autowired 我们可以不用编写set方法了,前提是自动装配的属性在IOC(Spring)容器中存在
     * ,且符合类型byType(默认type 再按name)
     *
     * 科普: @nullable 字段标记了这个注解,说明这个字段可以为null
     *
     *public @interface Autowired {
     *     boolean required() default true;
     *}
     * 默认为true ,如果显示定义了Autowired(required = "false"),说明这个对象可以为null,否则不允许为空
     * @Autowired(required=false)
     * private Cat cat;
     *
     *
     * 如果@Autowired 自动装配的环境比较复杂,自动装配无法通过一个注解[Autowired]完成的时候,我们可以
     * 使用Qualifier(value="xxx")去配合@Autowired的使用,来指定唯一一个对象的使用
     *
     * 同时java自带了一个resource注解,也是先按类型来进行装配,找不到就按名称
     * @Resource(name="cat2")
     * private Cat cat;
     *
     * @Resource
     * private Dog dog;
     *
     */

    /**
     * @Autowired 和@Resource
     *
     * 都是用来自动装配的,都可以放在属性字段上
     * @Autowired 是通过ByType的方式,当匹配到多个同类型的时候,配合@Qualifier使用ByName进行匹配
     * @Resource 默认byName方式自动装配, Autowired只包含一个required参数,resource包含7个参数,尤其是name和type
     *
     */


}
