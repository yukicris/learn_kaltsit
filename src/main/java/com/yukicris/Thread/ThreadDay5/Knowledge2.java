package com.yukicris.Thread.ThreadDay5;

public class Knowledge2 {
    //这边是项目中常用线程池

    /*FixedThreadPool: 固定长度的线程池,可以控制线程最大并发数,超出的线程会放到队列之中
    SingleThreadExecutor: 单线程线程池,只会用唯一的线程来执行任务
    CachedThreadPool: 可缓存的线程池,如果数据请求过多,他会不断的创建新的线程,并且他可以灵活回收空闲的线程
    ScheduledThreadPool: 用于定时任务执行任务的线程池*/

   /*
    【强制】线程资源必须通过线程池提供，不允许在应用中自行显式创建线程。

    说明：线程池的好处是减少在创建和销毁线程上所消耗的时间以及系统资源的开销，解决资源不足的问题。如果不使用线程池，有可能造成系统创建大量同类线程而导致消耗完内存或者“过度切换”的问题。
            \4. 【强制】线程池不允许使用 Executors 去创建，而是通过 ThreadPoolExecutor 的方式，这样的处理方式让写的同学更加明确线程池的运行规则，规避资源耗尽的风险。

    说明：Executors 返回的线程池对象的弊端如下： 1） FixedThreadPool 和 SingleThreadPool： 允许的请求队列长度为 Integer.MAX_VALUE，可能会堆积大量的请求，从而导致 OOM。 2） CachedThreadPool： 允许的创建线程数量为 Integer.MAX_VALUE，可能会创建大量的线程，从而导致 OOM。*/
}
