package com.yukicris.Spring5.tst2.pojo;

public class Hello {
    private String str;

    public String getStr() {
        return str;
    }

    // 这个set如果去掉,bean里的name会直接报错
    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return "Hello{" +
                "str='" + str + '\'' +
                '}';
    }
}
