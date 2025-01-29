package com.yukicris.Thread.ThreadDay7;

// 死锁 : 多个线程互相抱着对方需要的资源,形成僵持
public class DeadLock {
    public static void main(String[] args) {
        Makeup g1 = new Makeup(0,"灰姑娘");
        Makeup g2 = new Makeup(0,"白雪公主");
    }

}
//口红
class Liptick{

}

// 镜子
class Mirror {

}

class Makeup extends Thread{
    // 用static 保证资源只有一份
    static Liptick lipstick = new Liptick();
    static Mirror mirror = new Mirror();

    int choice;//选择
    String girlName;  // 使用化妆品的人

    Makeup(int choice,String girlName) {
        this.choice = choice;
        this.girlName = girlName;
    }


    @Override
    public void run() {
        super.run();
    }

    //需要拿到对方的资源
    private void makeup() throws InterruptedException {
        if (choice == 0) {
            synchronized (lipstick) {
                //获得口红锁
                System.out.println(this.girlName+ " 获得口红锁");
                Thread.sleep(1000);
                //解决此处死锁条件,把这个代码块放到外头,如注释,他会在口红执行完毕后释放锁,然后去调镜子锁
                synchronized (mirror) {//一秒钟后想获得镜子
                    System.out.println(this.girlName+"获得镜子锁");
                }
            }
            /*synchronized (mirror) {//一秒钟后想获得镜子
                System.out.println(this.girlName+"获得镜子锁");
            }*/
        } else {
            synchronized (mirror) {
                //获得口红锁
                System.out.println(this.girlName+ " 获得镜子锁");
                Thread.sleep(2000);
                //解决此处死锁条件,把这个代码块放到外头,如注释
                synchronized (lipstick) {//一秒钟后想获得镜子
                    System.out.println(this.girlName+"获得口红锁");
                }

            }
           /* synchronized (lipstick) {//一秒钟后想获得镜子
                System.out.println(this.girlName+"获得口红锁");
            }*/
        }
    }


    /**
     * 死锁产生条件
     * 1 互斥条件,一个资源每次只能被一个线程使用
     * 2 请求和保持条件, 一个线程因请求资源被阻塞时,对已获得的资源保持不放
     * 3 不剥夺条件,进程已获得的资源,在未使用完之前,不能强行剥夺
     * 4 循环等待条件,若干资源之间形成一种头尾相接的循环等待资源关系
     */
}

