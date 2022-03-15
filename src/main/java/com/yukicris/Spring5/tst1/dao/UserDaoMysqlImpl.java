package com.yukicris.Spring5.tst1.dao;

public class UserDaoMysqlImpl implements UserDao{
    @Override
    public void getUser() {
        System.out.printf("mysql获取数据");
    }
}
