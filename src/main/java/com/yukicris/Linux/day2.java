package com.yukicris.Linux;

public class day2 {

    /**

     * 绝对路径：
     *
     * 路径的写法，由根目录 / 写起，例如：/usr/share/doc 这个目录。
     *
     * 相对路径
     *
     * 路径的写法，不是由 / 写起，例如由 /usr/share/doc 要到 /usr/share/man 底下时，
     * 可以写成：cd ../man 这就是相对路径的写法啦！
     *
     *
     */

    /**
     * 常用目录处理命令
     * ls 列出目录
     *
     * cd 切换目录    ./当前目录    cd .. 返回上一级目录
     *
     * pwd 显示目前的目录
     *
     * mkdir 创建一个新目录
     * rmdir 删除一个空目录
     *
     * cp 复制文件或目录
     * rm 移除文件或目录
     * mv 移动文件与目录,或修改文件与目录的名称
     *
     *
     * 可以使用 man  命令来查看各个命令的使用文档  如 man cp
     */


    /**
     * 详解
     */

    /**
     * ls 列出目录
     * ls 可能是最常被使用的
     *
     * -a   : all ,查看全部文件,包括隐藏文件
     * -l   : 列出所有文件,包含文件属性和权限,没有隐藏文件
     * 所有linux 命令可以组合使用   ls -al  可看隐藏和权限
     *
     */

    /**
     * cd 切换目录
     *
     * # 切换到用户目录下
     * [root@yewei /]# cd home
     *
     * # 使用 mkdir 命令创建 yukicris 目录
     * [root@yewei home]# mkdir yukicris
     *
     * # 进入 yukicris 目录
     * [root@yewei home]# cd yukicris
     *
     * # 回到上一级
     * [root@yewei yukicris]# cd ..
     *
     * # 回到根目录
     * [root@yewei yukicris]# cd /
     *
     * # 表示回到自己的家目录，亦即是 /root 这个目录
     * [root@yewei yukicris]# cd ~
     *
     *
     * pwd 是 Print Working Directory 的缩写，也就是显示目前所在目录的命令。
     * pwd 显示目前所在的目录
     * 如果需要显示真实的地址,可以使用-P参数
     * cd bin 
     * pwd -P
     * /usr/bin
     *
     */


    /**
     * 创建目录
     * mkdir test
     *
     * 创建层级目录
     * mkdir -p test1/test2/test3
     */

    /**
     * 删除目录
     * rmdir仅能删除空的目录,如果下面存在文件,需要先删除文件,递归删除多个目录
     *
     * rmdir test
     * 只能删为空的文件夹
     *
     * rmdir -p test1/tets2/test3 这样就可以删除不为空的文件夹(删除递归目录)
     */


    /**
     * 复制目录
     * cp
     *
     * cp 原来的地方 新的地方
     * cp install.sh yukicris  拷贝到这个文件来
     * 再次拷贝 ,会弹出是否覆盖 Y/N
     *
     *
     */

    /**
     * rm 移除文件或目录
     * -f 忽略不存在的文件,不会出现警告,强制删除
     * -r 递归删除目录
     * -i 互动,删除询问是否删除
     *
     * rm -rf  /   #系统中的所有文件就被删除了,删库跑路
     * 删除某一个  rm -rf install.sh
     */

    /**
     * 移动文件或者目录
     * mv
     *
     * -f 强制
     * -u 只替换已经更新过的文件
     *
     * mv install.sh yukicris/
     *
     * 重命名 mv yukicris yukicris2
     */
}
