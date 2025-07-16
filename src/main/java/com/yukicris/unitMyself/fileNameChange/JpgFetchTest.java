package com.yukicris.unitMyself.fileNameChange;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class JpgFetchTest {
    //非线程版

    private String url;    //网络图片地址
    private String name;   //保存的文件名
    private String savePath; //保存文件路径


    public JpgFetchTest(String url,String name,String savaPath) {
        this.url = url;
        this.name = name;
        this.savePath = savaPath;
    }



    public static void main(String[] args) {

        /**爬第一个链接*/
        String url = "https://storage.sekai.best/sekai-assets/character/member/res021_no001_rip/card_normal.png";
        List<String> list = new ArrayList<>();
      /*  list.add("星乃 一歌");
        list.add("天马 咲希");
        list.add("望月 穗波");*/
        list.add("日野森 志步");
        list.add("花里 实乃里");
        list.add("桐谷 遥");
        list.add("桃井 爱莉");
       /* list.add("日野森 雫");
        list.add("小豆泽 心羽");
        list.add("白石杏");
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("凤 笑梦");
        list.add("草薙 宁宁");
        list.add("d");
        list.add("宵崎 奏");
        list.add("朝比奈 真冬");
        list.add("东云 绘名");
        list.add("晓山 瑞希");
        list.add("初音 未来");
        list.add("镜音 铃");
        list.add("d");
        list.add("巡音 流歌");
        list.add("MEIKO");*/

        //URL替换
        String memNum = ""; //角色编码
        String picNum = ""; //

        for (int i = 0; i < list.size(); i++) {
            //创建文件夹
            String newFile = list.get(i);
            File file = new File("D:\\pjsk\\"+newFile);
            file.mkdir();
            for (int j = 1; j < 50; j++) {
                try {
                    //"https://storage.sekai.best/sekai-assets/character/member/res021_no001_rip/card_normal.png"
                    if (i < 10) {
                        memNum = "00" + String.valueOf(i + 1);
                    } else {
                        memNum = "0" + String.valueOf(i + 1);
                    }
                    if (j < 10) {
                        picNum = "00" + String.valueOf(j);
                    } else {
                        picNum = "0" + String.valueOf(j);
                    }
                    String downUrl = "https://storage.sekai.best/sekai-assets/character/member/res" + memNum + "_no" + picNum + "_rip/card_normal.png";
                    String downName = list.get(i) + picNum + ".png";
                    String afterDownName = "AF" + list.get(i) + picNum + ".png";
                    // 花前下载
                    //JpgFetch jf1 = new JpgFetch(downUrl,downName,"D:\\pjsk\\"+newFile);
                    // 花后下载
                    // String downUrl1 = "https://storage.sekai.best/sekai-assets/character/member/res"+memNum+"_no"+picNum+"_rip/card_after_training.png";
                    //JpgFetch jf2 = new JpgFetch(downUrl,afterDownName,"D:\\pjsk\\"+newFile);
               /* JpgFetchTest.UrlDwonLoader urlDwonLoader = new JpgFetchTest.UrlDwonLoader();
                urlDwonLoader.downloader(url,name,savePath);*/
                    URL url1 = new URL(downUrl);
                    //模拟真实请求
                    URLConnection connection = url1.openConnection();
                    //设置超时时间(有时候执行卡死死考虑是不是互锁了)
                    connection.setReadTimeout(10 * 1000);
                    connection.setRequestProperty("User-Agent", "Mozilla/5.0");
                    //转换流
                    InputStream inputStream = connection.getInputStream();
                /* File file = new File("D:\\pjsk\\"+newFile);
                file.mkdir();*/

                    FileOutputStream fileOutputStream = new FileOutputStream(new File("D:\\pjsk\\" + newFile + "\\" + downName));

                    byte[] buffer = new byte[1024];
                    int byteRead;

                    while ((byteRead = inputStream.read(buffer)) != -1) {

                        fileOutputStream.write(buffer, 0, byteRead);
                    }

                    fileOutputStream.flush();
                    fileOutputStream.close();
                    inputStream.close();
                    System.out.println(downName + "-----" + downUrl);
                }catch(Exception e) {
                e.printStackTrace();
                System.out.println("IO异常,downloader方法出现问题");
                continue;
            }
            }
        }
    }


    class  UrlDwonLoader{
        //用url方式下载(加个同步防止卡死)
        public synchronized void downloader(String url,String name,String savePath) { //同步锁,这样就不会出现程序跑不完一直卡住
            try {
                //把网页上的url变成文件
                URL url1 = new URL(url);
                //模拟真实请求
                URLConnection connection = url1.openConnection();
                //设置超时时间(有时候执行卡死死考虑是不是互锁了)
                connection.setReadTimeout(10*1000);
                connection.setRequestProperty("User-Agent","Mozilla/5.0");

                //转换流
                InputStream inputStream = connection.getInputStream();
                //保存路径+ 创建一个新文件夹
                String newFile = name.replace(name.substring(name.length()-7,name.length()),"");
                /* File file = new File("D:\\pjsk\\"+newFile);
                file.mkdir();*/

                FileOutputStream fileOutputStream = new FileOutputStream(new File(savePath+"\\"+name));

                byte[] buffer = new byte[1024];
                int byteRead;

                while ((byteRead=inputStream.read(buffer))!=-1) {

                    fileOutputStream.write(buffer,0,byteRead);
                }

                fileOutputStream.flush();
                fileOutputStream.close();
                inputStream.close();
            }catch(Exception e) {
                e.printStackTrace();
                System.out.println("IO异常,downloader方法出现问题");
            }

        }
    }
}
