package com.yukicris.baseKnowledge;

public class knowledge2 {
    /**
     * java web复习
     *
     *
     */

    /**
     * 服务器
     *
     * 服务器用来处理用户的一些请求,返回给用户一些响应信息
     * 实际运行servlet 和jsp
     *
     * 工作3-5年,尝试手写tomcat
     *
     *
     *
     */

    /**
     * Tomcat
     *
     * 端口
     * http: 80
     * https: 443
     *
     * 可配置主机名称
     * 默认主机名: localhost> 127.0.01
     * 默认网站应用访问位置: webapps
     * <Host name="www.yukicirs.com" appBase="webapps" unpackWARs ="true" autoDeploy="true"></>
     *
     *
     * 网站是如何访问的
     * 1 输入一个域名,回车
     * 2 检查本机的 hosts配置文件下有没有这个域名映射
     *      1 有,返回对应的ip地址,有我们需要访问的web程序,就可以访问
     *
     *      2 没有就去dns服务器找.找到了就访问
     */

    /**
     * Http
     * 什么是http
     *      超文本传输协议,是一个简单的请求,响应协议,通常运行在TCP上
     *
     *      文本: html,字符串
     *      超文本; 图片,音乐,视频,定位...
     *      80
     *
     *      https: 安全的
     *      443
     *
     * http1.0
     *      HTTP/1.0: 客户端可以与web服务器链接,只能获得一个web资源,断开链接
     * http2.0
     *      HTTP/1.1: 客户端可以与web服务器链接,只能获得多个文本资源
     *
     * http 请求: {
     *     Request Url: http://百度.com/   请求地址
     *     Request Method:Get              get方法/post方法
     *     Status Code                     状态码 200
     *     Remote(远程) Address            14.215.177.39:443
     * }
     * 1 请求行
     *      请求行中的请求凡是: get
     *      请求方式:get/post , HEAD,DELETE,PUT,TRACT....
     *          get:能够能够携带的参数比较少,大小有限制,会在浏览器地址中显示数据内容,不安全,但是高效
     *          post: 能够携带的参数没有限制,大小没有限制,不会再浏览器的url地址中显示数据内容,安全,但是不高效
     * 2 消息头
     *      Accept: 告诉浏览器所支持的数据类型
     *      Accept-Ecoding: 支持哪种编码格式,GBK,UTF-8,GB2312,ISO8859-1
     *      Accept-Language:  告诉浏览器它的语言环境
     *      Cache-control: 缓存控制
     *      Connection:告诉浏览器,请求完成是断开还是保持连接
     *      Host: 主机
     *
     * http 响应: {
     *     Cache-control : private   缓存控制
     *     Connection:Keep-Alive     连接状态
     *     Content-Encoding:gzip     编码
     *     Content-Type:text/html     类型
     *
     * 1 响应体:
     *      Accept: 告诉浏览器所支持的数据类型
     *      Accept-Ecoding: 支持哪种编码格式,GBK,UTF-8,GB2312,ISO8859-1
     *      Accept-Language:  告诉浏览器它的语言环境
     *      Cache-control: 缓存控制
     *      Connection:告诉浏览器,请求完成是断开还是保持连接
     *      Host: 主机
     *      Refush: 告诉客户端,多久刷新一次
     *      Location: 让网页重新定位
     *
     * 2 响应状态码(重点)
     *    200: 请求响应成功
     *    3**: 请求重定向
     *         : 重定向: 重新指向新的位置
     *    404: 找不到资源
     *         : 资源不存在
     *    5** : 服务器代码错误  500
     *          502: 网关错误
     *
     * 3 浏览器输入地址回车一瞬间到页面展示回来经历了什么
     *     1. 域名解析
     *     2. 发起TCP的三次握手
     *     3. 建立起TCP连接后发起http请求
     *     4. 服务器响应http请求，浏览器得到html代码
     *     5. 浏览器解析html代码，并请求html代码中的资源（css JavaScript 图片）
     *     6. 浏览器对页面进行渲染呈现
     *
     * 更多请参考。https://www.cnblogs.com/wupeixuan/p/8747918.html
     *
     *
     * }
     */
}
