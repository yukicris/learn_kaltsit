package com.yukicris.Thread.ThreadDay7;

//管程法
public class TestOC {
    // 测试生产者消费者模型,利用缓冲区解决,管程法

    public static void main(String[] args) {

    }

}

//生产者
class Productor extends Thread{
    SynContainer container;

    public Productor(SynContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i=0;i<100;i++){
            System.out.println("生产了"+i+"只鸡");
            container.push(new Chicken(i));
        }
    }
}

//生产者
class Consumer extends Thread{
    SynContainer container;

    public Consumer(SynContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i=0;i<100;i++){
            System.out.println("消费了"+container.pop().id+"只鸡");
            container.push(new Chicken(i));
        }
    }
}

//产品
class Chicken{
    int id; //产品编号

    public Chicken(int id) {
        this.id = id;
    }
}

//缓冲区
class SynContainer{
    //需要一个容器大小
    Chicken[] chickens = new Chicken[10];
    int count = 0;
    //生产者放入产品
    public synchronized void push(Chicken chicken){
        //如果容器满了,就要等待消费者消费
        if (count == chickens.length) {
            // 通知消费者消费,生产等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //如果没有满,就需要丢入产品
        chickens[count] = chicken;
        count ++;
        //可以通知消费者消费了
        this.notifyAll();
    }


    //消费者消费产品
    public synchronized Chicken pop() {
        //判断能否消费
        if (count ==0) {
            //等待生产者生产,消费者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        //如果可以消费
        count --;
        Chicken chicken = chickens[count];
        //吃完了,通知生产者生产
        this.notifyAll();
        return chicken;
    }
}
