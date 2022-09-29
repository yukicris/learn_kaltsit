package com.yukicris.Thread.ThreadDay2;

import com.yukicris.Thread.ThreadDay1.TestThread2;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.net.URL;
import java.util.concurrent.*;


//线程创建方式3,实现callable接口
public class TestCallable implements Callable {
    private String url;    //网络图片地址
    private String name;   //保存的文件名

    public TestCallable(String url, String name) {
        this.url = url;
        this.name = name;
    }

    // 下载图片线程的执行体
    @Override
    public Boolean call() {
        WebDownLoader webDownLoader = new WebDownLoader();
        webDownLoader.downloader(url,name);
        System.out.println("下载文件名为"+ name);
        return true;
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //这里就是有参构造的好处,构造器是用来创建对象完成对象初始化的,然后有参构造相当于是有参构造 = 无参构造 + setter方法
        //这里就可以直接在new 后面拼值
        TestCallable t1 = new TestCallable("https://imgsa.baidu.com/forum/w%3D580/sign=1ea440d22f3fb80e0cd161df06d02ffb/a92da8d3fd1f41348847499d2b1f95cad0c85e97.jpg","1.jpg");
        TestCallable t2 = new TestCallable("https://imgsa.baidu.com/forum/w%3D580/sign=5711ffcb387adab43dd01b4bbbd5b36b/d8f97bcb0a46f21f110112b0f8246b600d33aecb.jpg","2.jpg");
        TestCallable t3 = new TestCallable("http://tiebapic.baidu.com/forum/w%3D580/sign=8207f7b92cc79f3d8fe1e4388aa0cdbc/3981f8faaf51f3deffb50b2283eef01f3b29798c.jpg?tbpicau=2022-05-21-05_b20a3fd5f9b604fe3f1cd5910c7f3d59","3.jpg");


        //创建执行服务,开启3个线程
        ExecutorService ser = Executors.newFixedThreadPool(3);
        //提交执行
        Future<Boolean> r1 = ser.submit(t1);
        Future<Boolean> r2 = ser.submit(t2);
        Future<Boolean> r3 = ser.submit(t3);
        //获取结果
        boolean rs1 = r1.get();
        boolean rs2 = r2.get();
        boolean rs3 = r3.get();
        //关闭服务
        ser.shutdownNow();

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