package com.yukicris.unitMyself.fileNameChange;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
        // 角色名称列表
        List<String> list = new ArrayList<>(Arrays.asList(
                "星乃 一歌", "天马 咲希", "望月 穂波"
        ));
        // 使用线程池管理线程
        ExecutorService executorService = Executors.newFixedThreadPool(5); // 根据系统资源调整线程池大小
        // 公共保存路径前缀
        String basePath = "D:\\pjskAF\\";
        // 遍历角色列表
        for (int i = 0; i < list.size(); i++) {
            String characterName = list.get(i);
            // 创建保存目录
            File saveDir = new File(basePath + characterName);
            if (!saveDir.exists()) {
                saveDir.mkdirs();
            }
            // 生成角色编号
            String memNum = (i < 9 ? "00" : i < 99 ? "0" : "") + (i + 1);
            
            // 下载图片任务
            for (int j = 1; j < 40; j++) {
                String picNum = (j < 10 ? "00" : j < 100 ? "0" : "") + j;
                
                // 构建URL和文件名
                                //https://storage.sekai.best/sekai-jp-assets/character/member/res001_no044/card_normal.png
                String downUrl = "https://storage.sekai.best/sekai-jp-assets/character/member/res" + 
                                memNum + "_no" + picNum + "/card_normal.png";
                String afterDownName = "AF" + characterName + picNum + ".png";
                
                // 构建保存路径
                String savePath = basePath + characterName;
                
                // 提交下载任务
                final String finalUrl = downUrl;
                final String finalName = afterDownName;
                final String finalSavePath = savePath;
                
                executorService.submit(() -> {
                    JpgFetch fetcher = new JpgFetch(finalUrl, finalName, finalSavePath);
                    fetcher.start();
                    System.out.println(finalName + "-----" + finalUrl);
                });
            }
        }
        
        // 关闭线程池
        executorService.shutdown();
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

    class UrlDwonLoader {
        // 使用缓冲流优化下载，添加重试机制和更灵活的超时配置
        public void downloader(String url, String name, String savePath) {
            int retryCount = 3; // 重试次数
            int timeout = 15000; // 超时时间

            for (int attempt = 0; attempt < retryCount; attempt++) {
                try {
                    URL url1 = new URL(url);
                    URLConnection connection = url1.openConnection();
                    
                    // 设置连接参数
                    connection.setConnectTimeout(timeout);
                    connection.setReadTimeout(timeout);
                    connection.setRequestProperty("User-Agent", "Mozilla/5.0");
                    
                    // 创建文件目录（如果不存在）
                    File saveFile = new File(savePath + "\\" + name);
                    if (!saveFile.getParentFile().exists()) {
                        saveFile.getParentFile().mkdirs();
                    }
                    // 使用缓冲流提升效率
                    try (InputStream inputStream = connection.getInputStream();
                         FileOutputStream fileOutputStream = new FileOutputStream(saveFile)) {
                         
                        byte[] buffer = new byte[8192]; // 增大缓冲区
                        int bytesRead;
                        while ((bytesRead = inputStream.read(buffer)) != -1) {
                            fileOutputStream.write(buffer, 0, bytesRead);
                        }
                        
                        System.out.println(name + " 下载成功");
                        break; // 成功则跳出重试循环
                    }
                } catch (Exception e) {
                    if (attempt < retryCount - 1) {
                        System.out.println(name + " 第 " + (attempt + 1) + " 次下载失败，正在重试...");
                        try {
                            Thread.sleep(2000); // 重试前等待
                        } catch (InterruptedException ie) {
                            Thread.currentThread().interrupt();
                            break;
                        }
                    } else {
                        System.err.println(name + " 下载失败: " + e.getMessage());
                        e.printStackTrace();
                    }
                }
            }
        }
    }




}
