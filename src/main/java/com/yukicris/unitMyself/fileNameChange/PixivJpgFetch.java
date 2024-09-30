package com.yukicris.unitMyself.fileNameChange;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class PixivJpgFetch {

    //非线程版

    private String url;    //网络图片地址
    private String name;   //保存的文件名
    private String savePath; //保存文件路径


    public PixivJpgFetch(String url,String name,String savaPath) {
        this.url = url;
        this.name = name;
        this.savePath = savaPath;
    }



    public static void main(String[] args) {

        /**爬第一个链接*/
        String url = "https://storage.sekai.best/sekai-assets/character/member/res021_no001_rip/card_normal.png";
       /* List<String> list = new ArrayList<>();
        list.add("星乃 一歌");
        list.add("天马 咲希");
        list.add("望月 穗波");*/
        String pixiv_Url = "https://www.pixiv.net";

        //URL替换
        String memNum = ""; //角色编码
        String picNum = ""; //

            File file = new File("D:\\pixiv\\"+"newFile");
            file.mkdir();

                try {
                    //URL url1 = new URL(pixiv_Url+"/artworks/116819154");
                    URL url1 = new URL("https://i.pximg.net/img-original/img/2024/08/10/00/00/17/121337282_p0.jpg");

                    //模拟真实请求
                    URLConnection connection = url1.openConnection();
                    //connection.setReadTimeout(10 * 1000);
                    connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/119.0.0.0 Safari/537.36");
                    connection.setRequestProperty("cookie","first_visit_datetime_pc=2023-11-09%2011%3A23%3A07; p_ab_id=7; p_ab_id_2=5; p_ab_d_id=1970283118; yuid_b=KQWZNJA; b-user-id=d5139e4f-8bdf-cf2b-897f-ea6264385bc5; privacy_policy_notification=0; a_type=0; b_type=1; adr_id=OqDshIiTG3OlLGuCrpK52jystt19ifq3DSxVb6ee4DGT8qkI; __utmz=235335808.1700157121.2.2.utmcsr=zodgame.xyz|utmccn=(referral)|utmcmd=referral|utmcct=/; login_ever=yes; _ga_75BBYNYN9J=deleted; cto_bundle=7M0TR19nTzE5V0NQTklUa3VDa05EbjA2blI4SmxNdVRHZ0FMYmhEZUpRY0pKR0QxWnMweXZmQnBUMmVPeHNGNG5LYXRBVmtOdkh2akhlelZSaTd2MWFqNTJtOGwlMkJ3d2lWQ1BkMTZIbUFxS3ZobVElMkJWSlQ4STBBMzI4b1FsSUw5RXhXOW9FMVRnTnFWaUpMMElsYW4ySnFCJTJGUnZwcXdQZjJWM0dMUXFJNEp5ZzdtJTJGa0wlMkY1VlRORG1FbUlSNXI0U3RDZDZyNzNnb2h2MXo5UWpFSFQ3aWttNkw1QSUzRCUzRA; PHPSESSID=12803255_wiM2Nwcyla03KNPoWxEKPQsq4rOPrTha; c_type=29; privacy_policy_agreement=0; _ga_MZ1NL4PHH0=GS1.1.1716950798.4.1.1716950933.0.0.0; _im_vid=01HZ140CQSBHYCBY56YSJ84XCV; FCNEC=%5B%5B%22AKsRol_2fiE_fRgpAfWkh17ywNQW7fXEuAhbJM_P2uU1iNnYiwkE4mZBanOfAYj0EB5YBnCqaBSeNOZlap447ALloXdruLDkTZ-ffZ1tu7thixAprt5ZAzULQLv8qEgozVLU-7tXQuN3vMDBLpe1Fu97ya3alumThw%3D%3D%22%5D%5D; __utmv=235335808.|2=login%20ever=yes=1^3=plan=normal=1^5=gender=male=1^6=user_id=12803255=1^9=p_ab_id=7=1^10=p_ab_id_2=5=1^11=lang=zh=1; _gcl_au=1.1.545322698.1721198330; __cf_bm=Q8msZKmQGjQ1W5mQCN1HNey3LsaGR_icj3C1SzhcK3k-1723469517-1.0.1.1-1ZQWr_fsZ73BOLY3mnrDfX3IJj_KqwW1AnD9aa_ZefMAU.7fgMn0BXCKiIY_PqSydEZkPGIQUWl_AvXlUss5hhCm2CAdjwtC8mTRancjHAw; __utma=235335808.1892350296.1699496591.1722498683.1723469518.33; __utmc=235335808; cf_clearance=DKQY2XymNK24nW0nfPk.hCc1vqGJmVSVFX7zRDnXGg8-1723469520-1.0.1.1-PFoJKYhhS7jQnMkSFusVCrGLFH5pjkYOb_7AKYobdAGdY9Z1nPl9C15tkZm0ksDU5egCao_1cLwUaJja1mSi4Q; __utmt=1; _gid=GA1.2.808867663.1723469526; __utmb=235335808.4.10.1723469518; _ga_75BBYNYN9J=GS1.1.1723469519.37.1.1723469664.0.0.0; _ga=GA1.2.1892350296.1699496591");
                    connection.setRequestProperty("Refer",pixiv_Url);
                    // 使用BufferedReader读取响应
                    BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String inputLine;
                    StringBuilder content = new StringBuilder();

                    // 读取每一行直到没有更多
                    while ((inputLine = in.readLine()) != null) {
                        content.append(inputLine);
                        content.append("\n");
                    }
                    in.close();

                    // 打印网页源码
                    System.out.println(content.toString());
                    //转换流
                    //InputStream inputStream = connection.getInputStream();
                    /* File file = new File("D:\\pjsk\\"+newFile);
                    file.mkdir();*/
                    /* FileOutputStream fileOutputStream = new FileOutputStream(new File("D:\\pixiv\\" + "newFile" ));
                    byte[] buffer = new byte[1024];
                    int byteRead;
                    while ((byteRead = inputStream.read(buffer)) != -1) {

                        fileOutputStream.write(buffer, 0, byteRead);
                    }
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    inputStream.close();*/
                    System.out.println("下载完毕");
                }catch(Exception e) {
                    e.printStackTrace();
                    System.out.println("IO异常,downloader方法出现问题");
                }


    }


    class  UrlDwonLoader{
        //用url方式下载(加个同步防止卡死)
        public  void downloader(String url,String name,String savePath) { //同步锁,这样就不会出现程序跑不完一直卡住
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
