1 mysql 安装

https://dev.mysql.com/get/Downloads/MySQL-5.7/mysql-5.7.19-winx64.zip

电脑是64位的就下载使用64位版本的！

安装步骤

1、下载后得到zip压缩包.

2、解压到自己想要安装到的目录，本人解压到的是D:\Environment\mysql-5.7.19

3、添加环境变量：我的电脑->属性->高级->环境变量(系统变量)
选择PATH,在其后面添加: 你的mysql 安装文件下面的bin文件夹

4、编辑 my.ini 文件 ,注意替换路径位置,没有就新建一个到根目录下

[mysqld]
basedir=D:\mysql\mysql-5.7.19-winx64\
datadir=D:\mysql\mysql-5.7.19-winx64\data\
port=3306
skip-grant-tables
5、启动管理员模式下的CMD，并将路径切换至mysql下的bin目录(cd /d D:\mysql\mysql-5.7.19-winx64\bin)，然后输入mysqld –install (安装mysql)

6、再输入  mysqld --initialize-insecure --user=mysql 初始化数据文件

7、然后再次启动mysql (net start mysql)然后用命令 mysql –u root –p 进入mysql管理界面（密码可为空）

8、进入界面后更改root密码

update mysql.user set authentication_string=password('123456') where user='root' and Host = 'localhost';
9、刷新权限

flush privileges;
10、修改 my.ini文件删除最后一句skip-grant-tables

11、重启mysql即可正常使用

net stop mysql
net start mysql
12、连接上测试出现以下结果就安装好了
————————————————
原文链接：https://blog.csdn.net/qq_33369905/article/details/105828923


ps . 如果以前没删除干净导致无法安装
以管理员身份运行cmd
输入sc query mysql
回车
输入sc delete mysql

ps2 . 启动失败试试这个
D:\mysql\mysql-5.7.19-winx64\bin>mysqld -remove MYSQL
Service successfully removed.
D:\mysql\mysql-5.7.19-winx64\bin>mysqld --initialize-insecure   //初始化配置
D:\mysql\mysql-5.7.19-winx64\bin>mysqld --install
Service successfully installed.

D:\mysql\mysql-5.7.19-winx64\bin>net start mysql
MySQL 服务正在启动 .
MySQL 服务已经启动成功。
