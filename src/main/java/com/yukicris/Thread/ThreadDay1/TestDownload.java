package com.yukicris.Thread.ThreadDay1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class TestDownload extends Thread{
    //测试通过,没啥毛病,可以改成线程池

    private String url;
    private String filename;
    private String member;
    private String no;

    public TestDownload(String url, String name) {
        this.url = url;
        this.filename = name;
    }


    // 下载图片线程的执行体
    @Override
    public void run() {
        String downPath = "D:\\pjsk\\"+String.valueOf(member);

        downUrlTxt(filename,url,downPath);
        System.out.println("下载文件名为"+ filename);
    }

    public static void main(String[] args) {
        int member = 21;
        int no = 34;
        String url1 = "https://storage.sekai.best/sekai-assets/character/member/res0"+String.valueOf(member)+"_"+"no0"+String.valueOf(no)+"_rip/card_normal.png";
        System.out.println(url1+"-------------------");
        String filename1 = "no" + no +"_rip/card_normal.png";
        TestDownload t1 = new TestDownload(url1,filename1);

        String filename2 = "no" + no +"_rip/card_after_training.png";
        String url2 = "https://storage.sekai.best/sekai-assets/character/member/res0"+String.valueOf(member)+"_"+"no0"+String.valueOf(no)+"_rip/card_after_training.png";
        TestDownload t2 = new TestDownload(url2,filename2);
       // TestThread2 t2 = new TestThread2("https://imgsa.baidu.com/forum/w%3D580/sign=5711ffcb387adab43dd01b4bbbd5b36b/d8f97bcb0a46f21f110112b0f8246b600d33aecb.jpg","2test.jpg");
        //TestThread2 t3 = new TestThread2("http://tiebapic.baidu.com/forum/w%3D580/sign=8207f7b92cc79f3d8fe1e4388aa0cdbc/3981f8faaf51f3deffb50b2283eef01f3b29798c.jpg?tbpicau=2022-05-21-05_b20a3fd5f9b604fe3f1cd5910c7f3d59","3test.jpg");
        t1.start();
        t2.start();
        //t3.start();



     /*下载体

       String fileName= "1.png";

        String fileUrl = "https://storage.sekai.best/sekai-assets/character/member/res021_no001_rip/card_normal.png";
        //card_after_training.png

        String downPath = "D:\\pjsk\\"+member;

        downUrlTxt(fileName,fileUrl,downPath);*/
    }




    public static void downUrlTxt(String fileName,String fileUrl,String downPath){

        File savePath = new File(downPath);

        if (!savePath.exists()) {

            savePath.mkdir();

        }

        String[] urlname = fileUrl.split("/");

        int len = urlname.length-1;

        String uname = urlname[len];//获取文件名

        try {

            File file = new File(savePath+"/"+uname);//创建新文件

            if(file!=null && !file.exists()){

                file.createNewFile();

            }

            OutputStream oputstream = new FileOutputStream(file);

            URL url = new URL(fileUrl);

            URLConnection uc ;

            uc = url.openConnection();
            //伪装成浏览器发包
            uc.addRequestProperty("User-Agent",

                    "Mozilla/4.0 (compatible; MSIE 6.0;WindowsNT 5.0)");

            uc.setDoInput(true);//设置是否要从 URL 连接读取数据,默认为true

            uc.connect();

            InputStream iputstream = uc.getInputStream();

            System.out.println("filesize is:"+uc.getContentLength());//打印文件长度

            byte[] buffer=new byte[4*1024];

            int byteRead = -1;

            while((byteRead=(iputstream.read(buffer)))!= -1){

                oputstream.write(buffer, 0, byteRead);

            }

            oputstream.flush();

            iputstream.close();

            oputstream.close();

        } catch (Exception e) {

            System.out.println("读取失败！");

            e.printStackTrace();

        }

        System.out.println("生成文件路径："+downPath+fileName);

    }




}
