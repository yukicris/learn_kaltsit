package com.yukicris.mysql;

public class JDBC {
    /**
     * Java Databse Connectivity
     * 数据库链接驱动
     * (代码参考yukicris项目练习7中的Testjdbc)
     *
     * 1 首先需要包的支持:
     *      {
     *          1 java.sql
     *          2 javax.sql
     *          3 mysql-connector-java...连接驱动(必要)
     *
     *      }
     *
     * 2 新建测试表
     *      {
     *          1 建表
     *
     *          CREATE TABLE users(
     * 	           id int primary key,
     * 	           name VARCHAR(40),
     * 	           password VARCHAR(40),
     * 	           email VARCHAR(60),
     * 	           birthday DATE
     *          );
     *
     *          2 插入数据
     *          INSERT INTO users (id, name,password, email, birthday)
     *          VALUES
     *          	(
     *          		1,
     *          		'张三',
     *          		'123456',
     *          		'zs@qq.com',
     *          		'2000-01-01'
     *          	);
     *          INSERT INTO users (id, name,password, email, birthday)
     *          VALUES
     *          	(
     *          		2,
     *          		'李四',
     *          		'123456',
     *          		'ls@qq.com',
     *          		'2000-02-02'
     *          	);
     *          INSERT INTO users (id, name,password, email, birthday)
     *          VALUES
     *          	(
     *          		3,
     *          		'王五',
     *          		'123456',
     *          		'ww@qq.com',
     *          		'2000-03-03'
     *          	);
     *
     *      }
     *
     *      idea测试连接数据库,如果链接有问题,就去mysql安装目录找ini那个文件,加个时区轴
     *      default-time-zone = '+8:00'
     *
     *      win下重启可以直接去计算机-管理-服务里面重启
     *
     *
     *
     *
     */

    /**
     * 流程:
     *   {
     *       1 导入数据库依赖
     *       2 idea引入数据库,右键idea右边的database,先从左边选择driver,下载,然后配置root 123456
     *
     *
     *       jdbc 固定步骤
     *          1 加载驱动
     *          2 连接数据库
     *          3 向数据库发送sql的对象 Statement:CRUD
     *          4 编写sql(根据业务)
     *          5 执行sql
     *          6 关闭连接
     *   }
     */


    /**
     * 事务
     *
     * 要么都成功,要么都失败
     *
     * ACID原则保证数据安全: 原子性 一致性 隔离性 持久性  (脏读,幻读,不可重复读 )
     *      原子性: 要么都成功,要么都失败,错误就回滚
     *      一致性: 事务开始前和开始后,数据库完整性不被破坏,符合预设规则,比如1000新增200再删除200还是1000
     *      隔离性: 各个用户并发事务同时执行,互相不受影响
     *      持久性: 断电宕机数据不丢失,一旦提交就不可逆
     *
     * 脏读:一个事务读取到了另一个事务未提交的数据(读未提交)
     * 不可重复读: 一个事务内读取某一行数据,多次读取结果不同(我读的时候又被人提交了新的数据) 侧重于更改
     * 幻读: 一个事务内读取到了别的数据插入的数据,导致前后不一致(比如多读出来一行) 侧重于新增与删除
     *
     *
     * 开启事务
     * 事务提交   commit
     * 事务回滚   rollback
     * 关闭事务
     *
     *
     */

    /**
     * 单元测试
     *
     * 依赖Junit
     *  <dependency>
     *             <groupId>junit</groupId>  <!--单元测试-->
     *             <artifactId>junit</artifactId>
     *             <version>4.12</version>
     *  </dependency>
     *
     * @Test 注解只作用于方法之上,加了这个方法就可以直接运行
     *
     */


    /**
     * 索引
     * Mysql官方对索引的定义为: 索引 Index是帮助mysql高效获取数据的数据结构,即 索引是一种数据结构
     *
     * 分类:
     *      主键索引 primary key
     *          唯一标识 ,主键不可重复,只能有一个列作为主键
     *
     *      唯一索引 unique key
     *          唯一索引可以有多个,保证某一列的值具有唯一性
     *      常规索引 key/index
     *          默认的,用index.key等关键字设置
     *      全文索引 fullText
     *          特定的数据库引擎下才有,MyISAM
     *          快速定位数据
     *
     *  显示所有的索引信息
     *  show index from student
     *
     *  增加一个全文索引(可以是其他索引)
     *  Alter Table 'student' add fullText index 'studentName' ('studentName')
     *
     *
     *
     *
     *  复合索引
     *  建表时创建的写法
     *  create table t user3(id,varchar(20) primary key,name varchar(20),age int,key(name,age)); //设置name,age 为索引
     *
     *  面试问题:
     *  如果我建立一个索引 为 name,age,bir 复合索引
     *
     *  我查询 name,bir,age 能否利用索引   这种可以,会动态调整
     *  查询name,age,bir能否利用索引   这种可以
     *  age,bir  能否利用索引    不行
     *  bir,age,name 能否利用索引    可以,也包含左前缀
     *  age,bir 能否利用索引   这种也不行
     *
     *  1 最左前缀的原则   2 mysql引擎在查询中未来更好利用索引,在查询过程中会动态调整字段顺序以便利用索引
     *
     *  带头大哥不能死，中间兄都不能断(左前缀原则)，索引列上无操作(不能添加函数,计算,类型转换等)，范围右边全失效(查询范围值,比如age>25会失效,匹配到等于就停止了)，like百分加右边(以%开头查询like会失效)，字符串中有引号(不加引号会让mysql底层做类型转换加上引号,导致与列上无操作冲突)
     *  https://blog.csdn.net/suo_jia_hao/article/details/117995566
     **/

}

