package com.yukicris.Thread.ThreadDay7;

public class knowledge {
    /**
     * 线程同步
     *
     *
     * 并发
     * 同一个对象被多个线程同时操作
     * 一张卡去2个银行同时取钱,上万人抢100张票
     *
     * 共享资源需要上锁,如果资源在同一个类中,就要锁(同步)方法,如果不在一个类中就同步块
     * 也就是说,锁住变化的量,保证其安全(一致性)
     *
     *
     * 解决方案:队列和锁  也就是同步
     * 在访问时加一把锁,执行完了再把锁给下一个人(上厕所)
     *
     * 一个线程持有锁,会导致其他需要此锁的线程挂起
     * 多个线程竞争的情况下,加锁释放锁会导致较多的上下文切换和调度延时,引起性能问题
     * 如果一个优先级高的线程等待一个优先级低的线程释放锁,会导致优先级倒置,引起性能问题
     *
     */


    //p20
    /**
     * 同步块  synchronized(Obj) {
     *
     * }
     *
     *  obj为 同步监视器
     *      obj 可以是任何对象,但是推荐使用共享资源作为同步监视器,锁住变化的量,保证其安全(一致性)
     *      同步方法中无需指定同步监视器,因为同步方法的同步监视器就是this,就是这个对象本身,或者是class
     *
     *      同步监视器执行过程
     *      1 第一个线程访问,锁定同步监视器
     *      2 第二个线程访问,发现同步监视器被锁定,无法访问
     *      3 第一个线程访问完毕,解锁同步监视器
     *      4 第二个线程访问,发现同步监视器没锁,然后锁定并访问
     *
     *
     *
     * */

     }
