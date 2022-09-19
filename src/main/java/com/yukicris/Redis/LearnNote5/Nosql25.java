package com.yukicris.Redis.LearnNote5;

public class Nosql25 {
    //哨兵模式重点-自动选举


    //主从切换的技术:当主服务器宕机以后,需要手动把一台从服务器切换为主服务器,需要人工干预,费时费力,还会造成一定时间内服务器不可用

    //这个时候需要考虑哨兵模式

    //哨兵模式是一种特殊的模式,首先redis提供了哨兵的命令,他是一个独立的进程,其原理是通过哨兵发送命令,等待Redis服务器响应
    //从而监控运行多个Redis实例

    /**
     * 哨兵2个作用
     * 1 通过发送命令,让redis服务器返回监控其运行状态,包括主服务器和从服务器
     * 2 当哨兵监测到Maser宕机,会自动将slave切换为master,然后通过发布订阅模式通知其他的从服务器,修改配置文件,让他们切换主机
     *
     * 然而一个哨兵进程对Redis服务器进行监控会出现问题,比如哨兵进程宕机,为此可以使用多个哨兵进行监控,各个哨兵之间还会互相监控,也就是多哨兵模式
     *
     * 假设主服务器宕机，哨兵1先检测到这个结果，系统并不会马上进行failover过程，仅仅是哨兵1主观的认为主服务器不可用，这个现象成为主观下线。
     * 当后面的哨兵也检测到主服务器不可用，并且数量达到一定值时，那么哨兵之间就会进行一次投票，投票的结果由一个哨兵发起，
     * 进行failover[故障转移]操作。切换成功后，就会通过发布订阅模式，让各个哨兵把自己监控的从服务器实现切换主机，
     * 这个过程称为客观下线。
     *
     */

    /**
     * 我们目前状态是一主二从,
     * 1 配置哨兵配置文件 sentinel.conf
     * #sentinel monitor  被监控的名称 host port 1
     * sentinel monitor myredis 127.0.0.1 6379 1
     *
     * vim sentinel
     * sentinel monitor myredis 127.0.0.1 6379 1   哨兵监控redis,1 代表主机挂了就slave投票看让谁接替成为主机
     *
     * 2 启动哨兵
     * redis-sentinel Kconfig/sentinel.conf
     *
     * 如果Master节点断开,这个时候就会从从机里面投票选择出一个机器当做主机
     * //如果这里6379崩了,那么它就会转移故障到从机
     *
     *
     * 查看哨兵日志  sdown Slave 127.0.0.1 6379 说明6379已经不是主机了,如果6379连回来的话,也不会当做主机,而是当做从机
     */

    /**
     * 哨兵模式
     *
     * 优点: 1 哨兵集群,基于主从复制模式,所有的主从配置优点他都有
     * 2 主从可以切换,故障可以转移,系统可用性就会更好
     * 3 哨兵模式就是主从模式的升级,手动到自动,更加健壮
     *
     * 缺点:1  redis不好在线扩容,集群容量满了在线扩容就会非常麻烦
     * 2 实现哨兵模式的配置其实是很麻烦的,里面有很多选择
     */

