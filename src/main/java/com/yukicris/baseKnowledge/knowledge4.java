package com.yukicris.baseKnowledge;

public class knowledge4 {
    /**
     * ServletContext
     *    servlet上下文
     * {
     *     web容器在启动的时候,它会为每个web程序都创建一个对应的servletcontext对象.它的web
     *     应用;
     *          {
     *              1 共享数据
     *              我在这个servlet中保存的数据,可以在其它servlet中使用
     *              (此步构建在yukicris_practice的practic2中实现了)
     *                   {
     *                       1 配置放置类  hello
     *                       2 配置读取类  getServlet
     *                       3 配置web.xml
     *                       4 测试访问
     *                   }
     *
     *
     *               2 获取初始化参数
     *               @Deprecated这个注解是标记已过时
     *               (此步构建在yukicris_practice的practic2,demo03-getServlet中实现了)
     *               String url = context.getInitParameter("url");
     *
     *
     *               3 请求转发
     *                  转发地址不变,重定向会变化
     *               (此步构建在yukicris_practice的practic2,demo04-getServlet中实现了)
     *
     *
     *               4 读取资源文件
     *               Properites
     *
     *                  {
     *                      在java目录下,新建properities
     *                      在resource目录下,新建properties(应该类似模拟从数据库读取数据)
     *
     *                      发现,都被打包到了一个路径下,classes.我们俗称这个路径为classPath(类路径)
     *                      (此步构建在yukicris_practice的practic2,properities_servlet中实现了)
     *                  }
     *          }
     * }
     */
}
