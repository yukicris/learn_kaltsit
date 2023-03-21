package com.yukicris.FaceTest;

public class Face16 {
    //这玩意干脆用来记录在凯迪拉克项目中学了点啥玩意
    //首先是mq,延时队列以及冥等性
    /**
     * 涉及业务为线索留资下发,在新用户注册时发放对应的用户地址信息
     * 然后涉及到的功能为mq的生产和消费,
     * 生产者需要对应的key和tag,然后用工具类设定对应的地址进行队列发放(延时类似于一个定时任务),然后他这个延时级别很别致,除非自定义一套,不然时间是码死的
     * 消费者继承一个onmessage接口即可
     * 然后mqde消息冥等性防止重复推送,设置一个key,然后判断redis里面有没有这个key,有就已经被推送过了,直接return,没有的话设置key到redis里面
     *
     */
    //然后是代码提交
    /**
     * 这一块主要是分了很多分支,然后在其他分支合并分支需要用merge into
     * 然后把自己写的代码合到主分支需要把自己代码先提交了,然后切主分支,再去选分支里面的历史提交记录进行cherrypick
     * 这一部分对代码功能要求比较细致,所以需要一个功能一个提交point,免得cherrypick不好选哪些功能可以提交哪些不可用
     */
    //然后是做了功能,主要能提及的是postman那部分
    /**
     * 俩比较水的功能,一个提车试驾,对之前接口进行改造,加点参数返回一下就行
     * 然后一个插播分页
     * 对StringUtils用的比较多,然后也算是写了一个小的分类算法,可以在算法那部分找到,没啥难的也没啥好说的
     * 主要是postman的环境设置以及一些接口返回参数提供给其他接口使用这部分,单独开了个文件夹,在konwledge里面,这个还蛮新鲜的,但是很基础
     * easyops发版,这个就是自动部署发版的部分了,可以自己学着搭一下,apollo应该也是一样,不难
     */
    //再然后是做了那个啥提车码的接口,技术主要设计单测部分
    /**
     * 这玩意也是接第三方,然后随便改改,搞来搞去的
     * 主要是很多地方判null比较严重
     * 然后是单测,mokito单元测试,我也单独开了个版
     */
    /**
     * 基础
     * instanceof 这个保留关键字第一次见,表示类等比,xx类属于xx类,返回boolean ,继承也可以
     * mq 冥等性,加个redis锁,确保请求唯一性
     * String key = xx(用mq消息key/tag,msgId等拼接)
     * Lock lock = new RedisLock(redisTemplate)
     * if (!lock.tryLock(key,Integer.parseInt(mqDdlayTime),TimeUnit.SECONDS)) {
     *     return false;
     * }
     * return true;
     */


    public static void main(String[] args) {
        String a = "hello";
        String b = "he"+new String("llo");
        System.err.println(a==b);  //false  -顺便equals是true
    }

    // 查语文比数学好的同学名单
 /*   select chinese.student_id,chinese.cname,chinese.number,math.cname,math.number from
            (select student_id,cname,number from score
                    left join course on score.course_id=course.cid
                    where cname="语文") as chinese
    left join
            (select student_id,cname,number from score
                    left join course on score.course_id=course.cid
                    where cname="数学") as math
    on chinese.student_id=math.student_id
    where chinese.number>math.number;*/


}
