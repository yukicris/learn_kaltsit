package com.yukicris.baseKnowledge;

public class knowledge5 {
    /**
     * 1 HttpServletResponse
     *  响应,web服务器接收到客户端的http请求,针对这个请求,分别创建一个代表请求的HttpServletRequest的对象,
     *  代表响应的HttpServletResponse
     *
     *
     *      {
     *          如果要获取客户端请求过来的参数,找HttpServletRequest
     *          如果要给客户端响应一些信息,找HttpServletResponse
     *      }
     *
     *      {
     *          1 简单分类
     *              负责向浏览器发送数据的方法
     *                  1 outPutStream()
     *                  2 getWriter()
     *              负责向浏览器发送响应头
     *                  1 一堆set/add ...Header
     *                  2 setcontent...
     *                  3 setCharacterEncoding
     *              状态码
     *
     *              int SC_OK = 200;   成功
     *              int SC_FOUND = 302;  重定向
     *              int SC_FORBIDDEN = 403;  没权限
     *              int SC_NOT_FOUND = 404;   未找到
     *              int SC_METHOD_NOT_ALLOWED = 405;
     *              int SC_INTERNAL_SERVER_ERROR = 500;   服务器代码错误
     *              int SC_BAD_GATEWAY = 502;    网关问题
     *
     *
     *          2 常见应用
     *
     *              1 向浏览器输出消息(getoutstream,getwrite)
     *              2 下载文件
     *                  1 获取下载文件的路径
     *                  2 下载的文件名是什么
     *                  3 设置想办法让浏览器能够支持下载我们需要的东西
     *                  4 获取下载文件的输入流
     *                  5 创建缓冲区
     *                  6 获取Outputstream对象
     *                  7 将FileOutputStream流写入buffer缓冲区
     *                  8 使用OutputStream将缓冲区中的数据输出到客户端
     *                  (yukicris_practice的03中实现了此功能)
     *
     *           3 验证码
     *                  1 前端实现
     *                  2 后端实现,需要java的图片类,生成一个图片
     *                  (yukicris_practice的03中实现了此功能)
     *
     *
     *           4 实现重定向(这个最重要) (response) 状态码302
     *              B一个web资源收到客户端请求A以后,回去通知客户端A访问另外一个web资源C,这个过程叫做重定向
     *                  常见场景: 用户登录
     *              (yukicris_practice的03中实现了此功能)
     *
     *              重定向和转发的区别
     *                  相同点: 页面都会实现跳转
     *                  不同点: 请求转发的时候,url不能发生变化;重定向的时候,url地址栏会进行变化
     *
     *
     *      }
     *
     *
     *      2 HttpServletRequest
     *      HttpServletRequest代表客户端的请求,用户通过Http协议访问服务器,http请求中的所有信息会被封装到HttpServletRequest,
     *      通过这个HttpServletRequest 的方法,获得客户端的所有信息
     *          {
     *              1 获取前端传递的参数
     *              2 请求转发 (request) 状态码307
     *               (yukicris_practice的04中实现了此功能)
     *          }
     *
     */
}
