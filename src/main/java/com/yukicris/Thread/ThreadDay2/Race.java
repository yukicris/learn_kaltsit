package com.yukicris.Thread.ThreadDay2;

//模拟龟兔赛跑
public class Race implements Runnable{
    //胜利者
    private static String winner;




    @Override
    public void run() {
        for(int i=0;i<=100;i++){

            //模拟兔子休息
            if(Thread.currentThread().getName().equals("兔子")&&i==50){
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            //判断比赛是否结束
            boolean flag = gameover(i);
            if (flag){
                break;
            }
            System.out.println(Thread.currentThread().getName()+"跑了"+i+"步");
        }
    }

    //判断比赛是否完成
    private boolean gameover(int steps){
        //判断是否有胜利者
        if(winner!=null){
            //已经存在胜利者了
            return true;
        }else{
            if (steps==100){
                winner = Thread.currentThread().getName();
                System.out.println("winner is"+winner);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Race race = new Race();
        new Thread(race,"兔子").start();
        new Thread(race,"乌龟").start();
    }
}
