package com.yukicris.vue.day1;

public class Knowledge4 {
    /**
     * 额外加一个token
     * 1  首先编写登录页面，同时拿取token，把token存储到vuex中，
     * (也就是登录的同时调用后台返回一个token)
     *
     * 2   在store文件夹下面的index.js文件中，写入以下代码，将token存储到localStorage中：
     *
     * import Vue from 'vue';
     * import Vuex from 'vuex';
     * Vue.use(Vuex);
     * const store = new Vuex.Store({
     *     state: {
     *         // 存储token
     *         Authorization: localStorage.getItem('Authorization') ?localStorage.getItem('Authorization') : ''
     *     },
     *
     *     mutations: {
     *         // 修改token，并将token存入localStorage
     *         changeLogin(state, user) {
     *             state.Authorization = user.Authorization;
     *             localStorage.setItem('Authorization', user.Authorization);
     *         }
     *     }
     * });
     * export default store;
     *
     *
     * 3   因为请求后端接口需要携带token放到请求头headers中，因而在main.js文件中，写入以下代码：
     *
     * //引入axios
     * import axios from 'axios'
     * //使用axios
     * Vue.prototype.axios = axios
     *     //axios携带token
     *     // 添加请求拦截器，在请求头中加token
     * axios.interceptors.request.use(
     *     config => {
     *         if (localStorage.getItem('Authorization')) {
     *             config.headers.Authorization = localStorage.getItem('Authorization');
     *         }
     *         return config;
     *     },
     *     error => {
     *         return Promise.reject(error);
     *     });
     *
     *
     *
     * 4    即可在请求接口的时候，可以携带token拿取后端数据，因而调取后端接口就可以省略请求头的添加：
     * 配置axios
     *
     *
     *   edit(id) {
     *     this.axios
     *       .put("/apis/zhmq/wj/wj/" + id + "/", {
     *         title: this.inputtitle,
     *         explain: this.titletextarea,
     *       })
     *       .then((res) => {
     *         console.log(121324654);
     *         this.centerDialogVisible = false;
     *         this.getarr();
     *       })
     *       .catch((e) => fn);
     *   }
     *
     *
     *
     * 5   在main.js后者router文件夹下面的index.js文件里面加入以下代码，进行全局前置路由守卫，代码如下：
     * router.beforeEach((to, from, next) => {
     *
     *     if (to.path == '/login' || to.path == '/register') {
     *         next();
     *     } else {
     *         const token = localStorage.getItem('Authorization'); // 获取token
     *         // token不存在
     *         if (token === null || token === '') {
     *             alert('您还没有登录，请先登录');
     *             next('/login');
     *         } else {
     *             next();
     *         }
     *     }
     * });
     */
}
