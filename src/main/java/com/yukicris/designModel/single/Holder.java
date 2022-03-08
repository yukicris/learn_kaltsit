package com.yukicris.designModel.single;

//静态内部类(高级一些的玩法,不过也不线程安全)
public class Holder {
    private Holder(){

    }

    public static Holder getInstance(){
        return InnerClass.HOLDER;
    }


    public static class InnerClass{
        private static final Holder HOLDER = new Holder();
    }

}
