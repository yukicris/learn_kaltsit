package com.yukicris.baseUpgrade.Day1._01知识回顾;


/**
 * 知识回顾
 *
 * 面向对象
 *      用代码去高度模拟现实世界,以便为了人类的业务服务
 *      Java是一种面向对象的高级编程语言(代码风格很像人类的自然语言)
 *
 *
 *
 *      面向对象最重要的两个概念: 类和对象
 *      类: 描述相同事物的共同特征的抽象     人类
 *      对象:  具体存在的实例    实例  == 对象
 *
 *
 *      代码层面,现有类,才能创建出实例对象
 *
 *
 *      定义类的格式 class {
 *          //1 成员变量 (Field: 描述类和对象的属性信息)
 *          //2 成员方法 (Method: 描述类或对象的行为信息).
 *          //3 构造器   (Constructor: 初始化一个类的对象并且返回引用)
 *          //4 代码块
 *          //5 内部类
 *
 *      }
 *      注意 :
 *          -- 类名首字母大写,驼峰写法
 *          -- 一个Java代码文件中,可以定义多个类,但是只能有一个类是public修饰,且public修饰的类名必须为代码的文件名
 *
 *          类中的成分研究
 *              五大成分
 *               //1 成员变量 (Field: 描述类和对象的属性信息)
 *  *            //2 成员方法 (Method: 描述类或对象的行为信息)
 *  *            //3 构造器   (Constructor: 初始化一个类的对象并且返回引用)
 *  *            //4 代码块
 *  *            //5 内部类
 *              只要不是这五大成分,放在类下就会报错
 *
 *
 *
 *     构造器的复习:
 *     初始化一个类的对象并且返回引用
 *          格式:
     *          修饰符  类名(形参){
     *
     *          }
 *          构造器初始化对象的格式:
 *              类名  对象名称  = new 构造器;
 *          一个类默认会自带一个无参构造器,即使不写也存在,如果一个类提供了一个构造器,那么默认的无参构造器就被覆盖了
 *
 */
public class ClassDemo1 {
    //System.out.println("hello");  //此处报错 因为它不是类的五大成分
    // 他是执行方法,不是代码块

    public static void main(String[] args) {
        Student s1 = new Student();   // new的是构造器
    }
}

class Student{

}
