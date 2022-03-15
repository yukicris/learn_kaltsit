package com.yukicris.Redis.LearnNote5;

public class Nosql22 {
    // aof (Append only file)只追加文件
    /**
     * 将我们所有的命令都记录下来,history,恢复的时候就把这个文件
     *
     *
     */
    /**
     * 以日志的形式来记录每个写操作,将redis执行过的所有指令记录下来,(读的操作不记录),只许追加文件,但不可改写文件,redis启动之初会读取该文件重新构建数据
     * 换言之,redis重启的话,就会根据日志文件将指令从前到后执行一次以完成数据的恢复工作
     *
     * Aof保存的是appendonly.aof
     *
     * appendonly no  默认是不开起的 ps.(vim检索命令:/ ,下一个按n)
     * 默认是不开启的,只需要手动配置,只需要将appendonly改为yes就可以开启aof
     *
     * 重启,redis就可以生效了
     *
     * 如果aof文件有错误,这个时候redis是启动不起来的,需要修复这个aof文件
     *
     * redis提供了修复的工具,redis-check-aof
     *reids-check-aof --fix appendonly.aof
     * y/n  >Y
     * successfully truncated aof
     *
     * 如果文件正常,重启就直接恢复了
     *      append only 模式 aof配置
     *      appendonly no 默认不开启aof模式,默认是使用rdb方式持久化,在大部分所有情况下,rdb完全够用
     *      appendfilename "appendonly.aof" 持久化的文件名字
     *
     *      # appendfsync always    :每次修改都会sync(同步),消耗性能
     *      appendfsync everysec  : 每秒执行一次sync ,可能会丢失这一秒的数据
     *      appendfsync no : 不执行sync,这个时候操作系统自己同步数据,速度最快
     *      rewrite  重写
     *
     *
     * auto-aof-rewrite-percentage 100
     * auto-aof-rewrite-min-size 64mb
     * 如果文件大于设置的最大大小,即默认64兆,fork一个新的进程来将文件进行重写
     *
     * aof默认就是文件的无限追加
     *
     *
     * aof的优点和缺点
     *
     * 优点
     * 1 每一次修改都同步.文件的完整性更加好
     * 2 每一秒都同步一次,可能会丢失数据
     * 3 从不同步,效率最高
     *
     * 缺点
     * 1 相对于数据文件来说,aof远远大于rdb,修复的速度也比rdb慢
     * 2 Aof运行效率也比rdb慢,redis默认的配置就是rdb持久化
     */

}
