package com.yukicris.Thread.ThreadDay4;

public class Knowledge {
    //线程状态
    //new 新生 Thread t  = new Thread()
    //线程对象一旦创建就进入到了新生状态

    //就绪
    //调用start方法,线程立即进入就绪状态,但是不意味着立即调度执行

    //运行 进入运行状态,线程才真正执行线程体的代码块

    //运行时可以进入阻塞或者死亡
    //阻塞 当调用sleep,wait或者同步锁定时,线程进入阻塞状态,代码不往下执行,阻塞事件解除以后,重新进入就绪状态等等待cpu调度执行
    //dead 线程中断或者结束,一旦进入死亡状态,就不能再次启动


    /**
     * 方法setPriority(int newPriority) 更改优先级
     * static void sleep(long millis) 在指定的毫秒数内让当前正在执行的线程休眠
     * void join() 等待该线程终止
     * static void yield() 暂停当前正在执行的线程对象,并且执行其他线程
     * void interrupt()  中断线程,别用这个方式
     * boolean isAlive() 测试线程是否处于活动状态
     */

    //线程停止 不推荐jdk提供的stop,destory方法(已废弃)
    // 推荐线程自己停止下来,建议使用一个标志位进行终止变量,当flag=false,则跳出循环终止线程运行


    //线程休眠
    //sleep(时间) 指定当前线程阻塞的毫秒数
    //sleep存在异常InterruptedException
    //sleep时间达到后线程进入就绪状态
    //sleep可以模拟网络延时,倒计时等
    //*****每个对象有一个锁,sleep不会释放锁****

    
}
