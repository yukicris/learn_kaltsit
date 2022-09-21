package com.yukicris.Redis.LearnNote5;

public class Nosql24 {
    /**
     * 主从复制
     * 最少一主二从
     *
     * 提供读写分离,降低服务器压力
     * 主数据库提供写请求  ,从数据库提供读请求
     *
       一般来说,要将redis用于工程项目中,只使用一台redis是不行的(宕机)
     1 单个redis服务器会发生单点故障,并且一台服务器处理的负载较大
     2 容量上,单个redis服务器内存容量有限,单个redis最大使用内存应该不超过20g
     */

    //主从复制命令++++++++++++++++++++++++++++++++++------------------------------------++++++++-

    /**
     * 环境配置
     * 只配置从库,不用配置主库
     * 默认每台都是主节点,所以需要单独配置
     * >info replication 可以查看当前库的信息,一般默认角色role是master主库
     *   connected_slaves:0  现在的从机是0个
     *
...  *
-------- 从机拷贝主机的配置文件,改成对应的端口名字 redis6380.conf
     *   用vim指令 vim redis6380.conf  来改配置文件 1 先改端口port 2 改pidfile的对应端口redis_6380.pid
     *   3 改logfile "6380.log"(红色的) 4 改dbfilename  dump6380.rdb (备份文件)
     *
     *   修改完毕后,启动对应修改后的3个redis服务器,可以通过进程信息查看
     *   ps -ef|grep redis
     */

    /**
     * 从机认老大,一主 6379  从机80,81
     * SLAVEOF 127.0.0.1 6379  所属于6379
     * 然后通过info replication可以查看是否配置好了.
     * 如果有密码,需要在从机的配置文件中配上主机的密码
     * 这种是暂时的,服务器重启就失效了
     *
     *
     * 真实的主从配置应该在配置文件中配置,这样就是永久的,而不是命令配置的暂时的
     * relicaof <masterip> <masterport>
     * masterauth <master-password>
     */

    //细节
    /**
     * 主机可以写,从机不能写,只能读,主机中的所有数据都会被从机自动保存
     *
     * 从机只能读取内容
     *
     * 主机断开链接从机依然可以链接到主机,但是没有写操作了,如果主机回来了,从机依然可以继续写入主机保存的信息
     * 从机断了,如果是使用命令行配置的主从复制,重启后就会变成主机,此期间的主机的新数据就拿不到了,如果再次变成了从机,立马会从主机中获取值
     * 即为全量复制
     *
     * 复制原理: Slave启动成功链接到master后会发送一个sync同步命令(第一次)
     * Master接到命令,启动后台的存盘进程,同时手机所有与接受的用于修改数据集命令,在后台进程执行完毕后,master会将传送整个数据文件到slave,完成
     * 一次全面同步
     *
     * 全量复制:slave服务在接受到数据库文件数据后,将其存盘并且加载到内存中
     * 增量复制:master 继续将新的所有收集到的修改命令一次传给slave,完成同步(后续set信息链接)
     *
     */

    // 如果玩套娃  79主 80既是主也是从  81以80为主  那么80就只是从节点,只能读不能写
    //但是此时依旧可以完成主从复制

    /**
     * 如果主机断开链接,可以使用SLAVEOF no one 让自己变成主机,那么其他的节点就可以手动链接到这个最新的主节点
     *
     */
}