package com.yukicris.mybatis.day2;

public class note2 {
    //起名优化

    /**
     * 不过默认不允许使用别名,因为会导致找不到主类
     *
     */

    //去mybatis-config里面写
    //方法1 ,一个实体类一个固定的别名
    /*  <typeAliases>
        <typeAlias type="yukicris.pojo.User" alias="User"></typeAlias>
    </typeAliases>*/
    //方法2 ,指定包名,然后使用的时候用包里的类名首字母小写,比如resultType=user
     /*<typeAliases>
        <typeAlias type="yukicri5s.pojo"</typeAlias>
    </typeAliases>*/

    //区别,第一种可以自己定义别名,第二种就不行
    //但是第二种可以通过注解实现
    /*@Alias("user")
    public class User{

    }*/

    /**传参别名*/
    //另外,返回值传入值,这种别名 ,基本数据类型 用别名的话前面加个_  比如_byte对应byte,_int对应int
    //包装类型就直接用小写 string 对应String,map对应Map


    /**
     * 设置
     */
    //补充一个冷知识,oracle是默认全大写,last_name这种会识别成LAST_NAME,所以一般加_方便阅读,mysql不区分大小写
    //cacheEnabled 全局地开启或者关闭配置文件中所有的映射器已经配置的任何缓存
    // lazyLoaingEnabled 延迟加载的全局开关,开启扇所有关联对象都会延迟加载,特定关联关系可以通过设置fetchType属性来覆盖该项的开关状态
    // 懒加载通俗的说就是分步加载、按需加载；需要的时候再去操作
    //logImpl	指定 MyBatis 所用日志的具体实现，未指定时将自动查找。


    /*
    <settings>
  <setting name="cacheEnabled" value="true"/>
  <setting name="lazyLoadingEnabled" value="true"/>
  <setting name="multipleResultSetsEnabled" value="true"/>
  <setting name="useColumnLabel" value="true"/>
  <setting name="useGeneratedKeys" value="false"/>
  <setting name="autoMappingBehavior" value="PARTIAL"/>
  <setting name="autoMappingUnknownColumnBehavior" value="WARNING"/>
  <setting name="defaultExecutorType" value="SIMPLE"/>
  <setting name="defaultStatementTimeout" value="25"/>
  <setting name="defaultFetchSize" value="100"/>
  <setting name="safeRowBoundsEnabled" value="false"/>
  <setting name="mapUnderscoreToCamelCase" value="false"/>
  <setting name="localCacheScope" value="SESSION"/>
  <setting name="jdbcTypeForNull" value="OTHER"/>
  <setting name="lazyLoadTriggerMethods" value="equals,clone,hashCode,toString"/>
</settings>*/
}
