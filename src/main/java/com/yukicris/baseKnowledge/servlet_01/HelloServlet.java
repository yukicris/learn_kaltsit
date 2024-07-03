package com.yukicris.baseKnowledge.servlet_01;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {
    // 快捷键ctrl+o

    //由于get或者post只是请求实现的不同方式,可以互相调用,业务逻辑一样
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter(); //响应流
        writer.print("Hello Servlet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

   /* 1.get是从服务器上获取数据，post是向服务器传送数据。
            2.get是把参数数据队列加到提交表单的action属性所指的URL中，值和表单内各个字段相对应。在URL中可以看到，post是通过HTTPpost机制，将表单内各个字段与其内容放置在HTML HEADER内一起传送到ACTION属性所指的URL地址。用户看不到这个过程。
            3.对于get方式，服务器端用Request.QueryString获取变量的值，对于post方式，服务器端用Request.Form获取提交的数据。
            4.get传送的数据量较小，不能大于2KB。post传送的数据量较大，一般被默认为不受限制。
            5.get安全性非常低，post安全性较高。
    总结：get请求将参数放在url当中，post请求将参数放在请求体当中，理论上post更安全
    因为url长度大小不能超过1KB ，而get请求又将参数放在url当中，所以上传头像等操作不能使用get请求

    作者：cf
    链接：https://juejin.cn/post/6971036630606069768*/
}
