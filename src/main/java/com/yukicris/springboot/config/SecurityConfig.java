package com.yukicris.springboot.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//AOP实现的
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //链式编程
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //首页所有人可以访问,但是功能页只有对应有权限的人才能访问
        http.authorizeRequests().antMatchers("/").permitAll().
                antMatchers("/level1/**").hasRole("vip1")
                .antMatchers("/level2/**").hasRole("vip2")
                .antMatchers("/level3/**").hasRole("vip3");

        //没有权限默认会到登录页面,需要开启登录的页面
            //  /login (这个登录页面是框架自带的,不是自己写的)

        //定制登录页
        http.formLogin().loginPage("/toLoginForm").loginProcessingUrl("/login").usernameParameter("username").passwordParameter("password");
        //关闭防止跨站请求攻击
        http.csrf().disable();
        http.logout().logoutSuccessUrl("/");
        //定制记住我的参数！
        http.rememberMe().rememberMeParameter("remember");
        // .logoutSuccessUrl("/"); 注销成功来到首页

        //注销,开启了注销功能
        //清空cookie
        //http.logout().deleteCookies("remove").invalidateHttpSession();
        //注销成功,跳到首页
        //http.logout().logoutSuccessUrl("/");
    }

    //认证,在springboot2.0 可以直接使用
    //加密: PasswordEncoder
    //在spring Security 5.0+中新增了很多的加密方法,因为代码可以反编译,所以加一个passwordEncoder
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //这些数据正常应该从数据库(或者内存)读
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("admin").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1","vip2")
                .and().withUser("root").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1","vip2","vip3")
                .and().withUser("guest").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1");
    }
}
