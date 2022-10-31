package com.yukicris.Net.UrlDownload;

import java.net.MalformedURLException;
import java.net.URL;

public class Demo1 {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://localhost:8080/helloworld/index.jsp?username=yukicris&password=123");
        System.out.println(url.getProtocol()); //协议
        System.out.println(url.getHost()); //主机ip
        System.out.println(url.getPort()); //端口
        System.out.println(url.getFile()); //文件地址
        System.out.println(url.getPath()); //文件全路径
        System.out.println(url.getQuery()); //参数


    }
}
