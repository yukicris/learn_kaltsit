package com.yukicris.Spring5.tst7.demo02;

public class UserServiceProxy implements UserService{
    private UserserviceImpl userservice;

    public void setUserservice(UserserviceImpl userservice) {
        this.userservice = userservice;
    }

    @Override
    public void add() {
        log("add");
        userservice.add();
    }

    @Override
    public void del() {
        log("del");
        userservice.del();
    }

    @Override
    public void upd() {
        log("upd");
        userservice.upd();
    }

    @Override
    public void query() {
        log("query");
        userservice.query();
    }

    // 加入一个日志方法
    public void log (String msg){
        System.out.println("使用了"+msg+"方法");
    }
}
