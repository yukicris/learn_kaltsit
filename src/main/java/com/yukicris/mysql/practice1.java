package com.yukicris.mysql;

public class practice1 {
    // 练习1 各个视频的平均完播率
    //https://www.nowcoder.com/practice/96263162f69a48df9d84a93c71045753?tpId=268&tqId=2285032&ru=/exam/oj&qru=/ta/sql-factory-interview/question-ranking&sourceUrl=%2Fexam%2Foj%3Fpage%3D1%26tab%3DSQL%25E7%25AF%2587%26topicId%3D268
   /* SELECT
    t1.video_id,
    round(
            count( IF ( TIMESTAMPDIFF( SECOND, start_time, end_time ) >= t2.duration, 1, NULL ) ) / count( start_time ),
	3
            ) avg_comp_play_rate
            FROM
    tb_user_video_log t1
    JOIN tb_video_info t2 ON t1.video_id = t2.video_id
    where year(start_time)=2021
    GROUP BY
    t1.video_id
    ORDER BY
    avg_comp_play_rate desc*/

    /**000
     * 考点在 round(a/b,3)  a/b保留3位小数
     * TIMESTAMPDIFF 计算时间差 TIMESTAMPDIFF( SECOND, start_time, end_time ) 按秒来计算
     * using(video_id) 等同于 ON t1.video_id = t2.video_id
     * if (条件,1,2)  条件为true 则为1 ,为false 则为2
     */

}
