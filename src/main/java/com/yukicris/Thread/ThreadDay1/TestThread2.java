package com.yukicris.Thread.ThreadDay1;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.net.URL;

// 练习多线程同步下载图片
public class TestThread2 extends Thread{
    private String url;    //网络图片地址
    private String name;   //保存的文件名

   public TestThread2(String url, String name) {
        this.url = url;
        this.name = name;
    }

    // 下载图片线程的执行体
    @Override
    public void run() {
        WebDownLoader webDownLoader = new WebDownLoader();
        webDownLoader.downloader(url,name);
        System.out.println("下载文件名为"+ name);
    }


    public static void main(String[] args) {
       //这里就是有参构造的好处,构造器是用来创建对象完成对象初始化的,然后有参构造相当于是有参构造 = 无参构造 + setter方法
        //这里就可以直接在new 后面拼值


        TestThread2 t1 = new TestThread2("https://storage.sekai.best/sekai-assets/character/member/res021_no001_rip/card_normal.png","miku1.png");
       // TestThread2 t2 = new TestThread2("https://imgsa.baidu.com/forum/w%3D580/sign=5711ffcb387adab43dd01b4bbbd5b36b/d8f97bcb0a46f21f110112b0f8246b600d33aecb.jpg","2test.jpg");
       // TestThread2 t3 = new TestThread2("http://tiebapic.baidu.com/forum/w%3D580/sign=8207f7b92cc79f3d8fe1e4388aa0cdbc/3981f8faaf51f3deffb50b2283eef01f3b29798c.jpg?tbpicau=2022-05-21-05_b20a3fd5f9b604fe3f1cd5910c7f3d59","3test.jpg");
        t1.start();
       // t2.start();
       // t3.start();
        // 下载路径就在项目路径下

    }

}

// 下载器
class WebDownLoader{
    public void downloader(String url,String name) {
        try {
            //把网页上的url变成文件
            FileUtils.copyURLToFile(new URL(url),new File(name));
        }catch(Exception e) {
            e.printStackTrace();
            System.out.println("IO异常,downloader方法出现问题");
        }

    }
}

