package com.yukicris.mybatis.day1;

public class note1 {
    //妈的北科那套封装了个base.Mapper好蠢,所有的mapper继承那个baseMapper,搞得mapper都可以用正删改查
    //现在mybatis反而不会用了
    //再快速过一遍



    //新建mybatis项目,在yukicris那边写的
    //导入依赖
    //mybatis依赖,sql驱动依赖,junit依赖
    //编写配置文件
    /**
     * 见yukicris_practice的10,里面resource,这个文件后续会被springboot的配置给集成掉
     */
    //编写配置类
    /**
     * 每个mybatis的应用都是以SqlSessionFactory为实例核心,SqlSessionFactory实例可以通过SqlSessionFactoryBuilder获得,SqlSessionFactoryBuilder
     * 可以通过xml配置文件或者一个预先定制的Configuration实例中构建出SqlSessionFactory的实例
     */
    /*
    * public class MybatisUtils {
    //放到外头提升下作用域
    private static SqlSessionFactory sqlSessionFactory;

    static{
        try {
            //下面3句是死的,官方定义的
            //使用mybatis的第一步,获取sqlSessionFactory对象
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //既然有了SqlSessionFactory,顾名思义,可以从中获得SqlSession 的实例了

    //SqlSession完全包含面向数据库执行sql命令的所有方法
    public static SqlSession getSqlSession(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession;
    }
}
    * */


    //编写代码
    /**
     * 1 实体类
     * pojo.User
     *
     * 2 dao接口
     * public interface UserDao {
     *     List<User> getUserList();
     * }
     *
     *
     *
     * 3 接口实现类,由原来的UserDaoImpl文件转换成一个Mapper文件
     * <?xml version="1.0" encoding="UTF-8" ?>
     * <!DOCTYPE mapper
     *         PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
     *         "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
     *
     *
     * <!--namespace要绑定一个对应的dao/mapper接口-->
     * <mapper namespace="com.yukicris.dao.UserDao">
     *
     *
     *
     *     <select id="getUserList" resultType="com.yukicris.pojo.User">
     *         select * from user.users
     *     </select>
     * </mapper>
     *
     * 4 测试
     * junit
     * BindingException:Type interface...类型接口
     * 这个地方是漏了个Mapper注册文件,见yukicris配置文件
     */
     /*把这块补进pom文件即可,可以让配置文件不失效*/
    //      <build>
//        <resources>
//            <resource>
//                <directory>src/main/resources</directory>
//                <includes>
//                    <include>**/*.properties</include>
//                    <include>**/*.xml</include>
//                </includes>
//            </resource>
//            <resource>
//                <directory>src/main/java</directory>
//                <includes>
//                    <include>**/*.properties</include>
//                    <include>**/*.xml</include>
//                </includes>
//                <filtering>true</filtering>
//            </resource>
//        </resources>
//    </build>

//    <properties>
//        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
//    </properties>


    /*另外一个坑Exception in thread "main" org.apache.ibatis.exceptions.PersistenceException:

        Error querying database. Cause: java.sql.SQLException: Error setting driver on UnpooledDataSource.
        Cause: java.lang.ClassNotFoundException: Cannot find class: com.mysql.cj.jdbc.Driver

        这个问题是因为配置文件中有中文,或者mybatis-config里面的ssl为true,或者是单纯的我遇到的,Drive不能点出下划线..
     */

    /**
     * 在执行增删改的时候,必须要提交事务,sqlSession.commit,见例子10的测试部分代码
     *
     * */


    /**
     * 万能Map,当实体类或者数据库中的表的字段或者参数过多,应该考虑使用map
     * Map传递参数,直接在sql中取key即可  parameterType="map"
     * 对象传递参数,直接在sql中取对象的属性即可  parameterType="Object"
     */
    //   //企业里面不太规范但很实用的玩法
    //    //使用一个万能的map,不需要知道User里面有多少参数,,有100个我也不管
    //    int addUser2(Map<String,Object> map);


    /**
     * 模糊查询,通配符%%
     *
     * 在sql拼接中,${}是字符串替换拼接,而#{}是占位符,自动给他加一个单引号,可以防止注入
     * select * from user where id = {1},这里的1 可以替换为 1 or 1=1,就会把所有的都查出来,导致注入问题
     *
     * 所以做模糊查询最好能够直接把值限制完 比如直接传一个   %1%
     */

}
