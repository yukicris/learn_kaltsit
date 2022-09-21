package com.yukicris.mybatis.day2;

public class note3 {
    /**
     * 映射器mappers
     */
    //MapperRegistry注册绑定我们的Mapper文件
    //方式一
   /*  <mappers>
        <mapper resource="yukicris/dao/UserMapper.xml"></mapper>
    </mappers>*/

    /*方式二*/
    //使用class文件注册
    //这个是有要求的,不然就用不了:1 接口必须和Mapper配置文件同名 2接口和它的Mapper配置文件必须在同一个包下
  /* <mappers>
        <mapper resource="yukicris.dao.UserMapper"></mapper>
    </mappers>*/

    /*方式三*/
    //使用扫描包进行注入绑定
    //也是要求:1 接口必须和Mapper配置文件同名 2接口和它的Mapper配置文件必须在同一个包下
    /* <mappers>
        <mapper resource="yukicris.dao"></mapper>
    </mappers>*/
}
