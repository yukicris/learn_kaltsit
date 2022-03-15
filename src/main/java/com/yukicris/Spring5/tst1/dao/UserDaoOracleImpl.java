package com.yukicris.Spring5.tst1.dao;

public class UserDaoOracleImpl implements UserDao{
    @Override
    public void getUser() {
        System.out.printf("oracle 获取数据");
    }
}
