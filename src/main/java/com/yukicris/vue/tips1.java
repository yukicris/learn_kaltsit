package com.yukicris.vue;

public class tips1 {
    /**
     * 通信种类
     *
     * 1)父组件像子组件通信
     * 2)子组件像父组件通信
     * 3)隔代组件之间通信
     * 4)兄弟组件之间通信
     *
     *
     * 实现通信方式
     * 1 props
     * 2 vue自定义事件
     * 3 消息订阅与发布
     * 4 vuex
     * 5 slot
     *
     * 3 方式
     *   1 props
     *   通过一般属性实现父向子通信
     *   通过函数属性实现子像父通信
     *   缺点: 隔代组件和兄弟组件之间的通信比较麻烦
     *
     *   2 vue自定义事件
     *   vue内置实现,可以代替函数类型的props
     *   a 绑定监听: <mycomp @eventName="callback">
     *   b 触发(分发)事件,this.$emit("eventName",data)
     *   缺点: 只适合子向父通信
     *
     *   3 消息订阅与发布
     *   需要引入消息订阅与发布的实现库,pubsub-js
     *   a 订阅消息 PubSub.subscribe('msg',function(msg,data){})
     *   b 发布消息: PubSub.publish('msg',data)
     *   优点: 此方式可以实现任意关系组件之间通信
     *
     *   4 vuex
     *   vuex是vue官方提供的集中式管理vue多组件共享状态数据的vue插件
     *   优点:对组件之间的关系没有限制,且相比pubsub库管理更集中,更方便
     *
     *   5 slot
     *   专门用来实现父向子传递带数据的标签
     */


    //安利一个不错的ui框架 https://semantic-ui.com/
}
