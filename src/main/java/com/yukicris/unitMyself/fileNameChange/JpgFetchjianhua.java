package com.yukicris.unitMyself.fileNameChange;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JpgFetchjianhua extends Thread{
    private String url;    //网络图片地址
    private String name;   //保存的文件名
    private String savePath; //保存文件路径

    @Override
    public void run() {
        System.out.println("线程:下载文件为"+ name);
        JpgFetchjianhua.UrlDwonLoader urlDwonLoader = new JpgFetchjianhua.UrlDwonLoader();
        urlDwonLoader.downloader(url,name,savePath);

    }

    public JpgFetchjianhua(String url,String name,String savaPath) {
        this.url = url;
        this.name = name;
        this.savePath = savaPath;
    }

    //爬取网站图片
    public static void main(String[] args) {
        /**爬第一个链接*/
        String url = "https://storage.sekai.best/sekai-assets/character/member/res021_no001_rip/card_normal.png";
        List<String> list = new ArrayList<>();
 /*       list.add("星乃 一歌");
        list.add("天马 咲希");
        list.add("望月 穗波");
        list.add("日野森 志步");
        list.add("花里 实乃里");
        list.add("桐谷 遥");
        list.add("桃井 爱莉");
        list.add("日野森 雫");
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
        list.add("东云 绘名");*/
        list.add("晓山 瑞希");
        list.add("初音 未来");
        list.add("镜音 铃");
        list.add("e");
        list.add("巡音 流歌");
        list.add("MEIKO");
        String memNum = ""; //角色编码
        String picNum = ""; //

        for (int i = 0; i < list.size(); i++) {
            //创建文件夹
            String newFile = list.get(i);
            File file = new File("D:\\pjskAF\\"+newFile);
            file.mkdir();
            for (int j = 1; j < 40; j++) {
                //跑图片序号
                if(i+19<9){
                    memNum="00" + String.valueOf(i+1+19);
                }else {
                    memNum="0"+String.valueOf(i+1+19);
                }
                if(j<10){
                    picNum="00"+String.valueOf(j);
                }else {
                    picNum="0"+String.valueOf(j);
                }
                String afterDownName = "AF"+list.get(i)+picNum + ".png";
                String downUrl1 = "https://storage.sekai.best/sekai-jp-assets/character/member/res"+(memNum)+"_no"+picNum+"_rip/card_after_training.png";
                JpgFetchjianhua jf = new JpgFetchjianhua(downUrl1,afterDownName,"D:\\pjskAF\\"+newFile);
                System.out.println(afterDownName+"-----"+downUrl1);
                jf.start();//加了线程一直有图片下载不完整的问题,很奇怪
            }
        }

    }


    class  UrlDwonLoader{
        public synchronized void downloader(String url,String name,String savePath) {
            try {
                //把网页上的url变成文件
                URL url1 = new URL(url);
                //模拟真实请求
                URLConnection connection = url1.openConnection();
                //connection.setReadTimeout(10*1000);
                connection.setRequestProperty("User-Agent","Mozilla/5.0");
                //转换流
                InputStream inputStream = connection.getInputStream();
                //保存路径+ 创建一个新文件夹
                Path path = Paths.get(savePath + "\\" + name);
                if(!Files.exists(path)){
                    File file = new File(savePath + "\\" + name);
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    byte[] buffer = new byte[1024];
                    int byteRead;
                    while ((byteRead=inputStream.read(buffer))!=-1) {
                        fileOutputStream.write(buffer,0,byteRead);
                    }
                    fileOutputStream.flush();
                    fileOutputStream.close();
                }
                inputStream.close();
            }catch(Exception e) {
                e.printStackTrace();
                System.out.println("IO异常,downloader方法出现问题");
            }
        }
    }
}
