package com.yukicris.baseKnowledge;

public class knowledge7 {
    /**
     * 实体类
     *
     * JavaBean特定写法
     *
     *      1 必须要有一个无参构造
     *      2 属性必须私有化
     *      3 必须有对应的get/set方法
     *
     * 一般用来和数据库的字段做映射 ORM
     *
     * ORM : 对象关系映射
     *    表-->类   一张表对应一个类
     *    字段-->属性    一个字段对应类的属性
     *    行记录-->对象     一行对应一个对象
     *
     *
     */


    /**
     * MVC三层架构
     *
     *   Controller servlet: 控制器
     *      {
     *          1 接收用户的请求
     *          2 响应客户端内容->交给业务层做
     *          3 重定向或者转发-->视图跳转
     *      }
     *
     *   View :视图层
     *      {
     *          1 展示数据->展示数据模型
     *          2 提供可以供给操作的请求-->提供用户操作
     *      }
     *
     *      Servlet和jsp都可以写java代码,为了易于维护和使用,Servlet专注于处理请求,以及控制视图跳转
     *      Jsp专注于显示数据
     *
     *      早些年,只有2层,控制层直接操作数据库
     *      servlet--crud--数据库
     *      弊端: 程序十分臃肿,不利于维护   servlet 的代码中,处理请求,响应,视图跳转,处理jdbc,处理业务和逻辑代码
     *
     *      架构: 没有什么是加一层解决不了的
     *      比如jdbc
     *
     *      Model控制业务操作,增删改查数据: {
     *                Service:
     *                    {
     *                        业务
     *                        login/logout,查询,jdbc
     *                        跟controller做交互
     *                    }
     *
     *                Dao: 与jdbc交互
     *
     *                JavaBean
     *      }
     *
     *
     *
     *
     *      总结:
     *          Model
     *              1 业务处理  业务逻辑(service)
     *              2 数据持久层  CRUD (Dao)
     *
     *          View
     *              1 展示数据
     *              2 提供链接发起Servlet请求(a,form,img)
     *
     *          Controller
     *              1 接收用户的请求: req: 请求参数,session信息
     *              2 交给业务层处理对应的代码
     *              3 控制视图跳转
     *
     *
     */


    /**
     *
     * Filter
     *   过滤器: 用来过滤网站的数据
     *   对应practice6包
     *
     *   1 处理中文乱码
     *   2 登录验证
     *
     *
     *
     *      流程:
     *         1 实现Filter,导包,javax.servlet中的Filter包
     *         2 filterChain.doFilter(servletRequest,servletResponse);
     *         3 配置Filter过滤器
     */

    /**
     * session 销毁
     * 手动销毁 session.invalidate
     * 自动销毁,配置xml文件 ,session.timeout
     *
     *
     * 监听器
     * Listener
     *
     * 实现一个监听器接口;(有N种)
     *  1  implements HttpSessionListener ,根据需求来,重写其中的
     *      sessionCreated方法(一般都是xxxCreated)
     *  2  web.xml配置
     *
     */

    /**
     * 过滤器监听器常见应用
     *    登录拦截
     */

}
