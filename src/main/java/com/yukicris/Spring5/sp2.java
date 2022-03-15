package com.yukicris.Spring5;

public class sp2 {
    /**
     *     <bean id="hello" class="com.yukicris.Spring5.tst2.pojo.Hello">
     *         <property name="str" value="Spring"/>
     *     </bean>
     *
     *     使用spring 创建对象,在spring中这些都称之为bean
     *
     *     类型 变量名 = new 类型()
     *     Hello hello = new Hello()   // java中的写法
     *
     *     bean中的id = 变量名
     *     bean中的class 等于new 的对象,把new对象的这一步交给了spring来做
     *     property 相当于给对象中的属性设置一个值
     *
     *     此处以后,实现不同的操作,只需要在xml配置文件中进行修改,所谓的ioc ,对象由spring创建,管理装配
     *     DI是ioc的一种实现形式
     */
}
