package com.yukicris.FaceTest;

import java.util.HashMap;
import java.util.Map;

public class Face9 {
    //复盘 北京万维罗盘
    //首先是先做了2个题,一个是罗马字转数字,我特么硬解的..
    //然后是一个sql题,题目看错了


    //然后问了下设计模式,应该答一下代理模式的,当时只答了适配器模式

    //然后答了数据库优化,in的效率

    //再答了个mybatis一级缓存和二级缓存
    /**
     *   一、一级缓存
     * Mybatis 的一级缓存是指Session缓存。一级缓存的作用域默认是SqlSession。Mybatis默认开启一级缓存。
     * 在同一个SqlSession中，执行相同的查询SQL，第一次会去数据库进行查询，并写到缓存中；第二次以后则直接去一级缓存中取。
     * 当执行的SQL查询中间发生了增删改的操作，mybatis会把SqlSession的缓存清空。
     *
     * 一级缓存失效的情况
     *
     * SqlSession不同；
     * SqlSession相同，查询条件不同。因为缓存条件不同，缓存中还没有数据。
     * SqlSession相同，在两次相同查询条件中间执行过增删改操作。
     * SqlSession相同，手动清空了一级缓存。（如果SqlSession去执行commit操作（执行插入。更新、删除），清空SqlSession中的一级缓存，这样做的目的是为了让缓存中存储的是最新的消息，避免脏读。）
     *
     *
     * 二、二级缓存
     * Mybatis的二级缓存是指mapper映射文件。二级缓存的作用域是同一个nameSpace下的mapper映射文件内容，多个SqlSession共享。Mybatis需要手动设置启动二级缓存。
     * 一个会话，查询一条数据，这个数据会被放在当前会话的一级缓存中；如果会话被关闭了，一级缓存汇总的数据会被保存到二级缓存。新的会话查询信息就会参照二级缓存。
     * 二级缓存的使用原则
     *
     * 只能在一个命名空间下使用二级缓存。由于二级缓存中的数据是基于nameSpace的，即不同nameSpace中的数据互不干扰。在多个nameSpace中若均存在对同一个表的操作，那么这多个nameSpace中的数据可能就会出现不一致现象。
     * 在单表上使用二级缓存。如果一个表与其他表有关联关系，那么就非常有可能存在多个nameSpace对同一数据的操作。而不同nameSpace中的数据互不干扰，所以就有可能出现多个nameSpace中的数据不一致现象。
     * 查询多于修改时使用二级缓存。在查询操作远远多于增删改操作的情况下可以使用二级缓存。因为任何增删改操作都将刷新二级缓存，对二级缓存的频繁刷新将降低系统性能。
     */

    //我草我才发现北科那套mybatis是集成通用mapper来实现增删改查的..就是那个tk.mybatis 可以通过base.mapper包那边去看,所有的mapper都集成了这个东西,然后就可以直接写增删改查
    //感觉mybatis要再学一下,哎,再跟个课吧


    /**
     * 罗马字转数字
     * I ==> 1
     *
     * V ==> 5
     *
     * X ==> 10
     *
     * L ==> 50
     *
     * C ==> 100
     *
     * D ==> 500
     *
     * M ==>1000
     *
     * 例如， 罗马数字 2 写做 II ，即为两个并列的 1 。12 写做 XII ，即为 X + II 。 27 写做 XXVII, 即为 XX + V + II 。
     I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
     X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
     C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     给定一个罗马数字，将其转换成整数。
     */
    public static int parseStr(String romaText){
        //工具类当然可以简化成map形式,一样用
      /*  Map<Character, Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);*/


        //先要遍历,当时遍历用的str转数组,有点小蠢
        //初始化初始整数
        int sum = 0;
        int tempNum = changeValue(romaText.charAt(0));
        for(int i=1;i<romaText.length();i++){
            int num = changeValue(romaText.charAt(i));
            //然后要总结一个规律,就是如果左边比右边小,那么就是相减,否则相加,当时没有写出来,FUCK
            if (tempNum<num){
                sum = sum-tempNum;
            }else {
                sum = sum+tempNum;
            }
            tempNum = num;
        }
        //加上最后一次的
        sum+=tempNum;
        return sum;
    }

    //可以先写一个转换工具
    public static int changeValue(char key){
        int num = 0;
        switch(key){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default:return 0;
        }
    }




    public static void main(String[] args) {
        System.out.println(parseStr("XXVII"));
    }




    //再做下那个sql题目
    //查询工资比经理高的员工
 /*   Employee 表:
            ±—±------±-------±----------+
            | id | name | salary | managerId |
            ±—±------±-------±----------+
            | 1 | Joe | 70000 | 3 |
            | 2 | Henry | 80000 | 4 |
            | 3 | Sam | 60000 | Null |
            | 4 | Max | 90000 | Null |
            ±—±------±-------±----------+
            ————————————————*/

    //题目意思都没理解好..真是蠢 managerId经理对应的人员id,说明那个id的人是经理
    //直接就可以嵌套子查询..是不是忘记可以这么写了...
    //select * from Employee e1 where  salary>(select salary from Employee e2 where e1.managerId = e2.id)


}
