package com.yukicris.Spring5;

public class sp3 {
    /**
     * ioc创建对象的方式
     * 对应tst3 的代码内容
     *
     * 1 默认使用无参构造创建对象,默认
     *
     * 2 假设需要使用有参构造创建对象
     *      1 下标赋值
     *      <bean id="user" class="com.yukicris.Spring5.tst3.pojo.User">
     *         <!-- 现在由于构造器变成有参的了,那么就无法使用默认无参构建bean了-->
     *         <!--1 下标赋值法-->
     *         <constructor-arg index="0" value="yukicris" />
     *     </bean>
     *
     *     2 类型赋值
     *      <bean id="user" class="com.yukicris.Spring5.tst3.pojo.User">
     *          <!--2 通过类型创建,不建议使用,多个类型相同会按照xml顺序赋值-->
     *         <constructor-arg type="java.lang.String" value="yukicris"></constructor-arg>
     *      </bean>
     *
     *
     *       <bean id="user" class="com.yukicris.Spring5.tst3.pojo.User">
     *          <!--3 直接通过参数名来设置-->
     *         <constructor-arg name="name" value="yuki cris" />
     *      </bean>
     *
     *
     *
     * spring 容器相当于把对象都丢给一个叫spring 的婚介所去管,然后有需要的时候再去找自己需要的对象
     *
     * 在配置文件加载的时候,容器中管理的对象就已经初始化了,无论调用多少个都是同一个实例
     */


    /**
     * spring 的配置
     *
     * 1 别名 alias
     * <bean id="user" class="com.yukicris.Spring5.tst3.pojo.User">
     *     <constructor-arg name="name" value="yuki cris" />
     *  </bean>
     *
     *  给这个bean 为user 取个别名,如果添加了别名,可以使用别名获取到对象
     *  <alias name="user" alias="user2"></>
     *
     *2 bean的配置
     *
     *    id :bean的唯一标识符,相当于对象名
     *    class: bean对象所对应的全限定名: 包名+类型
     *    <bean> 里面的name(不是property) :也是别名,而且name可以同时取多个别名name="u1,u2,u3.."
     *
     *     <bean id="mysqlImpl" class="com.yukicris.Spring5.tst1.dao.UserDaoMysqlImpl" >
     *     </bean>
     *
     * 3 import
     *  <?xml version="1.0" encoding="UTF-8"?>
     * <beans xmlns="http://www.springframework.org/schema/beans"
     *        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
     *        xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
     *
     *
     *     <import resource="beans1.xml"></import>
     * </beans>
     *
     * 这个import  一般用于团队开发使用,可以将多个配置文件导入合并为一个个体
     *
     * 假设,有多个人开发,每个人负责不同的类开发,不同的类注入到不同的beans中,可以利用import将所有人的beans.xml合并为一个总的
     *
     *
     * applicationConmtext.xml包含:{ beans1.xml,beans2.xml,...}
     * 多个重名bean标签,会取最后一个bean来创建对象,即后面的覆盖前面的
     */
}
