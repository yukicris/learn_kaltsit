package com.yukicris.FaceTest;

public class Face {
    public static void main(String[] args) {
        /**
         * 面试官您好,我是2017年毕业于武汉理工大学华夏学院的叶蔚
         * 今年27岁,从2017年至今已经从事了5年JAva开发 工作
         * 完整参与过多个项目的开发以及部分项目的后续维护工作
         * 在项目中 我曾使用过多个后台框架如spring,mybatis以及微服务框架springboot,
         * 掌握并参与设计过mysql,postgreSql等数据库库表,
         * 也可以熟练使用redis缓存数据库以及RabbitMq消息分发中间件
         * 同时也可兼任前端Vue框架的功能开发
         * 项目后期也可参与项目Linux环境下后端tomcat部署以及JVM调优等运维工作
         * 我善于在工作中总结和学习,希望在这场面试中可以和面试官多多交流学习
         *
         *
         *
         *
         *
         *
         * 做过最困难的事情,
         * 需要做案卷文档上的指纹的扫描功能
         * 因为案卷文档上面有很多的指纹和签名,这些指纹和签名需要录入比对库
         * 但是案卷文档非常庞大,是由很多的字节流图片组成的集合
         * 当时从数据库读出这部分的对象集合以后,单独开启了一个线程池对这个对象集合进行遍历
         * 开启了10个最大线程,5个核心线程以及50个等待队列
         * ,然后使用springboot自带的restTemplate服务调用公司的一个扫描图片指纹签名坐标的接口,实现对截取的指纹签名的图片数据保存
         * 因为这部分的数据对一致性要求并不是很高,所以当时采用的拒绝策略是抛弃异常数据继续执行任务(CallerRunsPolicy),在当时看来是足够使用且适合的
         */
    }
}
