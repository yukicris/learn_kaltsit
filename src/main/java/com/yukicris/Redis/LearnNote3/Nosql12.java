package com.yukicris.Redis.LearnNote3;

public class Nosql12 {
    //特殊数据类型
    //geospatial 地理位置

    /**
     * 朋友的定位,附近的人,打车的位置
     * Redis 的geo,3.2版本推出,这个功能可以推算地理位置的信息,两地之间的距离,方圆几里的人
     *
     * geoadd china:city 116.40 39.90 beijing  : 添加地理位置: 规则:两级无法直接添加(有效经度-180到180,有效纬度-85.05到85.05,超出则会报错),一般会直接下载城市数据,,直接通过java程序一次性导入
     * geoadd china:city 121.47 31.23 shanghai
     * geoadd china:city 106.50 29.53 chongqin 114.05 22.52 shenzhen
     *
     *
     *
     * geopos china:city beijing : 获取指定的经度和纬度
     * >116.39999
     * >39.9000
     *
     * geodist china:city beijing shanghai km : 查看伤害到北京的直线距离
     * >1067.3788
     *
     *
     *
     * 附近的人 ,获得附近的人的地址,定位,通过半径来查询
     *
     * georadius china:city 110 30 1000 km   以110,30的经纬度为中心,1000km为半径内的元素
     *
     * georadius china:city 110 30 1000 km withdist   以110,30的经纬度为中心,1000km为半径内的元素,且显示距离中心的距离
     *
     * georadius china:city 110 30 1000 km withcoord  以110,30的经纬度1000km为半径内的元素,且显示该元素的经纬度
     *
     * georadius china:city 110 30 1000 km withcoord count 1  筛选出指定距离的元素,写1 则返回距离最近的那一个
     *
     *
     *
     * georadiusbymember china:city beijing 1000 km   找出位于指定元素周围指定距离的其他元素
     * >beijing
     * >xian
     *
     *
     * geohash 命令,返回一个或多个位置元素的geohash表示
     * geohash china:city beijing chongqin   :将二维的经纬度转换为一维的字符串,如果2个字符串越接近,距离越近
     * >wx4fbxxfke0
     * >wm5xzrybty0
     *
     *
     *
     * geo底层实现原理就是zset ,可以使用zset来操作geo
     * zrange china:city 0 -1 查看所有的值
     *
     * zrem china:city beijing   移除指定元素北京
     *
     *
     *
     *
     */


}
