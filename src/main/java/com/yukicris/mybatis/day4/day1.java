package com.yukicris.mybatis.day4;

public class day1 {
    /**
     * 注解开发
     *
     * 适用于简单查询语句,对于复杂语句会显得力不从心
     * 还是见practice11
     *
       1  @Select("select * from user.users")
        List<User> getUsers();
       2  然后去核心配置类绑定接口


     注解原理还是反射,底层是动态代理
     */

  //我们可以在工具类创建的时候实现自动提交事务
  /*  public  static SqlSession getSqlSession(){

        return sqlSessionFactory.openSession(true);
    }*/
    /**\
     * 增删改查
     *
     *  1  @Select("select * from user.users where id =#{id}")
     *         List<User> getUsers(@Param("id") int id);
     *
     *     @Select("select * from user")
     *     List<User> getUsers();
     *
     *    //方法存在多个参数，所有的参数前面前面必须加上 @Param("") 注解
     *     @Select("select * from user where id=#{id}")
     *     User getUserByID(@Param("id") int id);
     *
     *     @Insert("insert into user(id,name,pwd) values(#{id},#{name},#{password})")
     *     int addUser(User user);
     *
     *     @Update("update user set name=#{name},pwd=#{password} where id=#{id}")
     *     int updateUser(User user);
     *
     *     @Delete("delete from user where id=#{uid}")

     */


    /**
     * Lombok
     * <dependency>
     *     <groupId>org.projectlombok</groupId>
     *     <artifactId>lombok</artifactId>
     *     <version>1.18.12</version>
     *
     * </dependency>
     *
     * @Data:无参构造，get,set,toString,hashcode,equals
     * @AllArgsConstructor
     * @NoArgsConstructor
     * @Getter and @Setter
     * @ToString
     */
}
