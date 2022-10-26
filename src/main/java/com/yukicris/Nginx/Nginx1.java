package com.yukicris.Nginx;

public class Nginx1 {
    /**
     * 为什么用Nginx : 并发量大了,用户多了,一台tomcat无法满足需求
     * 于是横向扩展,然后tomcat跑多台服务器,会很乱,于是需要一个代理服务器
     * (架构:没有一个是加一层解决不了的问题)
     *
     * Nginx 是一个高性能的HTTP和反向代理的web服务器,特点 内存小,且并发能力强
     *
     *
     * 正向代理: vpn这种的,请求美国的服务器进行请求这种的,正向代理代理客户端
     *
     * 反向代理: 代理服务器
     *
     * 负载均衡 : {内置策略: 轮询,加权轮询: 指按权重分配, 比如三台 权重为1,2,4,则把7条信息按数量分配完后再进行下一轮,
     *           IP hash: 对客户端请求的ip进行hash操作,然后根据hash结果将同一个客户端ip的请求分发给同一台服务器处理,可以解决session(token)不共享的问题
     *           扩展策略:  天马行空}
     *
     * 动静分离: 静态资源服务器
     */


    /**
     * 安装: win,解压就行
     *
     * linux 1 先看有没有装nginx: whereis nginx
     *       2 解压 tar zxvf nginx-version
     *       3 ./config
     *       4 make
     *       5 make install
     *       6 进文件目录看一下是否已安装 cd /usr/local/nginx/
     *       7 执行  cd sbin/
     *       8./nginx    没报错就成功了
     *       9 访问就行了,如果有问题 1 检察80端口防火墙  2 阿里云等安全组的80端口也放开
     *              {
     *                  相关命令
     *                  开启: service firewalld start
     *                  重启: service firewalld restart
     *                  关闭: service firewalld stop
     *                  查看防火墙规则 firewall-cmd --list-all
     *                  查看端口是否开方 firewall-cmd --query-port=8080/tcp
     *                  开方80端口 firewall-cmd --permanent --add-port=80/tcp
     *                  移除端口 firewall-cmd --permanent --remove-port=8080/tcp
     *
     *                  重启防火墙
     *                  firewall-cmd --reload
     *
     *                  (解析: --permanent 表示设置为持久   --add-port标识添加的端口)
     *              }
     */


    /**
     * 常用命令
     * cd /usr/local/nginx/sbin/
     * ./nginx 启动
     * ./nginx -s stop 停止(强制停止)
     * ./nginx -quit 安全退出(一项项线程的关闭)
     * ./nginx -s reload  重新加载配置文件(关键!在线直接更改配置)
     * ps aux|grep nginx 查看nginx进程
     *
     * 启动成功后的端口80 http
     *  https 是443端口(ssl)
     *
     */

    /**
     * 使用
     *  打开配置 nginx.conf
     *  反向代理: proxy_pass: http://yukicris.com
     *  负载均衡: upstream yukicris {
     *      server 127.0.0.1:8080 weight=1;
     *      server 127.0.0.1:8081 weight=1;
     *  }   
     */
}
