package com.yukicris.mybatis.day3;

public class note1 {
    //生命周期和作用域(至关重要) 错误使用会导致严重的并发问题
    /**
     * SqlSessionFactoryBuilder:创建SqlSessionFactory一旦创建就不需要他了
     *
     * sqlSessionFactory:说白了就可以想象成数据库连接池,一旦被创建就一直存在,没有理由再去创建一个实例
     * 所以SqlSessionFactory最佳作用域是应用作用域(程序全局),单例模式或者静态单例模式
     *
     *
     * sqlSession: 可以理解为连接到连接池的请求,他不是线程安全的,最佳作用域是请求或者方法作用域
     * 用完以后需要赶紧关闭,否则资源被占用
     * 换句话说,就是每次收到HTTP请求,打开一个SqlSession,返回一个响应,然后马上关闭它
     *
     *
     *
     */

    //整个声明周期大概为  建造工厂builder生产一个代理工厂factory然后倒闭了(直接关闭builder),代理工厂把负责把物品(sqlSession)
    //租赁给用户(用户发起请求租赁)sqlSession(物品),然后用户拿到物品后进行各种各样使用Mapper(增删改查),使用完后必须把物品还回去,即
    // 关闭sqlSession避免资源浪费

    //5解决属性名和字段名不一致的问题
    //用resultMap
  /*  <resultMap id="UserMap" type="User">
    <!--column数据库中的字段，property实体类中的属性-->
    <result column="id" property="id"/>
    <result column="name" property="name"/>
    <result column="pwd" property="password"/>
     </resultMap>*/
}
