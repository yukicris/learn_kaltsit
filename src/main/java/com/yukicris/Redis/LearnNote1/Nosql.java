package com.yukicris.Redis.LearnNote1;

public class Nosql {

    /**
     * 0 - 2为理论
     * 为什么要使用Nosql
     *
     *  历史解析
     *
     * 大数据时代
     * 一般的数据库无法分析
     *
     *
     * 1 Mysql年代
     *   APP(网页) -> DAL -> Mysql
     *   90年代一个基本网站访问量不大,单个数据库完全足够
     *   大多数是静态网页(hao123),服务器没什么压力
     *   这个时候的瓶颈:
     *       1 数据量过大的时候,一个机器放不下
     *       2 数据的索引,超过300万就要建立索引了(MySQL索引使用了B+Tree),一个机器内存也放不下
     *       3 访问量(读写混合) ,一个服务器承受不了
     *
     *  只要开始出现以上三种情况之一,就要晋级
     *
     *  2 Memcached(缓存) + Mysql + 垂直拆分 (分库分表,读写分离)
     *    网站80%的情况都是在读,每次都要去查询数据库会非常麻烦,所以需要减轻数据库的压力,所以用缓存保证效率
     *    (缓存主要解决读问题)
     *
     *    app -> dal -> cache -> { mysql1 <同步> mysql2 <同步> mysql3
     *
     *  3 分库分表,水平拆分  + mysql集群
     *   本质 : 数据库的读,写
     *   早些年 MyISAM引擎: 表锁,(一个表的查询跑完才锁),十分影响效率,高并发下会出现很严重的问题
     *   转战Innodb: 行锁
     *   慢慢的开始使用"分库分表"解决写的压力,那个时候推出了表分区,但是没有多少公司用
     *   然后推出了集群
     *
     *
     *  4 如今的年代
     *  世界翻天覆地的变化, Mysql关系型数据库不够用,数据量多,变化快
     *
     *  mysql 有的人使用他存储比较大的文件,博客,图片; 数据量大,效率低了,如果有一种数据库专门处理这种数据,
     *  mysql的压力就小了,大数据的IO压力下,表几乎没办法更大
     *
     *  5 目前一个基本的互联网项目
     *      (有个很大的架构图,暂时不需要了解)
     *
     *
     *  6 为什么要用Nosql
     *  用户个人信息,社交网络,地理位置,用户自己产生的数据,用户日志等爆发式增长
     *  这个时候就要用Nosql
     *
     */
}
