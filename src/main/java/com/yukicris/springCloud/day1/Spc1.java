package com.yukicris.springCloud.day1;

public class Spc1 {

    /**
     *  1 回顾之前的知识
     *
     *  JavaSE
     *  数据库
     *  前端
     *  Servlet
     *  Http
     *  Mybatis
     *  Spring
     *  SpringMvc
     *  SpringBoot
     *  Dubbo,Zookeeper,分布式基础
     *  Maven,Git
     *  Ajax,json
     *  Nginx
     */

    /**
     * 先补一下分布式 Dubbo Zookeeper
     *
     *
     * 分布式系统: 是若干个独立计算机的集合,这些计算机对于用户来说就像是单个相关系统
     *           是一组通过网络进行通信,为了完成共同的任务而协调工作的计算机节点组成的系统,分布式系统的出现是为了用廉价的,普通的机器完成单个计算机无法完成
     *           的计算,存储任务,目的在于用更多的机器处理更多的数据 (用一堆机器来做不同的事情)
     *
     *
     *      比如我访问淘宝,对于用户就是一个服务,但是对于淘宝,需要许多的独立服务器(分别处理订单, 资金, 物流, 评价等等等等),服务器直接互相交流有2种,HTTP和RPC
     *
     *
     * 单体架构-> mvc架构(缺点,公共模块无法复用,比如用户注册等) -> 流动计算架构 (SOA[资源调度和治理中心] :增加一个调度中心基于访问压力试试管理集群容量,提高集群利用率)
     *
     *
     *
     * HTTP (超文本传输协议) 无状态通讯协议
     *
     * RPC (远程过程调用) 本地过程调用: 我在家用家里的洗衣机洗衣服  ,RPC 我在外头让家里人帮我用洗衣机洗衣服
     *      是一种进程间的通信方式,是一种技术思想而不是规范
     *     A 服务器发出请求,通过socket传输到B服务器,然后B服务器进行调用B服务器的方法,调用完毕把结果返回给A
     *      rpc 两个核心模块 : 通讯 序列化
     *
     *
     * DUBBO 18年 重启 3.X  RPC  是一个高性能,轻量级的Java RPC框架,提供三大核心能力 : 面向接口的远程方法调用,智能容错和负载均衡,以及服务自动注册和发现
     *
     *
     * 此处一张结构图
     *
     * 注册中心用Zookeeper
     *  下载以及安装(win)https://blog.csdn.net/ring300/article/details/80446918
     *  apache : https://archive.apache.org/dist/zookeeper/
     *
     *  参考kuang的教程 (https://blog.csdn.net/qq_40572023/article/details/118815883) ,zkServer 可能会闪退,编辑cmd文件 加个pause ,可以暂停看bug
     *  然后去conf文件夹,复制一份zoo_sample.cfg ,改名zoo.cfg (配置里面端口默认2181), 还闪退的话,把端口改成9099
     *  3.5版本后 ,带-bin的是已编译的包,可以用
     *
     *  这一部分坑有点多,
     *  1 启动闪退之后Zookeeper启动还是曝：文件名、目录名或卷标语法不正确
     *  server 配置文件 试试 call %JAVA% 改为 call JAVA
     *
     *  2 zookeeper.audit.disable
     *  server 配置文件增加“-Dzookeeper.audit.enable=true”
     *  对zoo.cfg文件进行修改，在里面加上admin.enable=true即可
     *
     *  3 还有个加目录地址的
     *  在zookeeper目录下新建两个文件夹,分别用于存放data(数据存储)和log(数据日志)
     *  添加数据日志路径配置
     *  修改conf下zoo.cfg配置中数据存储和数据日志路径
     *  dataDir=D:\Me\下载\zookeeper\zookeeper-3.4.14\data
     *  dataLogDir=D:\Me\下载\zookeeper\zookeeper-3.4.14\log
     *
     *
     * 测试 :
     * 打开zkcli.cmd
     * WatchedEvent state:SyncConnected type:None path:null
     * [zk: localhost:2181(CONNECTED) 0] ls /
     * [zookeeper]
     * [zk: localhost:2181(CONNECTED) 1] create -e /yukicris 123
     * Created /yukicris
     * [zk: localhost:2181(CONNECTED) 2] ls /
     * [yukicris, zookeeper]
     * [zk: localhost:2181(CONNECTED) 3] get /yukicris
     * 123
     * [zk: localhost:2181(CONNECTED) 4]
     *
     *
     *
     *  # tickTime       客户端与服务器或者服务器与服务器之间维持心跳，也就是每个tickTime时间就会发送一次心跳。通过心跳不仅能够用来监听机器的工作状态，还可以通过心跳来控制Flower跟Leader的通信时间
     *
     * # initLimit	       集群中的follower服务器(F)与leader服务器(L)之间初始连接时能容忍的最多心跳数
     *
     * #syncLimit         集群中flower服务器（F）跟leader（L）服务器之间的请求和答应最多能容忍的心跳数
     *
     * # dataDir          用来存放myid信息跟一些版本，日志，跟服务器唯一的ID信息等。
     *
     * # dataLogDir       存放事务日志的文件夹
     *
     * # clientPort       客户端连接的接口，客户端连接zookeeper服务器的端口，zookeeper会监听这个端口，接收客户端的请求访问！这个端口默认是2181。
     *
     * # maxClientCnxns    允许连接的客户端数目，0为不限制,通过IP来区分不同的客户端
     */


    /**
     * 然后是Dubbo
     * Dubbo本身是个jar 包
     *
     * Dubbo-admin(这个服务可以不要,只是一个可视化的界面) : 是一个监控管理后台,查看注册了哪些服务,哪些服务被消费
     *
     * Dubbo: jar包
     */

}
