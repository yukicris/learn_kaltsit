package com.yukicris.mybatis.day3;

public class note3 {
    /**
     * 分页
     *
     * 为什么要分页:
     * 减少查询量
     * 方法1
     * select * from user limit 0,2;每页显示2个,从第0个开始查
     * select * from user limit 3;从第0个到第3个
     *  //select * from user limit 4,-1;从第四个开始到最后一个 现在被修复了
     */

    /**方法2
     * RowBounds分页
     *
     * 它的本质是全查出来然后再java进行分页,效果并不好
     * */


    /**
     * 方法3 pagehelper
     * https://pagehelper.github.io/docs/howtouse/
     */

}
