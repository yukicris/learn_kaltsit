package com.yukicris.springboot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSecurityStart {
    //SpringBootApplication只会扫描当前包下面的文件
    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityStart.class,args);
    }
}
