package com.yukicris.Redis.LearnNote2;

public class Nosql8 {
    /**
     * list
     *
     * redis 我们可以把list玩成 栈,队列,阻塞队列
     *
     *
     *
     */


    /**
     * 所有的list命令都是用l开头的
     *
     *   LPUSH list one   将一个值或者多个值,可重复,插入到列表的头部,左 (left push)
     *   LPUSH list two
     *   Lpush list three
     *
     *
     * LRANGE list 0 -1  获取全部,可以通过区间获取值(range范围)
     * > "three"
     * > "two"
     * > "one"
     *
     * LRANGE list 0 1  取出来的时候是倒着取
     *  > "three"
     *  > "two"
     *
     *  RPUSH list four   将一个值或者多个值,插入到列表的尾部,右 (right push)
     *
     *  Lrange list 0 -1
     *  > "three"
     *  > "two"
     *  > "one"
     *  > "Four"
     *
     *
     */

    /**
     * LPOP list   : 移除list的第一个元素
     *
     * Rpop list "right"  : 移除list的最后一个元素
     *
     * lindex list 0 : 通过下标获取list的某一个值
     *
     * Llen list : 返回列表长度
     *
     * 移除指定的值
     * 取关uid
     * Lrem
     * lrem list 1 one  移除list中的1个one
     * lrem list 2 three  移除list中的2个three
     *
     * Rpush mylist "hello"
     * Rpush mylist "hello1"
     * Rpush mylist "hello2"
     * Rpush mylist "hello3"
     *
     * ltrim mylist 1 2 : 通过下标截断指定的长度,这个list被改变了,截断了,只剩下截取的元素
     * >"hello1"
     * >"hello2"
     */


    /**
     * rpoplpush : 移除列表最后一个元素,并且移动到新的列表中
     *
     *
     *  Rpush mylist "hello"
     *  Rpush mylist "hello1"
     *  Rpush mylist "hello2"
     *
     *  rpoplpush mylist myotherlist
     *  >"hello2"
     *
     *  lrange mylist 0 -1 查看原来的列表
     *  >"hello"
     *  >"hello1"
     *
     *  lrange myotherlist 0 -1  查看目标列表中确实存在该值了
     *  "hello2"
     *
     *
     */


    /**
     * lset : 将列表中指定下标的值替换为另外一个值,更新操作
     *
     * exists list : 判断列表是否存在
     * >0
     * lset list 0 item : 如果不存在列表,更新就会报错
     * 1push list value1 :创建一个list并存一个value1
     * lrange list 0 0  : 查看list 从0到0个元素
     * >value1
     * lset list 0 item  : 如果list存在,就更新该下标(此处设置下标为0)的值
     * lrange list 0 0
     * >"item"
     *  lset list 1 other : 如果不存在就会报错,此处下标为1不存在
     *  > err index out of range
     */


    /**
     * linsert : 将某个具体的value插入到某个具体的值前面或后面
     *
     * LINSERT mylist before/after "world" "hello"  : 把hello加在"world"的前面或者后面
     */

    /**
     * 总结 ,它实际上是一个链表,left,right都可以插入值
     * 如果key 不存在,创建新的链表
     * 如果key 存在,新增内容
     * 如果key移除了,则为空链表,代表不存在
     *
     * 在两边插入或者改动值,效率最高;中间元素效率会低一点
     *
     */

    /**
     * 功能: 消息排队,消息队列 (Lpuph Rpop 链表,队列) (Lpush Lpop 栈)
     */
}
