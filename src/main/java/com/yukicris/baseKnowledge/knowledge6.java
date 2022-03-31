package com.yukicris.baseKnowledge;

public class knowledge6 {
    /**
     *
     * Cookie,Session
     *
     * *会话
     * 用户打开浏览器,点击很多超链接,访问多个web资源,关闭浏览器,这个过程可以称之为会话
     *      {
     *          有状态会话: 点开一个网站,下次再次点开,会知道这个人曾经来过,称之为有状态会话
     *              一个网站,如何证明你来过
     *              1 服务端给客户端一个信件,客户端下次访问服务端,带上信件就可以了;cookie
     *              2 服务器登记你来过了,下次你来的时候我匹配你; session
     *
     *      }
     *
     *
     * 保存会话的2种技术,
     * cookie
     *  客户端技术(响应,请求)
     *
     * session
     *  服务器技术,利用这个技术,可以用来保存用户的会话信息,可以把信息或者数据放在session中
     *
     *
     *  常见场景: 网站登录以后,下次不用登录,第二次直接访问
     *
     */


    /**
     * Cookie
     *  (http://localhost:8080/practice_6_war/c1) 实现
     * 1 从请求中拿到cookie信息
     * 2 服务器响应给客户端cookie
     *
     *    req.getCookies()
     *    cookie.getName()
     *    cookie.getValue()
     *    new Cookie("lastLoginTime", System.currentTimeMillis()+"");
     *    cookie.setMaxAge(60*60*24); /设置有效期,如果设置为0,表示跟随系统默认，其销毁与Session销毁时间相同，即都在浏览器关闭后的特定时间删除。如果我们写程序的时候不设置Cookie的有效时间，那么，Cookie的有效时间等效于会话时间。。
     *
     *
     *    cookies一般保存在本地目录的appdata下
     *
     *    一个网站cookie是否存在上限
     *    1 一个Cookie只能保存一个信息
     *    2 一个web站点可以给浏览器发送多个cookie,每个站点最多20
     *    3 Cookie大小限制4kb
     *    4 300个cookie浏览器上限
     *
     * 删除cookie
     *      1 不设置有效期,关闭浏览器,自动时效
     *      2 设置有效期为0
     */


    /**
     * Session(重点)
     *
     * 服务器会给每一个用户(浏览器)创建一个session对象
     * 一个session独占一个浏览器,只要浏览器没关,这个session就存在
     * 用户登录以后,整个网站都可以访问--保存用户信息,保存购物车信息等
     *
     *
     * Session和cookie的区别:
     *      Cookie 是把用户的数据写给用户的浏览器,浏览器保存,(可以保存多个)
     *      Session把用户数据写到用户独占session中,服务器端保存(保存重要的信息,减少服务器资源的浪费)
     *      Session对象由服务创建
     *
     *  使用场景
     *      保存一个登录用户的信息;
     *      购物车信息;
     *      在整个项目中经常会使用到的数据,将其保存在session中
     *
     *  使用session
     *      见practice6项目
     *        // 得到session
     *         HttpSession session = req.getSession();
     *
     *
     *         //给session中存东西
     *         session.setAttribute("name","yukicris");
     *         session.setAttribute("person",new Person("yukicris",26));
     *
     *         //取sesion
     *         //得到name,先走/s1 ,然后就可以在控制台看到name了
     *
     *         String name = (String) session.getAttribute("name");
     *         Person person = (Person) session.getAttribute("person");
     *
     *
     *         System.out.println(name);
     *         System.out.println(person.toString());
     *
     *         //注销session
     *         HttpSession session = req.getSession();
     *         session.removeAttribute("name");
     *         session.invalidate(); //注销
     *
     *
     *  会话过期在web.xml里面配置
         *  <session-config>
         *     <!--15分钟后session自动时效-->
         *       <session-timeout>15</session-timeout>
         *   </session-config>
     *
     *
     *   客户端(用户)拿到的是session的id,然后通过id 来请求服务器中的session,借用一下知乎的回答
     *
     *   (不管是什么，存cookie也好，存本地存储也好，session也罢
     *   （session也是依靠cookie或其他方式存了一个key在客户端），
     *   甚至直接写url上，都是登录之后，生成一个可作废的令牌（key/token）对应相应的用户，
     *   回传时，只传输这个令牌，而不是真正的用户信息，令牌是一个无意义的随机串，
     *   或者把有意义数据hash之后的串，泄露这东西本身没意义，
     *   不过中间人攻击可以在拿到这个令牌之后模拟真实用户请求，这就需要诸如https来保证端到端的安全了。)
     *
     */
}
