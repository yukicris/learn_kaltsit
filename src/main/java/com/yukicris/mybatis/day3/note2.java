package com.yukicris.mybatis.day3;

public class note2 {
    /**
     * 日志
     */
    //日志工厂
    //如果一个数据库操作,出现了异常,需要排错,日志就是最好的助手
    //以前 sout,debug
    //现在可以使用logImpl,指定mybatis所用日志的具体实现,未指定时将自动查找

    /**
     * 以下常用3点
     */
    //SLF4J
    //LOG4J
    //STDOUT_LOGGING

    //在mybatis中具体使用哪一个日志,在设置中进行调解
    //默认为STDOUT_LOGGING
/*     <settings>
        <setting name="logImpl" value="STDOUT_LOGGING"/>
    </settings>*/


    /**
     * log4j是外部包,需要单独引入
     */
   /*  <settings>
        <setting name="logImpl" value="LOG4J"/>
    </settings>*/
    /* <dependency>
           <groupId>log4j</groupId>
           <artifactId>log4j</artifactId>
           <version>1.2.17</version>
    </dependency>*/

 /*   ### 配置根 ###
    log4j.rootLogger = debug,console,file


### 配置输出到控制台 ###
    log4j.appender.console = org.apache.log4j.ConsoleAppender
    log4j.appender.console.Target = System.out
    log4j.appender.console.Threshold = debug
    log4j.appender.console.layout = org.apache.log4j.PatternLayout
    log4j.appender.console.layout.ConversionPattern =  %d{ABSOLUTE} %5p %c{1}:%L - %m%n

### 配置输出到文件 ###
    log4j.appender.file = org.apache.log4j.FileAppender
    log4j.appender.file.File = ./log/qjd.log

    log4j.appender.file.Append = true
    log4j.appender.file.Threshold = debug

    log4j.appender.file.layout = org.apache.log4j.PatternLayout
    log4j.appender.file.layout.ConversionPattern = %-d{yyyy-MM-dd HH:mm:ss}  [ %t:%r ] - [ %p ]  %m%n

### 配置输出到文件，并且每天都创建一个文件 ###
    log4j.appender.dailyRollingFile = org.apache.log4j.DailyRollingFileAppender
    log4j.appender.dailyRollingFile.File = logs/log.log
    log4j.appender.dailyRollingFile.Append = true
    log4j.appender.dailyRollingFile.Threshold = debug
    log4j.appender.dailyRollingFile.layout = org.apache.log4j.PatternLayout
    log4j.appender.dailyRollingFile.layout.ConversionPattern = %-d{yyyy-MM-dd HH:mm:ss}  [ %t:%r ] - [ %p ]  %m%n

### 设置输出sql的级别，其中logger后面的内容全部为jar包中所包含的包名 ###
    log4j.logger.org.mybatis=debug
    log4j.logger.java.sql=debug
    log4j.logger.java.sql.Connection=debug
    log4j.logger.java.sql.Statement=debug
    log4j.logger.java.sql.PreparedStatement=debug
    log4j.logger.java.sql.ResultSet=debug*/



    /**
     * 使用时引入对象static  Logger logger = Logger.getLogger(UserMapperTest.class);
     *
     * logger.info()
     * logger.debug()
     * loggger.error()
     * */


}
