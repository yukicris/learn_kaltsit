package com.yukicris.Redis.LearnNote3;

public class Nosql14 {
    //位存储
    /**
     * 统计用户信息,活跃不活跃,登录,不登录,打卡,不打卡
     *
     */

    // 只有2个状态的都可以使用bigmaps

    /**
     * Bitmaps 位图,数据结构  都是操作二进制位来进行记录,只有0和1两个状态
     *
     * 365天=365 bit 1字节=8bit 46个字节左右 ,一个用户一年的签到内容就46个字节
     *
     *
     * 使用bitmap记录周一到周日的打卡
     *
     * setbit sign 0 1
     * setbit sign 1 0
     * setbit sign 2 0
     * setbit sign 3 1
     * setbit sign 4 1
     * setbit sign 5 0
     * setbit sign 6 1
     *
     *
     * getbit sign 3 查看星期4打卡没
     * >1
     * getbit sign 5
     * >0
     *
     *
     *
     * bitcount sign 统计这周打卡的天数(可以加范围比如0 3 ,统计周一到周四)
     * >4
     *
     *
     */

}