    /**
     * 哨兵模式的全部配置
     * # Example sentinel.conf
     *
     * # 哨兵sentinel实例运行的端口 默认26379  如果有哨兵集群,我们还需要配置每个哨兵端口
     * port 26379
     *
     * # 哨兵sentinel的工作目录
     * dir /tmp
     *
     * # 哨兵sentinel监控的redis主节点的 ip port
     * # master-name  可以自己命名的主节点名字 只能由字母A-z、数字0-9 、这三个字符".-_"组成。
     * # quorum 当这些quorum个数sentinel哨兵认为master主节点失联 那么这时 客观上认为主节点失联了
     * # sentinel monitor <master-name> <ip> <redis-port> <quorum>
     * sentinel monitor mymaster 127.0.0.1 6379 1
     *
     * # 当在Redis实例中开启了requirepass foobared 授权密码 这样所有连接Redis实例的客户端都要提供密码
     * # 设置哨兵sentinel 连接主从的密码 注意必须为主从设置一样的验证密码
     * # sentinel auth-pass <master-name> <password>
     * sentinel auth-pass mymaster MySUPER--secret-0123passw0rd
     *
     *
     * # 指定多少毫秒之后 主节点没有应答哨兵sentinel 此时 哨兵主观上认为主节点下线 默认30秒
     * # sentinel down-after-milliseconds <master-name> <milliseconds>
     * sentinel down-after-milliseconds mymaster 30000
     *
     * # 这个配置项指定了在发生failover主备切换时最多可以有多少个slave同时对新的master进行 同步，
     * 这个数字越小，完成failover所需的时间就越长，
     * 但是如果这个数字越大，就意味着越 多的slave因为replication而不可用。
     * 可以通过将这个值设为 1 来保证每次只有一个slave 处于不能处理命令请求的状态。
     * # sentinel parallel-syncs <master-name> <numslaves>
     * sentinel parallel-syncs mymaster 1
     *
     *
     *
     * # 故障转移的超时时间 failover-timeout 可以用在以下这些方面：
     * #1. 同一个sentinel对同一个master两次failover之间的间隔时间。
     * #2. 当一个slave从一个错误的master那里同步数据开始计算时间。直到slave被纠正为向正确的master那里同步数据时。
     * #3.当想要取消一个正在进行的failover所需要的时间。
     * #4.当进行failover时，配置所有slaves指向新的master所需的最大时间。不过，即使过了这个超时，slaves依然会被正确配置为指向master，但是就不按parallel-syncs所配置的规则来了
     * # 默认三分钟
     * # sentinel failover-timeout <master-name> <milliseconds>
     * sentinel failover-timeout mymaster 180000
     *
     * # SCRIPTS EXECUTION
     *
     * #配置当某一事件发生时所需要执行的脚本，可以通过脚本来通知管理员，例如当系统运行不正常时发邮件通知相关人员。
     * #对于脚本的运行结果有以下规则：
     * #若脚本执行后返回1，那么该脚本稍后将会被再次执行，重复次数目前默认为10
     * #若脚本执行后返回2，或者比2更高的一个返回值，脚本将不会重复执行。
     * #如果脚本在执行过程中由于收到系统中断信号被终止了，则同返回值为1时的行为相同。
     * #一个脚本的最大执行时间为60s，如果超过这个时间，脚本将会被一个SIGKILL信号终止，之后重新执行。
     *
     * #通知型脚本:当sentinel有任何警告级别的事件发生时（比如说redis实例的主观失效和客观失效等等），将会去调用这个脚本，
     * #这时这个脚本应该通过邮件，SMS等方式去通知系统管理员关于系统不正常运行的信息。调用该脚本时，将传给脚本两个参数，
     * #一个是事件的类型，
     * #一个是事件的描述。
     * #如果sentinel.conf配置文件中配置了这个脚本路径，那么必须保证这个脚本存在于这个路径，并且是可执行的，否则sentinel无法正常启动成功。
     * #通知脚本
     * # sentinel notification-script <master-name> <script-path>
     *   sentinel notification-script mymaster /var/redis/notify.sh
     *
     * # 客户端重新配置主节点参数脚本
     * # 当一个master由于failover而发生改变时，这个脚本将会被调用，通知相关的客户端关于master地址已经发生改变的信息。
     * # 以下参数将会在调用脚本时传给脚本:
     * # <master-name> <role> <state> <from-ip> <from-port> <to-ip> <to-port>
     * # 目前<state>总是“failover”,
     * # <role>是“leader”或者“observer”中的一个。
     * # 参数 from-ip, from-port, to-ip, to-port是用来和旧的master和新的master(即旧的slave)通信的
     * # 这个脚本应该是通用的，能被多次调用，不是针对性的。
     * # sentinel client-reconfig-script <master-name> <script-path>
     * sentinel client-reconfig-script mymaster /var/redis/reconfig.sh   //这些一般是运维配置
     * ————————————————
     * 版权声明：本文为CSDN博主「oneSeventeenCode」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
     * 原文链接：https://blog.csdn.net/qq_42829628/article/details/108640250
     */

}
