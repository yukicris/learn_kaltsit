package com.yukicris.Redis.LearnNote1;

public class Nosql3 {


    /**
     * 安装教程
     */



    /**
     * redis是什么
     * Remote Dictionaly Server 远程字典服务
     * 开源 ANSI  c语言编写 支持网络 可基于内存 可持久化 的日志型,KEY-VALUE数据库
     *
     * 称之为结构化数据库
     */

    /**
     * redis 能干嘛
     *
     * 1 内存存储,持久化(断电了也存在里面),内存中是断电即失,所以说持久化很重要(rdb,aof)
     * 2 效率高,可以用于高速缓存
     * 3 发布订阅系统(消息队列)
     * 4 地图信息分析
     * 5 计时器,计时器(浏览量)
     * 6...
     */

    /**
     * 特性
     * 1 多样的数据类型
     * 2 持久化
     * 3 集群
     * 4 事物
     *
     */

    // 学习需要什么
    // https://redis.io
    // 中文 Http://www.redis.cn
    // 下载地址 通过官网下载

    // 注意 ,window在github上下载,停更挺久了
    //Redis 推荐在Linux服务器上搭建,基于linux学习


    /**
     * win 下安装
     * 1 下载安装包
     *    https://github.com/MicrosoftArchive/redis/releases
     * 2 得到压缩包
     * 3 解压到文件夹(最好把相关东西建一个文件夹,叫做环境Eenvioment)
     * 4 双击运行服务即可,默认端口6379
     * 5 使用redis客户端来链接redis(先ping一下,直接输入ping,返回pong即链接成功)
     * set name yukicris ,get name 获取值 没问题就通了
     * windows下确实简单,但是Redis推荐我们用Linux下去开发使用
     *
     */

    /**
     * linux 下安装
     * 1 下载安装包, redis-version.tar.gz
     * 2 解压Redis 的安装包, 放到程序  /opt
     * 3 进入 解压后的文件,可以看到redis的配置文件
     *     1 cd /opt/    2 cd redis-5.0.8(这里用自己的版本)  3 ls
     * 4 基本环境安装
     *      yum install gcc-c++  (gcc -v查看c++的版本)
     *      make
     *      make install
     * 5 redis 默认的安装目录  usr/local/bin   (1 cd /usr/local/bin   2 ls)
     *
     * (插入一点别的Tips
         * 安装6.0以上版本需要升级gcc到5.3及以上,如下：升级到gcc 9.3：
         * yum -y install centos-release-scl
         * yum -y install devtoolset-9-gcc devtoolset-9-gcc-c++ devtoolset-9-binutils
         * scl enable devtoolset-9 bash
         * 需要注意的是scl命令启用只是临时的，退出shell或重启就会恢复原系统gcc版本。
         * 如果要长期使用gcc 9.3的话：
         * echo "source /opt/rh/devtoolset-9/enable" >>/etc/profile
         * 这样退出shell重新打开就是新版的gcc了)
     *
     *
     * 6 将配置文件拷贝到一个目录下(做备份) {
     *     就是说不动原来的配置文件,用我们自己复制出来的做配置文件,对其进行更改
     *     1 mkdir myconfig(新建一个文件夹,推荐文件夹命名)
     *     2 cp /opt/redis-version/redis.conf myconfig
     *     3 cd myconfig/
     *     4 ls (可以看到文件被复制过来了,以后就用这个启动了)
     *          }
     *
     *
     * 7 redis默认不是后台启动的,修改配置文件
     *      vim redis.conf(进入编辑模式,然后按上下进行滑动滚动条)
     *      按i进入insert编辑模式, 修改 daemonize 为yes ,按esc 退出,输入:wq保存退出
     *       (最好加个密码,requirepass ,这个本来被注释掉了,把他放开,在后面加密码)
     *
     *
     *
     * 8 启动redis服务
     *     1  cd usr/local/bin
     *     2  找到redis-server
     *     3  用我定义的配置文件启动 redis-server myconfig/redis.conf
     *    (ps -ef查看端口)
     *
     *
     *
     * 9 调用客户端测试链接
     *    redis-cli -p 6379
     *    ping (返回pong) /如果出现NOAUTH Authentication required,说明有密码,在打开客户端情况下输入密码
     *                     127.0.0.1:6379> auth password,返回ok,然后继续
     *    set name yukicris
     *    get name
     *    keys * (查看所有的key)
     *
     *
     * 10 查看redis的进度是否开启
     *          ps -ef|grep redis ,查看redis-server和redis-cli是否启动
     *
     * 11 如何关闭redis
     * 在连接情况下(redis-cli -p 6379) ,即127.0.0.1:6379>这个状态,输入shutdown
     *  127.0.0.1:6379>shutdown
     *
     *  输入exit 退出,
     *
     *
     * 12 然后去ps -ef|grep redis查看是否存在
     *
     * 13 后面我们会用单机多redis启动集群测试
     *
     *
     */
}
