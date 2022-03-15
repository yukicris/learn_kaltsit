package com.yukicris.Spring5.tst1.dao;

import javax.jws.soap.SOAPBinding;

public class UserDaoImpl implements UserDao {
    @Override
    public void getUser() {
        //dao层获取用户数据,mysql查询的数据,oracle查询的数据等
        System.out.println("默认获取用户数据");
    }
}
