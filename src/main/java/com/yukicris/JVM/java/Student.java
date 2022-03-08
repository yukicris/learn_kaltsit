package com.yukicris.JVM.java;

public class Student {
    @Override
    public String toString() {
        return "hello";
    }

    public static void main(String[] args) {
        Student student = new Student(); //这个类,当根加载器(Boot)和扩展类加载器(Ext)都没有的情况下,执行当前加载器
        System.out.println(student.getClass().getClassLoader()); //AppClassLoader
        System.out.println(student.toString());

        /**
         * 1.类加载器收到类加载的请求
         * 2.讲这个请求向上委托给父类加载器中完成,一直向上委托,直到启动类加载器
         * 3. 启动加载器检查是否能够加载当前这个类,能加载就结束,使用当前加载器,否则抛出异常,通知子类加载器进行加载
         * 4 重复步骤3 ,还是没找到,就会报 Class Not Found
         *
         * null : JAVA调用不到~ C,C++
         * Java = C++-- : 去掉繁琐的东西,指针,内存管理
         */
    }
}
