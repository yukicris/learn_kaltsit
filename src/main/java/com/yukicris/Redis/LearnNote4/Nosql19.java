package com.yukicris.Redis.LearnNote4;

public class Nosql19 {

    // SpringBoot整合

    //Spring DATA是和Springboot齐名的项目
    // 重启个项目.jpg
    // 说明,原来使用的jedis被替换成了lettuce
    /**
     * jedis,采用的直连,多个线程操作的话,是不安全的,如果想要避免不安全,使用jedis pool连接池,BIO
     * lettuce : 采用netty,实例可以在多个线程中进行共享,不存在线程不安全的情况!可以减少线程数量,更像NIO模式
     *
     *
     * 引入依赖:
     * <dependency>
     *      <groupId>org.springfreamwork.boot</groupId>
     *      <artifactId>spring-boot-starter-data-redis</>
     * </>
     *
     * 配置
     * spring.redis.host=127.1.0.1
     * spring.redis.port=6379
     *
     * // 基本对象使用
     * redisTemplate.opsforValue().set("mykey","yukicris");  // 如果是中文,存进redis以后是ascll码,未序列化
     * redisTemplate.opsforValue().get("mykey");
     *
     * //获取链接对象
     * RedisConnection connection = redisTemplate.getConnectionFactory().getConnection()
     * connect.flushDB() //一般用不到
     *
     *
     * //在企业中,所有的pojo都会序列化  implement Serialuizable
     *
     */
}
