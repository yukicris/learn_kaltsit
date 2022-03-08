package com.yukicris.collection1;

public class Xinwen1 {
    private String title;
    private String value;



    // 有参构造器(不需要返回值)
    public Xinwen1 (String title) {
        this.title = title;
    }


    // 重写tostring 可以显示出参数名称,而不是地址
    @Override
    public String toString() {
        return "Xinwen1{" +
                "title='" + title + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
