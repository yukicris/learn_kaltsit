package com.yukicris.Spring5.tst3.pojo;

public class User {
    private String name;


    public User(String name) {
        System.out.println("有参构造");
    }

    // 如果用一个有参构造把这个无参构造替换掉,那么spring 就无法完成bean的创建

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void show () {
        System.out.println("name"+ name);
    }
}
