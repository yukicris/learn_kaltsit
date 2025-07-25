package com.yukicris.Linux;

public class  day3 {

    // 文章参考https://mp.weixin.qq.com/s/4dZ3mbu287pC6mdGOczGAA
    /**
     * 看懂文件属性
     * ls -ll 查看当前文件所属权限
     *
     * 参照那两张图片
     * ll 或者ls -l 查看一个文件的属性以及文件所属的用户和组
     *
     * 实例中,boot文件的第一个属性用 'd' 来表示,d在linux中代表该文件是个目录文件
     * Linux 中 第一个字符代表这个文件是目录,文件或者链接文件等
     *
     * 当为 d 则是目录
     * 当为 - 则是文件
     * 当为l则表示为链接文档(link file)
     * 如果是b,则表示装置文件里面的串行端口设备(可以随机存储装置)
     * 如果是c,则表示装置文件里面的串行端口设备,比如键盘鼠标(一次性读取装置)
     *
     *
     * drwxr-xr-x  1 root root   7 Feb 20  10:57 bin ->usr/bin
     *
     * 第一个d 代表他是一个目录文件,如果是l则是文档,可以打开
     * 接下来的以每三个为一组, r代表可读,w代表可写,x代表可执行execute
     * 这三个权限的位置不会改变,如果没有权限,就会出现'-'而已
     *
     *
     * 文件类型  属主权限(root)  属组权限(管理组,游客组)  其他用户权限
     *   d       rwx                 r-x                r-x
     *  目录文件   读 写 执行           读  不可写 执行      读 不可写 执行
     *
     *  两个root 代表用户和用户组
     *  root 属主 root 属组
     *
     *  后面就是占用大小 和创建时间
     *  bin ->usr/bin 如果没有后面的,则表示文件名称,有后面的,后面代表该快捷方式对应的目录
     *
     */


    /**
     * 修改文件属性
     * 1 修改文件属组
     * chgrp :更改文件属组 change group
     *
     * chgrp -R 属组名 文件名
     * -R递归更改文件属组,就是在更改某个目录文件的属组时,加上-R的参数,那么该目录下面的所有文件的属组都会更改
     *
     * 2 chown 更改文件属主 ,可以同时更改文件的属组 change owner
     * chown -R 属主名 文件名
     * chown -R 属主名:属组名 文件名
     *
     *
     * 3 必须要掌握
     * chmod
     * 你没有权限操作此文件夹
     * chmod -R xyz 文件或者目录
     * Linux中文件属性有2种设置方法,一种是数字,一种是符号
     * 基本9大权限 owner/group/others(所有者,用户,其他角色) 三种身份各自的read/write/execute权限(读写执行)
     * 即  [rwxrwxrwx] 三个三个一组,可以使用数字代替
     * r:4  w;2   x:1
     * 每个身份的三个权限的分数都是需要累加的,例如当权限为[-rwxrwx---]分数则是
     * owner = rwx = 4+2+1 = 7
     * group = rwx = 4+2+1 = 7
     * other = --- = 0+0+0 = 0
     *
     * chmod 770 filename
     * chomd 777 filename  文件赋予所有用户可读可写可执行
     * 常用777 ,744
     *
     */


    /**
     * 文件内容查看
     *
     *  cat 由第一行开始显示文件内容    看一些配置文件常用
     *  tac 从最后一行开始显示文件内容  *(倒写cat)
     *  nl 显示的时候,顺带输出行号    希望显示行号的时候常用
     *  more 一页一页的显示文件内容   空格代表翻页,enter代表写一行,:f行号
     *
     *  grep -o 'KeyWord' 03.txt | wc -l  统计关键字出现的次数
     *  //下面这个实用
     * less和more类似,但是比more更好,他可以往前翻页   空格代表翻页,enter代表写一行,:f行号,上下键代表上下页,退出使用 q命令
     *      *      然后查找字符串用/要查询的字符+回车 ,向上查询 用?要查询的字符串, n继续搜索下一个,N代表向上寻找
     *
     *  head 只看头几行  head -n 前面n行
     *  tail 只看尾巴几行
     *
     *  ifconfig 查看网络配置
     *
     * # 查看网络配置: 文件地址 /etc/sysconfig/network-scripts/
     * [root@yukicris ~]# cat /etc/sysconfig/network-scripts/ifcfg-eth0
     * DEVICE=eth0
     * BOOTPROTO=dhcp
     * ONBOOT=yes
     *
     *  cd /etc/sysconfig   这个etc是配置目录
     *
     *  cat 由第一行开始显示文件内容,看一些配置文件用
     *  cat [-AbEnTv]
     *  选项与参数：
     *
     * -A ：相当於 -vET 的整合选项，可列出一些特殊字符而不是空白而已；
     *
     * -b ：列出行号，仅针对非空白行做行号显示，空白行不标行号！
     *
     * -E ：将结尾的断行字节 $ 显示出来；
     *
     * -n ：列印出行号，连同空白行也会有行号，与 -b 的选项不同；
     *
     * -T ：将 [tab] 按键以 ^I 显示出来；
     *
     * -v ：列出一些看不出来的特殊字符
     */

  /**  ps 命令的作用是显示进程信息的；

            | 符号，是个管道符号，表示ps 和 grep 命令同时执行；

    grep 命令是查找（Global Regular Expression
    Print），能使用正则表达式搜索文本，然后把匹配的行显示出来；

    ps命令有一些参数：
    -e : 显示所有进程
    -f : 全格式
    -h : 不显示标题
    -l : 长格式
    -w : 宽输出
    a ：显示终端上的所有进程，包括其他用户的进程。
    r ：只显示正在运行的进程。
    u ：以用户为主的格式来显示程序状况。
    x ：显示所有程序，不以终端机来区分。
*/
    //   less和more类似,但是比more更好,他可以往前翻页   空格代表翻页,enter代表写一行,:f行号,上下键代表上下页,退出使用 q命令
    //   然后查找字符串用/要查询的字符+回车 ,向上查询 用?要查询的字符串, n继续搜索下一个,N代表向上寻找
  //Linux 查看磁盘空间可以使用 df 和 du 命令。
   /* df -hl：查看磁盘剩余空间
    df -h：查看每个根路径的分区大小
    du -sh [目录名]：返回该目录的大小
    du -sm [文件夹]：返回该文件夹总M数
    du -h [目录名]：查看指定文件夹下的所有文件大小（包含子文件夹）*/

    //查端口netstat -anp

 /*     1.查看文件前几行:head
            head -n 5 TAIR10_chr_all.fas
        2.查看文件后几行:tail
            tail -n 5 TAIR10_chr_all.fas
        3.逐页显示文本: less
            less TAIR10_chr_all.fas*/

    //我的本地虚拟机设置均为 root/admin   pw:123456
}
