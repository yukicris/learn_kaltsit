package com.yukicris.Redis.LearnNote1;

public class Nosql4 {
    /**
     * 自带的测试工具
     */

    /**
     * 测试: 100个并发连接 100000个请求
     * 先启动redis
     * redis-server myconfig/redis.conf
     * redis-benchmark -h localhost -p 6379 -c 100 -n 100000
     * 这些参数可以去官网改,一开始只需要会用就行了
     * (中途退出ctrl+c)
     *
     *
     * 如何查看这些信息
     * 10000 requests completed in 0.22 seconds  :  10000个请求用了0.22秒
     *   10 parallel clients                     : 10个并行客户端
     *   3 bytes payload                          : 每次保存3个字节
     *   keep alive: 1                           : 保持连接1台服务器(只有一套服务器处理这个请求,单机)
     *   multi-thread: no
     *
     *
     * 96.49% <= 1 milliseconds
     * 99.85% <= 13 milliseconds
     * 99.93% <= 14 milliseconds
     * 100.00% <= 14 milliseconds   : 所有请求14毫秒完成
     * 39370.08 requests per second  : 每秒39371.08个请求
     */
}
