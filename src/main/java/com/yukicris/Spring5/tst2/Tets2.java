package com.yukicris.Spring5.tst2;

import com.yukicris.Spring5.tst2.pojo.Hello;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.applet.AppletContext;

public class Tets2 {
    // 此处定义了一个beans.xml配置,在resources里面

    public static void main(String[] args) {
        // 获取spring 的上下文对象(此处的beans.mxl可以写多个)
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        // 我们的对象现在都在spring 中管理了.要使用就要从中取出来就可以了
        Hello hello = (Hello) context.getBean("hello");
        System.out.println(hello.toString());
        //>Hello{str='Spring'}
    }
}
