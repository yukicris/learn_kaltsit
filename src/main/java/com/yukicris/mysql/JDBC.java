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
}
