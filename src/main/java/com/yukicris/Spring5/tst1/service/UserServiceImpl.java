package com.yukicris.Spring5.tst1.service;

import com.yukicris.Spring5.tst1.dao.UserDao;
import com.yukicris.Spring5.tst1.dao.UserDaoImpl;
import org.apache.catalina.User;

public class UserServiceImpl implements UserService{
    // 以前代码,业务层需要调用dao层,然后dao层有多个实现,比如mysql,oracle,和那个daoImpl
    // 如果我想在这里调用userDaoMysqlimpl,我必须要更改整个实现的对象,否则不是我想要用的对象
    // 即修改private UserDao userDao = new UserDaoMysqlImpl();
    //private UserDao userDao = new UserDaoImpl();


    /**
     * 然后为了不每次更改都要重新新建new对象,为了解耦,需要对对象进行注入
     */
    private UserDao userDao;

    // 利用set进行动态实现值的注入!!
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public void getUser() {
        // 业务层需要调用dao层获取数据(dao层负责去数据库查)来实现自己的业务功能
        userDao.getUser();
    }
}
