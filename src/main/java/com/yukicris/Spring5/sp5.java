package com.yukicris.Spring5;

public class sp5 {
    /**
     * 使用注解开发
     *
     */

    // spring4 之后的包,如果要使用注解开发,必须保证aop的包导入了
    // 使用注解需要保证context包的支持

    /**
     *
     *
     * @Compoent: 组件,说明这个类已经被spring管理了
     *
     * 2 属性如何注入
     * @Component
     * Public class User {
     *     public String name;
     *
     *     // 此处的value相当于<property name="name" value ="yukcirs"/>
     *     @value("yukicris")
     *     public void setName(String name) {
     *         this.name = name;
     *     }
     * }
     *
     * 3 衍生的注解
     * @Component 有几个衍生的注解,在web开发中,会按照三层架构分层
     *    {
     *        dao   @Repository
     *        service @Service
     *        controller
     *
     *        这四个注解功能都是一样的,代表将某个类注册到某个容器中进行装配Bean
     *    }
     *
     * 4 自动装配注解
     * @Autowired @Resource
     *
     * 5 xml与注解
     *    xml更加万能,适用于任何场合,维护简单方便
     *    注解不是自己的类使用不了,维护相对复杂
     *
     *
     *    xml与注解的最佳实践
     *    xml负责管理bean,注解负责属性的注入
     *    使用的过程中只需要注意一个问题,必须要注解生效,需要开启注解的支持
     *
     *
     */
}
