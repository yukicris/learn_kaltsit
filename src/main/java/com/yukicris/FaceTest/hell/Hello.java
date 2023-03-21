package com.yukicris.FaceTest.hell;

public class Hello {
    public static void main(String[] args) {
        A ab = new B();
        ab = new B();
        //1b2b2b      静态仅执行一次,构造器new一次执行一次,父级优先
    }
}
