package com.yukicris.RabbitMQ.learnNote1;

public class Msg2 {
    /**
     * 安装
     *
     *
     * #安装依赖
     * yum -y install gcc glibc-devel make ncurses-devel openssl-devel xmlto perl wget gtk2-devel binutils-devel
     *
     * #下载包
     * wget http://erlang.org/download/otp_src_22.0.tar.gz
     *
     * #解压
     * tar -zxvf otp_src_22.0.tar.gz
     *
     * #准备安装
     * mv otp_src_22.0 /usr/local/
     * cd /usr/local/otp_src_22.0/
     * mkdir ../erlang
     * ./configure --prefix=/usr/local/erlang
     *
     * #安装
     * make install
     *
     * #检查与添加环境变量
     * ll /usr/local/erlang/bin
     * echo 'export PATH=$PATH:/usr/local/erlang/bin' >> /etc/profile
     * source /etc/profile
     *
     * #检查
     * erl
     *
     *
     *
     * 安装rabbitMq
     *
     * #下载包
     * wget https://github.com/rabbitmq/rabbitmq-server/releases/download/v3.7.15/rabbitmq-server-generic-unix-3.7.15.tar.xz
     *
     * #解压与更新配置环境变量
     * yum install -y xz
     * /bin/xz -d rabbitmq-server-generic-unix-3.7.15.tar.xz
     * tar -xvf rabbitmq-server-generic-unix-3.7.15.tar
     * mv rabbitmq_server-3.7.15/ /usr/local/
     * mv /usr/local/rabbitmq_server-3.7.15  rabbitmq
     * echo 'export PATH=$PATH:/usr/local/rabbitmq/sbin' >> /etc/profile
     * source /etc/profile
     *
     * #启动(随系统后台启动,不然就关闭shell会话就自动关闭mq了)
     * rabbitmq-server -detached
     *
     * #重启
     * rabbitmq-server restart
     *
     * #停止
     * rabbitmqctl stop
     *
     * #状态
     * rabbitmqctl status
     *
     * #开启web插件
     * rabbitmq-plugins enable rabbitmq_management
     *
     * #添加用户
     * rabbitmqctl add_user USERNAME USERPASSWORD
     * # 授予资源权限
     * rabbitmqctl set_permissions -p "/" USERNAME ".*" ".*" ".*"
     *
     * rabbitmqctl list_user_permissions USERNAME
     * #授予超级管理员权限
     * rabbitmqctl set_user_tags USERNAME administrator
     *
     * #删除默认用户guest
     * rabbitmqctl delete_user guest
     *
     * 启动时如报command not found,请检查/etc/profile 里erlang与rabbitMQ的路径是否正确。
     * #打开端口5672、15672
     * firewall-cmd --permanent --zone=public --add-port=5672/tcp
     * firewall-cmd --permanent --zone=public --add-port=15672/tcp
     *
     * #重启防火墙
     * firewall-cmd --reload
     */

    /**
     * rabbitmq启动的方式有三种:
     *
     * 　　1.一个是rabbitmq-server -detached 后台启动，rabbitmqctl stop 停止
     *
     * 　　2.Rabbitmq-server 窗口启动，关闭窗口时rabbitmq停止，使用rabbitmqctl stop也可停止
     *
     * 　　3.rabbitmq桌面安装时，任务管理器中会出现对应的服务
     *
     * 后台管理界面启动插件安装：
     *
     * 　　rabbitmq-plugins enable rabbitmq_management 启动
     *
     * 　　rabbitmq-plugins disable rabbitmq_management 关闭
     *
     * 　　后台管理界面是以插件的形式需要用户手动安装，不像activemq启动后后台管理服务也自动启动可直接访问，
     */

}
