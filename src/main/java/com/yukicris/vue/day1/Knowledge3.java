package com.yukicris.vue.day1;

public class Knowledge3 {
    /**
     * 遵循CommonsJs规范
     * 核心思想是通过require来同步加载其他模块
     * 然后通过exports或者module.exports来导出需要暴露的接口
     */

    /*
    配置
    创建webpack.config.js

    entry:入口文件,指定webpack用哪个文件作为项目的入口
    output: 输出,指定webpack把处理完成的文件放置到指定的路径
    module: 模块,用于处理各种类型的文件
    plugins:插件,比如热更新,代码重用
    resolve: 设置路径指向
    watch: 监听,用于设置文件改动后直接打包

     */
    //写一个hello.js
   /* exports.sayhi = function(){
        document.write('<h1>yukicris</h1>')
    }*/

    //在main中写
    // var hello = require("./hello");
    //hello.sayhi()
    //就可以直接拿着用


    /**
     *
     * 打包
     * 原理可以看webpack那个文件夹
     *
     * 全局安装webpack
     *
     * npm install webpack -g
     *
     * 注意: 如果安装的是较高版本的webpack,(现在安装的版本都比较高),还需要安装webpack-cli
     *
     * npm install webpack-cli -g
     *
     *
     */

    /**
     * 安装路由
     * npm install vue-router --save-dev
     *
     *
     * main方法中引入
     * import VueRouter from 'vue-router'
     * import axios from 'axios'
     * import VueAxios from 'vue-axios'
     *
     *
     * 然后显示声明
     * 显示声明使用VueRouter(不过这个配置一般在路由配置文件里面)
     * Vue.use(VueRouter);
     * Vue.use(VueAxios,axios)
     *
     *
     * 可能会出现包版本过高
     * 如果发现vue-router not found的问题可能是包版本过高
     * 需要先卸载包npm uninstall vue-router
     * 然后安装低版本npm i vue-router@3.5.2 即可
     *
     *
     */

    /**
     * 组件嵌套
     * {
     *       //路由路径 类似@RequestMapping
     *       path: '/main',
     *       name: 'main',
     *       //跳转的组件
     *       component: Main,
     *       children:[
     *         { path: '/main',component:UserProfile}
     *       ]
     *     },
     *
     *传参:: -----------
     *     他传值方法倒是挺崭新的,前端页面
     *     这里用v-bind 的形式来绑定路由名称,然后带参数
     *         <router-link :to="{name:'main',params:{id:1}}">首页</router-link>
     *     然后在路由里面带参数
     *     {
     *       //路由路径 类似@RequestMapping
     *       path: '/main/ :id',  带参数为这里的id
     *       name: 'main',
     *       //跳转的组件
     *       component: Main,
     *       children:[
     *         { path: '/main',component:UserProfile}
     *       ]
     *     },
     *     //然后在接受页面
     *     <div>
     *     <!-- 所有的元素不能直接放在根节点下,必须用个标签套起来-->
     *     <h1>首页</h1>
     *    {{$route.params.id}}</div>
     *
     *
     *    --------------------
     *    传参方法2
     *    先在router里面增加一个props
     *    {
     *       //路由路径 类似@RequestMapping
     *       path: '/content',
     *       name: 'content',
     *       //跳转的组件
     *       component: Content,
     *       props: true
     *     },
     *     然后跟第一个方法类似,传参数
     *      <router-link :to="{name:'content',params:{password:2}}">内容页</router-link>
     *      然后接受页面,直接就可以用了
     *        props:['password'],
     *
     *
     *
     *
     *        ------------
     *        重定向
     *     路由配置
     *          {
     *       //重定向
     *       path: '/gohome',
     *       redirect: '/main'
     *     }
     *     页面上直接to就可以了
     *
     *
     *
     *     ------
     *     404页面做的有点问题,搞不明白
     *     不重要
     *
     *     ----
     *
     */
}
