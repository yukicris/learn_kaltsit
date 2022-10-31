package com.yukicris.Net.UrlDownload;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class UrlDown {
    public static void main(String[] args) throws IOException {
        URL url = new URL("");

        //2 ;链接到这个资源 http
        HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();

        InputStream inputStream = urlConnection.getInputStream();

        FileOutputStream fios = new FileOutputStream("file.txt");
        byte[] buffer = new byte[1024];
        int len;
        while((len=inputStream.read(buffer))!=-1){
            fios.write(buffer,0,len);  //写出这个数据
        }
        fios.close();
        inputStream.close();
        urlConnection.disconnect();//关闭链接
    }
}
