package com.yukicris.baseKnowledge;

public class knowledge3 {
    /**
     * servlet
     *
     * 参考servlet_01包
     */

    /**
     *
     * 简介
     *    servlet 就是sun公司开发动态web的一门技术
     *          有2个默认实现类 : HttpServlet,GenericServlet
     *
     *    sun公司在这些API中提供了一个接口,叫做Servlet,如果想开发一个Servlet程序,只需要完成2个小步骤
     *          {
     *              编写一个类
     *              把开发好的java类部署到web服务器中
     *
     *          }
     *
     *     把实现了Servlet的接口的Java程序叫做Servlet
     *
     *
     *         <dependency><!--增加servlet包,学习用-->
     *             <groupId>javax.servlet</groupId>
     *             <artifactId>javax.servlet-api</artifactId>
     *             <version>4.0.1</version>
     *         </dependency>
     *         <dependency><!--增加servlet包,学习用-->
     *             <groupId>javax.servlet.jsp</groupId>
     *             <artifactId>jsp-api</artifactId>
     *             <version>2.1.3-b06</version>
     *         </dependency>
     */

    /**
     * 提一嘴建model包
     *      {
     *          1 构建一个普通的maven项目,pom不能删,iml不能删,gitignore不能删,别的可以删
     *          2 删掉src目录
     *          3 建立moudel;
     *          然后这个工程就是主工程,可以在里面建立子项目
     *
     *      }
     *
     *      2 关于maven父子工程的理解:
     *           每个moudel都是个子项目
     *           {
     *              父项目中会有 :
     *              <modules>
     *                  <module>子项目名</module>
     *              </modules>
     *
     *
     *              子项目会有
     *              <parent>
     *                  <artifactId>父项目名</ar...>
     *                  <groupId></groupId>
     *                  <version></version>
     *              </parent>
     *
     *              父项目中的java,子项目可以直接使用
     *
     *           }
     *
     *     3 maven 环境优化
     *         1.修改web.xml为最新
     *         2.将maven的结构搭建完整
     *
     */

    /**
     * 编写一个Servlet程序
     *
     *     1.编写一个普通类
     *     2.实现servlet接口,我们直接继承HttpServlet
     *          源码是: Servlet->GenericServlet(继承Servlet)->HttpServlet(继承GenericServlet)->我的Servlet
     *     3.因为在HttpServlet中实现了GenericServlet中的Service抽象方法,所以我们在继承HttpServlet后,只需要重写Servlet中的方法
     *          一般重写,doGet,doPost
     *     4.编写servlet的映射
     *          为什么需要映射: 因为写的是java程序,但是需要通过浏览器访问,而浏览器需要连接web服务器,所以需要web服务器中注册写的Servlet
     *          ,还要给他一个浏览器可以访问的路径
     *          4.1 注册servlet
     *          <servlet>
     *              <servlet-name>hello</servlet-name>
     *              <servlet-class>com.yukicris.baseKnowkledge.servlet_01.HelloServlet</servlet-name>
     *          <servlet/>
     *          4.2  servlet的请求路径
     *          <servlet-mapping>
     *              <servlet-name>hello</servlet-name>
     *              <url-pattern>/hello/*</url-pattern>
     *          </servlet-mapping>
     *     5.配置Tomcat
     *          注意: 配置项目房补的路径就可以了
     *          (运行那里,类似配置npm启动,找到tomcat,点local,确保端口,jre正常,默认浏览器存在且有jmx port端口(1099),然后点Deployment,
     *          点＋,artifact,改个名字就行)
     *
     *     6.启动测试
     */

     /**
         servlet 原理
      *  见图 servlet-01
      *
      *
      *
     */

    /**
     *  Mapping问题
     *
     *  1 一个servlet 可以指定一个映射路径
     *   <servlet-mapping>
     *       <servlet-name>hello</servlet-name>
     *       <url-pattern>/hello</url-pattern>
     *   </servlet-mapping>
     *  2 一个servlet 可以指定多个
     *
     *  <servlet-mapping>
     *      <servlet-name>hello</servlet-name>
     *      <url-pattern>/hello</url-pattern>
     *  </servlet-mapping>
     *  <servlet-mapping>
     *     <servlet-name>hello</servlet-name>
     *     <url-pattern>/hello1</url-pattern>
     *  </servlet-mapping>
     *  <servlet-mapping>
     *     <servlet-name>hello</servlet-name>
     *     <url-pattern>/hello2</url-pattern>
     *  </servlet-mapping>
     *  <servlet-mapping>
     *     <servlet-name>hello</servlet-name>
     *     <url-pattern>/hello3</url-pattern>
     *  </servlet-mapping>
     *
     *
     *  3 一个servlet可以指定通用映射路径
     *  <servlet-mapping>
     *    <servlet-name>hello</servlet-name>
     *    <url-pattern>/hello/*</url-pattern>
     *  </servlet-mapping>
     *
     *  4 默认请求路径
     *
     *  <servlet-mapping>
     *   <servlet-name>hello</servlet-name>
     *   <url-pattern>/*</url-pattern>
     *  </servlet-mapping>
     *
     *  5 指定一些后缀或者前缀等
     *  可以自定义后缀实现请求映射,比如/s/hello/123124124.do,只要以do结尾就可以访问,do可以随便改
     *      "*"前面不能加项目映射路径,比如配置里加  hello/*.do
     *   <servlet-mapping>
     *       <servlet-name>hello</servlet-name>
     *       <url-pattern>*.do</url-pattern>
     *   </servlet-mapping>
     */


    /**
     * Error Servlet
     * 跳转404页面
     *
     * 1 先写servlet
     * 2 再指定映射
     *   <servlet>
     *        <servlet-name>error</servlet-name>
     *        <servlet-class>com.yukicris.baseKnowkledge.servlet_01.ErrorServlet</servlet-name>
     *    <servlet/>
     *    <servlet-mapping>
     *        <servlet-name>error</servlet-name>
     *        <url-pattern>/*</url-pattern>
     *    </servlet-mapping>
     *
     * 优先级问题,指定的固有映射优先级最高,找不到就走默认的处理请求,也就是上面先定义的/hello会优先跳转
     * 而/*在/hello找不到以后才执行
     *
     */

}
