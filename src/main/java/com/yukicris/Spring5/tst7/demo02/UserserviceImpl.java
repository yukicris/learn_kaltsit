package com.yukicris.Spring5.tst7.demo02;

// 真是对象
public class UserserviceImpl implements UserService{
    @Override
    public void add() {
        System.out.println("增加了一个用户");
    }

    @Override
    public void del() {
        System.out.println("删除了一个用户");
    }

    @Override
    public void upd() {
        System.out.println("修改了一个用户");
    }

    @Override
    public void query() {
        System.out.println("查询了一个用户");
    }
}
