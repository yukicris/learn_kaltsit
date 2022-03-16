package com.yukicris.Spring5.tst6.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
// 这个注解可以不加...目的是让它被Component-scan扫描到,让它被spring接管,注册到容器中
// 如果它加了,同时也在配置类中加了@Bean,那么会生成2个实例
@Component
public class User {
    private String name;

    public String getName() {
        return name;
    }

    @Value("yukicris")
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
