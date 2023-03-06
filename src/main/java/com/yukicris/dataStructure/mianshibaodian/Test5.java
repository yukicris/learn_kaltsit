package com.yukicris.dataStructure.mianshibaodian;

import java.util.Deque;

public class Test5 {
    public static void main(String[] args) {

    }

    //题目  用俩栈来实现队列

    //解将一个栈当作输入栈，用于压入
    //appendTail 传入的数据；另一个栈当作输出栈，用于
    //deleteHead 操作。
    //
    //每次
    //deleteHead 时，若输出栈为空则将输入栈的全部数据依次弹出并压入输出栈，这样输出栈从栈顶往栈底的顺序就是队列从队首往队尾的顺序。
    //
   /* 输入：
            ["CQueue","appendTail","deleteHead","deleteHead","deleteHead"]
            [[],[3],[],[],[]]
    输出：[null,null,3,-1,-1]

    来源：力扣（LeetCode）
    链接：https://leetcode.cn/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

    Deque<Integer> inStack;
    Deque<Integer> outStack;

    public Test5() {

    }

    public void appendTail(int value) {
        //只需要入栈即可(加入队列)
        inStack.push(value);
    }


    public int deleteHead() {
        if(outStack.isEmpty()){
            if(inStack.isEmpty()){
                return -1;
            }
        }
        return outStack.pop();
    }

    private void in2out() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }



/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
}
