package com.yukicris.Thread.JUC1;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.FutureTask;
@Slf4j(topic="Test1")
public class Day1 {
    /**
     * Thread和Runable的关系
     * 小结:
     *     Thread把线程和任务合并到了一起,Runbale是把线程和恩物拆分开了
     *     用Runbable更容易和线程池等高级API配合
     *     用Runbale让任务脱离了Thread继承体系,更加灵活
     *     (Runbale其中有个target字段,这个字段本质是Thread,最后还是由run方法执行)
     */

    //Runnable扩展 FutureTask
    //FutureTask配合Thread,futuretask可以接收Callable类型的参数,用来处理有返回结果的情况

        public static void main(String[] args) {


        }


        //疑问,公司看到有个代码很奇怪,用的是一种可以返回参数的开启线程的方式



}
