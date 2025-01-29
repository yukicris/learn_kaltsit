package com.yukicris.Thread.ThreadDay5;

import java.util.concurrent.*;

public class Knowledge {
    //线程池
    /**
     * 池化思想,线程池,字符串常量池,数据库连接池
     *
     * Java通过Executors提供四种线程池，分别为：
     * newCachedThreadPool创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
     * newFixedThreadPool 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
     * newScheduledThreadPool 创建一个定长线程池，支持定时及周期性任务执行。
     * newSingleThreadExecutor 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
     */
    //提高资源的利用率
    // 1 手动创建线程对象  2 执行任务 3 执行完毕,释放线程对象

    //大概意思就是比如我预先开3个线程对象放在线程池里,然后有一堆数据需要跑,我开就让这1,2,3这三个线程对象
    //去处理这个任务前三个,其他任务进入等待队列,然后任务第一个执行完了,我就把1号线程对象还到池子里,池子再分配1号线程去接等待队列中的4号数据任务;
    //如果我创建的3个线程对象不够用,会开启应急预案,它会加一个线程对象帮忙处理(不超过最大线程数),实在满了无法处理就只有拒绝策略了
    //如果一个线程对象长期没有用到(就是够用,且多了的情况,)有个存活时间,超过这个时间,就把这个对象关闭了


    //类似银行营业厅,会有几个柜台关了,还有等候区

    /**
     * 线程池的优点,
     * 提高线程的利用率,提高程序的响应速度,便于统一管理,可以控制最大的并发数
     */

    /**
     * 拒绝策略
     * @param args
     */
    //AbortPolicy：直接丢弃新任务，抛出异常，当有多个任务时，只要任务超出了设定任务的最大线程数加阻塞数时，就会抛出异常，没有超出的线程正常执行，超出报异常后面的不执行。
    //DiscardPolicy：直接丢弃掉，不会抛出异常，最大线程数加阻塞数如果只要10，那么前10个线程会正常执行，后面加入的线程会被丢弃。
    //DiscardOldestPolicy：丢弃时间最久的任务。一般是队列最前面的任务，只要还有任务新增，一直会丢弃阻塞队列的最老的任务，并将新的任务加入到阻塞队列中
    //CallerRunsPolicy：交给主线程去执行，多余的任务会被放入队列中，最后的任务还是继续被执行。(一般会用这个,下面那个例子如果用这个就不会报错)

   /* int corePoolSize  核心线程数
    int maximumPoolSize 最大线程数
    long keepAliveTime  存活时间
    TimeUnit unit 时间单位
    BlockingQueue<Runnable> workQueue 等待队列
    ThreadFactory threadFactory  线程工厂
    拒绝策略
    */
    public static void main(String[] args) {
        //ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 5, 1L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(3), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        //可以直接用ExecutorService调用
        ExecutorService executorService = new ThreadPoolExecutor(3, 5, 1L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(3), Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());
        //创建计数器
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i=0;i<10;i++){
                executorService.execute(()->{
                    System.out.println(Thread.currentThread().getName() + "办理业务");
                    countDownLatch.countDown();
                });

            }/*
            一般用来看啥时候完成的
            countDownLatch.await();
            System.out.println(Thread.currentThread().getName()+"任务完成");*/

        executorService.shutdown();

        //5次的时候返回, 123各办理一次,然后再23办理等待区的
        //pool-1-thread-2办理业务
        //pool-1-thread-3办理业务
        //pool-1-thread-1办理业务
        //pool-1-thread-2办理业务
        //pool-1-thread-3办理业务


        //7次的时候就会开个4号线程
        //pool-1-thread-1办理业务
        //pool-1-thread-3办理业务
        //pool-1-thread-2办理业务
        //pool-1-thread-3办理业务
        //pool-1-thread-1办理业务
        //pool-1-thread-4办理业务
        //pool-1-thread-2办理业务

        //9次的时候等候区和柜台都满了,就要启用拒绝策略,这里直接就抛异常了,这个可以由拒绝策略来进行控制
        /*pool-1-thread-2办理业务
        pool-1-thread-3办理业务
        pool-1-thread-4办理业务
        pool-1-thread-1办理业务
        pool-1-thread-4办理业务
        pool-1-thread-2办理业务
        pool-1-thread-3办理业务
        pool-1-thread-5办理业务
        Exception in thread "main" java.util.concurrent.RejectedExecutionException: Task com.yukicris.Thread.ThreadDay5.Knowledge$$Lambda$1/772777427@728938a9 rejected from java.util.concurrent.ThreadPoolExecutor@21b8d17c[Running, pool size = 5, active threads = 0, queued tasks = 0, completed tasks = 8]
        at java.util.concurrent.ThreadPoolExecutor$AbortPolicy.rejectedExecution(ThreadPoolExecutor.java:2047)
        at java.util.concurrent.ThreadPoolExecutor.reject(ThreadPoolExecutor.java:823)
        at java.util.concurrent.ThreadPoolExecutor.execute(ThreadPoolExecutor.java:1369)
        at com.yukicris.Thread.ThreadDay5.Knowledge.main(Knowledge.java:41)*/

    }
}
