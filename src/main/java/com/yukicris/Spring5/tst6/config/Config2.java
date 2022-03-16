package com.yukicris.Spring5.tst6.config;

import com.yukicris.Spring5.tst6.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration  //这个也会被spring容器托管,注册到容器中,因为它本来就送一个Component,@Configuration代表这是一个配置类,和beans.xml是一个东西
@ComponentScan("com.yukicris.Spring5")  //加了扫描,@Autowired就可以用了
public class Config2 {

    //注册bean,相当于之前写的bean标签,这个方法的名字,相当于bean标签的id属性,这个方法的返回值,相当于bean标签的class的标签属性
    @Bean  //让这个类被spring所接管,所以user里面的Compenent其实可以不用加
    public User getUser(){
        return new User();    // 返回要注入bean的对象
    }
    //@Bean 注意：1. 如果开启包扫描，加载配置类以后就可以通过反射拿到配置类中的对象了，
    // 2 @Bean 只写在方法上,返回的是一个对象,但是一般不为容器中的对象
    // 3 可以用于通过方法获取数据库连接池Connection这种对象

}
