package com.yukicris.springboot.Controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Spring
 * Security环境
 */
@Controller
public class RouterController {


    @RequestMapping({"/","/index"})  //可以是数组
    public String index(){
        return "index";
    }


    @RequestMapping("/toLogin")  //可以是数组
    public String toLogin(){
        return "views/login";
    }

    @GetMapping("toLoginForm")
    public String toLoginForm(){
        return "views/login";
    }

    @RequestMapping("/level1/{id}")  //可以是数组
    public String level1(@PathVariable("id") int id){
        return "views/level1/"+id;
    }



    @RequestMapping("/level2/{id}")  //可以是数组
    public String level2(@PathVariable("id") int id){
        return "views/level2/"+id;
    }



    @RequestMapping("/level3/{id}")  //可以是数组
    public String level3(@PathVariable("id") int id){
        return "views/level3/"+id;
    }
}
