package com.yukicris.Spring5.tst1;

import com.yukicris.Spring5.tst1.dao.UserDaoMysqlImpl;
import com.yukicris.Spring5.tst1.service.UserService;
import com.yukicris.Spring5.tst1.service.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {
    public static void main(String[] args) {
        /**
         *    //用户调用的是业务层,dao层并不需要接触
         *         UserService userService = new UserServiceImpl();
         *
         *         // 使用了set以后,业务层被动的接收对象来进行创建,这就叫控制翻转
         *         ((UserServiceImpl) userService).setUserDao(new UserDaoMysqlImpl());
         *
         *
         *         userService.getUser();
         */


        //在配置了bean后,上面的三行代码就可以不管了
        //获取ApplicationContext 拿到spring容器
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        // 需要什么直接get
        UserServiceImpl userServiceImpl = (UserServiceImpl) context.getBean("UserserviceImpl");
        userServiceImpl.getUser();
        //>mysql获取数据
    }
}
