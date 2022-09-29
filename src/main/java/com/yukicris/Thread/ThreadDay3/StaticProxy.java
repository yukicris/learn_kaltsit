package com.yukicris.Thread.ThreadDay3;

public class StaticProxy {
//静态代理模式
//1 真实对象和代理对象都要实现同一个接口
//2 代理对象要代理真实角色,

//好处: 代理对象可以做很多真实的对象做不了的事情,真实对象专注做自己的事情



    public static void main(String[] args) {
        //原来结婚要这么写,现在加个代理可以执行before和after的工作
        /*You you = new You();
        you.HappyMarry();*/

        //这里的thread代理了runable的方法
        //new Thread(()-> System.out.println("我爱你")).start();

        WeddingCompany weddingCompany = new WeddingCompany(new You());
        weddingCompany.HappyMarry();
    }





}
interface Marry{
    void HappyMarry();
}

class You implements Marry{


    @Override
    public void HappyMarry() {
        System.out.printf("结婚");
    }
}

//代理角色,婚庆公司
class WeddingCompany implements Marry{

    private Marry target;

    public WeddingCompany(Marry target){
        this.target = target;
    }


    @Override
    public void HappyMarry() {
        before();
        this.target.HappyMarry();
        after();
    }


    private void after(){
        System.out.println("结婚后");
    }

    private void before(){
        System.out.println("结婚前");
    }
}

