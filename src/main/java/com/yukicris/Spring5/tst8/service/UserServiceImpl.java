package com.yukicris.Spring5.tst8.service;

public class UserServiceImpl implements UserService{

    @Override
    public void add() {
        System.out.println("增加一个用户");
    }

    @Override
    public void upd() {
        System.out.println("更新一个用户");
    }

    @Override
    public void query() {
        System.out.println("查询一个用户");
    }

    @Override
    public void del() {
        System.out.println("删除一个用户");
    }
}
