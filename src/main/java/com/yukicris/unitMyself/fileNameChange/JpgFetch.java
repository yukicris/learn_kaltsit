package com.yukicris.unitMyself.fileNameChange;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class JpgFetch extends Thread{

    private String url;    //网络图片地址
    private String name;   //保存的文件名
    private String savePath; //保存文件路径

    @Override
    public void run() {
       /* WebDownLoader webDownLoader = new WebDownLoader();
        webDownLoader.downloader(url,name);*/
        System.out.println("线程:下载文件为"+ name);
        UrlDwonLoader urlDwonLoader = new UrlDwonLoader();
        urlDwonLoader.downloader(url,name,savePath);

    }

    public JpgFetch(String url,String name,String savaPath) {
        this.url = url;
        this.name = name;
        this.savePath = savaPath;
    }

    //爬取网站图片
    public static void main(String[] args) {
        /**爬第一个链接*/
        String url = "https://storage.sekai.best/sekai-assets/character/member/res021_no001_rip/card_normal.png";
        List<String> list = new ArrayList<>();
        list.add("星乃 一歌");
        list.add("天马 咲希");
        list.add("望月 穗波");
       /* list.add("日野森 志步");
        list.add("花里 实乃里");
        list.add("桐谷 遥");
        list.add("桃井 爱莉");
        list.add("日野森 雫");*/
        List<String> list1 = new ArrayList<>();
        list1.add("小豆泽 心羽");
        list1.add("白石杏");
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("凤 笑梦");
        list1.add("草薙 宁宁");
        list1.add("d");
        List<String> list2= new ArrayList<>();
        list2.add("宵崎 奏");
        list2.add("朝比奈 真冬");
        list2.add("东云 绘名");
        list2.add("晓山 瑞希");
        list2.add("初音 未来");
        list2.add("镜音 铃");
        list2.add("巡音 流歌");
        list2.add("MEIKO");

        //URL替换
        String memNum = ""; //角色编码
        String picNum = ""; //

        for (int i = 0; i < list.size(); i++) {
            //创建文件夹
            String newFile = list.get(i);
            File file = new File("D:\\pjskAF\\"+newFile);
            file.mkdir();
            for (int j = 1; j < 40; j++) {
                //"https://storage.sekai.best/sekai-assets/character/member/res021_no001_rip/card_normal.png"
                if(i<10){
                    memNum="00" + String.valueOf(i+1);
                }else {
                    memNum="0"+String.valueOf(i+1);
                }
                if(j<10){
                    picNum="00"+String.valueOf(j);
                }else {
                    picNum="0"+String.valueOf(j);
                }
                String downUrl = "https://storage.sekai.best/sekai-jp-assets/character/member/res"+memNum+"_no"+picNum+"_rip/card_normal.png";
                //String downName = list.get(i)+picNum + ".png";
                String afterDownName = "AF"+list.get(i)+picNum + ".png";
                // 花前下载
                //JpgFetch jf1 = new JpgFetch(downUrl,downName,"D:\\pjskAF\\"+newFile);
                // 花后下载
                //https://storage.sekai.best/sekai-jp-assets/character/member/res001_no035_rip/card_normal.png
                String downUrl1 = "https://storage.sekai.best/sekai-jp-assets/character/member/res"+memNum+"_no"+picNum+"_rip/card_after_training.png";
                JpgFetch jf2 = new JpgFetch(downUrl,afterDownName,"D:\\pjskAF\\"+newFile);
                System.out.println(afterDownName+"-----"+downUrl);
                jf2.start();//加了线程一直有图片下载不完整的问题,很奇怪
            }
        }

    }



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

    class  UrlDwonLoader{
        //用url方式下载(加个同步防止卡死)
        public synchronized void downloader(String url,String name,String savePath) { //同步锁,这样就不会出现程序跑不完一直卡住
            try {
                //把网页上的url变成文件
                URL url1 = new URL(url);
                //模拟真实请求
                URLConnection connection = url1.openConnection();
                //设置超时时间(有时候执行卡死死考虑是不是互锁了)
                // connection.setReadTimeout(10*1000);
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
