package com.yukicris.Redis.LearnNote2;

public class Nosql11 {
    /**
     * Zset有序集合
     *
     * 在set的基础上,增加了一个(标号score)分数值,set k1 v1 ,zSet k1 score v1
     */

    /**
     *
     *
     * zadd myset 1 one   : 添加一个值
     *
     * zadd myset 2 two 3 three  : 添加多个值
     *
     * zrange myset 0 -1
     * >one
     * >two
     * >three
     */

    /**
     * 排序如何实现
     * zrange key min max
     *
     *
     * zadd salary 2500 xiaohong   : 添加三个用户
     *
     * zadd salary 5000 zhangsan
     *
     * zadd salary 500 yukicris
     *
     * zrangescore salary -inf +inf   : 根据分数显示全部的用户,从小到大,固定语法,-inf 负无穷,+inf正无穷
     * >yukicris
     * >xiaohong
     * >zhangsan
     *
     * zrangeBySCORE salary -inf +inf withscores  : 返回全部用户,并且附带分数
     * >yukicris
     * >500
     * >xiaohong
     * >2500
     * >zhangsan
     * >5000
     *
     *
     *
     *
     */

    /**
     * zrangebyscore salary -inf 2500 withscores # 显示工资小于2500员工的工资
     * >yukicris
     * >500
     * >"xiaohogn"
     * >2500
     *
     *
     * zrevrange salary 0 -1 : 显示工资从高到底,从大到小进行排序
     * >"zhangsan"
     * >"xiaohong"
     * >"yukicris"
     */


    /**
     * 移除rem的元素
     * zrange salary 0 -1
     * >yukicris
     * >xiaohong
     * >zhangsan
     *
     *
     * zrem salary xiaoghong
     * zrange salary 0 -1
     * >yukicris
     * >zhangsan
     */

    /**
     * zcard salary  : 获取集合中的个数
     *
     * zadd myset 1 hello 2 world 3 yukicris
     *
     * zcount myset 1 3  获取区间内的成员数量
     * >3
     * zcount myset 1 2
     * >2
     *
     */
    // 案例思路 zset 排序存储成绩,工资等,排行榜等







}
