package com.yukicris.Redis.LearnNote2;

public class Nosql7 {
    // redis使用

    /**
     * String  百分之90的人只会个String
     *
     * set key1 v1   : 设置值
     * get key1      : 获得值
     * keys *        : 获得所有key
     * EXISTS key1   : 判断某个key是否存在
     * append key1 "hello"  : 追加字符串,如果当前key不存在,就相当于set key
     * STRLEN key1   : 获取字符串长度
     *
     */


    /**
     * 自增自减
     *
     * set key 0
     * get key
     * incr key    : 自增1
     * decr key    : 自减1
     *
     * INCRBY key 10  :步长(自增10)
     * DECRBY key 10  : 减10
     */


    /**
     * 截取
     *
     * GETRANGE key1 0 3   查看第0到第4个字符串(截取,类似java的subString)
     * GETRANGE key1 0 -1  获取全部的字符串,等效于get key
     *
     *
     */

    /**
     * 替换
     *
     * SETRANGE key1 1 xx  替换指定位置"开始"的字符串, abcdefg这种会被替换成axxdefg
     *
     *
     */


    /**
     * 在分布式锁里会常常使用,存在设置
     *
     * setex (set with expire)  # 设置过期时间
     * setnx (set if not exist)         # 不存在设置  (在分布式锁中会常常使用)
     *
     *     {
     *         setex key3 30 "hello" 设置key3的值为hello ,30秒后过期
     *         ttl key3   查看过期时间
     *
     *         setnx mykey "redis"  如果mykey不存在则创建mykey,如果它存在,则创建失败
     *     }
     */

    /**
     * 批量设置
     *
     * mset k1 v1 k1 v2 k3 v3  批量设置值
     *
     * ksys *  查看
     *
     * mget k1 k2 k3     获取多个值
     *
     * msetnx k1 v1 k4 v4   //这是个原子性操作,要么一起成功,要么一起失败,因为k1存在,所以就失败了
     * get k4  返回nil,为空
     *
     */

    /**
     * 对象
     * set user:1 {name:zhangsan,age:3} : 设置一个user:1对象,值为json字符来保存一个对象
     *
     * 这里key是一个巧妙的设计,user:{id}:{field},这么设计在redis中完全可以
     *
     * 所以可以批量写法
     * mset user:1:name zhangsan user:1:age 2
     * mget user:1:name user:1:age =>  "zhangsan""2"
     */


    /**
     * getset
     * 先get 再set,一般用来搞更新
     *
     * {
     *     getset key v1  //如果不存在,则返回nil
     *     >nil
     *     get key
     *     > v1
     *     getset key v2 //如果存在值,获取原来的值,并设置新的值
     *     >v1
     *     get key
     *     >v2
     * }
     *
     *
     * 数据结构是相通的!
     */


    /**
     * String 类似的使用场景,value 除了是字符串,还可以是数字
     * 1 计数器
     * 2 统计多单位的数量{uid:123321:follow 0 incr}  关注数新增
     * 3 粉丝数
     * 4 对象缓存存储
     *
     *
     */

}
