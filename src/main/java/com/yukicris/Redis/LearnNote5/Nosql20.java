package com.yukicris.Redis.LearnNote5;

public class Nosql20 {
    /**
     * 配置文件详解
     */
    /**
     * 1 unit单位 对大小写不敏感
     * 2 include: 包含,可以拼接多个配置文件
     * // 网络
     * 3 bind 绑定的ip,可以直接注释掉或者加*
     * protected -mode = yes 保护模式
     * port:6379 端口
     *
     * // 通用
     *
     * daemonize yes 以守护方式运行,默认是no,需要我们自己开启为yes
     *
     * pidfile /var/run/redis_6379.pid  : 如果是以后台的方式运行,就需要指定一个pid文件
     *
     * loglevel notice : 日志级别,关注的
     *
     * logfile ""  默认为空,日志文件的位置名
     * database 16  默认有16个数据库
     * always-show-logo yes 是否显示log
     *
     *
     * // 快照
     * 持久化,在规定的时间内,执行了多少次操作,则会持久化到文件,.rdb .aof
     *
     * redis是内存数据库,如果没有持久化,那么数据库断点即失
     *
     * //如果900内,如果有至少一个key进行了修改,,就进行持久化修改
     * save 900 1
     * //如果300内,如果有至少10个key进行了修改,,就进行持久化修改
     * save 300 10
     * //..
     * save 60 1000
     * 后面会定义自己的持久化
     *
     *
     * stop-writes-on-bgsave-error yes 持久化如果出错,是否还需要继续工作
     *
     * rdbcompression yes : 是否压缩rdb文件,需要消耗一定的cpu资源
     * rdbchecksum yes : 保存rdb文件的时候,进行错误的检查校验
     *
     * dir ./  rdb文件保存的目录
     *
     *
     *
     * // replication 主从复制相关配置
     *
     *
     * //security 安全
     * 可以在这里设置redis的密码,默认是没有密码的
     * config get requirepass  获取redis的密码
     * config set requirepass "123456"
     * auth 密码 用密码进行登录
     *
     *
     * client 客户端
     * maxclients 10000 设置能连接的最大客户端数量 : 10000
     * maxmemory<bytes>  设置最大内存容量
     *
     * maxmemory-policy noeviction 内存达到上线后的处理策略
     *      1、volatile-lru：只对设置了过期时间的key进行LRU（默认值）
     *
     *      2、allkeys-lru ： 删除lru算法的key
     *
     *      3、volatile-random：随机删除即将过期key
     *
     *      4、allkeys-random：随机删除
     *
     *      5、volatile-ttl ： 删除即将过期的
     *
     *      6、noeviction ： 永不过期，返回错误
     *
     * append only 模式 aof配置
     * appendonly no 默认不开启aof模式,默认是使用rdb方式持久化,在大部分所有情况下,rdb完全够用
     * appendfilename "appendonly.aof" 持久化的文件名字
     *
     * # appendfsync always    :每次修改都会sync(同步),消耗性能
     * appendfsync everysec  : 每秒执行一次sync ,可能会丢失这一秒的数据
     * appendfsync no : 不执行sync,这个时候操作系统自己同步数据,速度最快
     *
     *
     *
     *
     *
     */
}
