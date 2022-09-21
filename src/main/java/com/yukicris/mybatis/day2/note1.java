package com.yukicris.mybatis.day2;

public class note1 {
    /**
     * 配置解析和优化
     */

    /**
     * 核心配置文件
     * 尽管可以配置多个环境，但每个 SqlSessionFactory 实例只能选择一种环境。
     */
    //mybatis-config.xml
  /*  1、configuration（配置）
      2、properties（属性）
      3、settings（设置）
      4、typeAliases（类型别名）
      5、typeHandlers（类型处理器）
      6、objectFactory（对象工厂）
      7、plugins（插件）
      8、environments（环境配置）
      9、environment（环境变量）
      10、transactionManager（事务管理器）
      11、dataSource（数据源）
      12、databaseIdProvider（数据库厂商标识）
      13、mappers（映射器）
   */

    // 2 环境配置
    // <environments default="development"> 这里用来切换环境,也就是开发环境测试环境等等,被spring集成去了

    /*
    *  <environment id="test">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="driver" value="com.mysql.jdbc.Driver"/>
                <property name="url" value="jdbc:mysql://localhost:3306/user?useSSL=true&amp;useUnicode=true&amp;characterEncoding=UTF-8"/>
                <property name="username" value="root"/>
                <property name="password" value="123456"/>
            </dataSource>
        </environment>
    *
    * */

    /**
     * 上面的  <transactionManager type="JDBC"/> 这里事务管理器,默认的jdbc,直接使用了jdbc的提交和回滚机制,还有一种Managed ,但是过时了用的不多
     *
     * datasource 数据源 dbcp c3p0 druid hykari(springboot默认集成的)
     *
     * 类型 unpooled 每次请求时打开和关闭链接,虽然有点慢,但是对于在数据库链接可用性方面没啥要求的简单应用上来说,是个好选择
     * pooled "池子"的概念: 用完就可以回收给下个人接着用,不会直接注销掉数据源,可以让web响应更快
     * */

    /*mybatis默认事务管理是JDBC,链接池Pooled*/

    // 3 优化
    //可以通过properties实现引用配置文件,这些属性都是可以动态替换的,可以在典型的Java属性文件中配置,也可以通过properties元素的子元素来传递[db.properties]
    //先建一个db.properties,然后在核心配置文件中引入
    /*
    driver=com.mysql.jdbc.Driver
    url=jdbc:mysql://localhost:3306/user?useSSL=true&useUnicode=true&characterEncoding=UTF-8
    username=root
    password=123456
    */
    //config核心配置文件中<properties>标签必须按顺序排,也就是放在上面
    //注意下我11的那个例子里头的usermapper的resultType漏了个com..然后对应的mybatis那边也要把com删了

    //可以在db.properties里面写一半,然后在配置文件里写另外一半,优先走外部配置文件
   /* <properties resource="db.properties">
       <!-- <property name="username" value="root"/>-->
    </properties>*/
}
