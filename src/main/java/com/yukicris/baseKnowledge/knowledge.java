package com.yukicris.baseKnowledge;

public class knowledge {

    String name;

    /**
     *
     * JDK(Java Development kit) 是java 开发工具
     *
     * Jre (Java Runtime EWnvironment) java运行环境
     *
     * JVM java虚拟机,相当于在pc上模拟了一个cpu来进行处理java代码
     */


    /**
     * 常见数据结构
     *
     *  {
     *      1 整数扩展 : 进制  二进制0b  十进制  八进制0  十六进制0x
     *
     *      int i = 10;    >打印10
     *
     *      int i2 = 010;   >打印8
     *
     *      int i3 = 0x10;  >打印16   (0x11 > 17)
     *
     *      2 浮点数
     *      //float    //有限, 离散  (舍入误差) 大约 接近但是不等于
     *      //double
     *      float f = 0.1f; //0.1
     *      float d = 1.0/10; //0.1
     *      f==d > flase
     *      float d1 = 23131313132123f;
     *      float d2 = d1+1;
     *      d1 == d2;  > true
     *
     *
     *
     *      一般使用BigDecimal!!!
     *
     *      // 最好完全避免使用浮点数进行比较!!
     *
     *
     *
     *      3 字符扩展
     *      char c1 = 'a';
     *      char c2 = '中';
     *      sout(c1);
     *      sout((int) c1); >打印出数字97
     *      sout(c2);
     *      sout((int) c2); >打印出数字20013
     *      // 所有的字符本质还是数字
     *      Unicode  二字节  0-65535
     *
     *      //转义字符  /t (空格,制表符 ,table)  /n(换行...)
     *
     *
     *
     *      4 String
     *
     *      String a = new String("Hello world");
     *      String b = new String("Hello world");
     *      sout(a==b);  >false 地址不同,常量池一个,堆里一个
     *
     *      String c = "hello world";
     *      String d = "hello world";
     *      sout(c==d)  > true  都是指向常量池的
     *
     *
     *
     *
     *  }
     *
     *
     *
     */


    /**
     *  类型转换
     *      1 长转短  (强制转换,从高类型转低类型)
     *         int i = 128;
     *         byte b = (byte)i;   //内存溢出
     *         sout(i);
     *         sout(b);
     *         >128;
     *         >-128;
     *         低转高为自动转换
     *      {
     *         1 不能对布尔值进行转换
     *         2 不能把对象类型转换为不相干的类型
     *         3 在把高容量转低容量的时候强制转换
     *         4 转换的时候存在内存溢出,或者精度问题(sout(int)23.7)>23  | sout((int)-25.89f) > -25
     *      }
     *
     *      操作比较大的数,注意溢出问题
     *      小tips ,jdk7新特性 ,数字之间可以用下划线分割
     *      int money = 10_0000_0000;
     *      int years = 20;
     *      int total = money*years;  //-1474836480  ,溢出
     *      long total2 = money*year; //-1474836480  ,默认是int,转换之前已经有问题了
     *      应该这么做
     *      long total3 = money* ((long)years);
     *
     *
     *
     *
     *
     */

    /**
     * 变量和常量
     *
     *      变量是程序中最基本的储存单元,要素 包括变量名,变量类型和作用域
     *          (相当于在内存中要了一个空间,取了个名字,然后给你放东西)
     *
     *          {
     *              局部变量: 必须声明和初始化值
     *              main 方法里面,   int i;这种会报错,要写int i = 0;
     *          }
     *          {
     *              实例变量 : 类里面,方法的外面,从属于对象(类),可以int age;
     *              需要new 类型才能使用,默认值 0 0.0 false,除了基本类型,其他为null
     *          }
     *          {
     *              类变量  static
     *          }
     *
     *       常量: 初始化后不能在改变值,不会变动的值,一般用final修饰,一般使用大写字符
     *
     */

    /**
     * while 循环和do while循环
     *          while(i<100){
     *              i++;
     *              sout(i);
     *          }
     *          while(true){
     *              // 死循环 一般用来搞闹钟,监听等
     *          }
     *
     *
     *          do while ,即使不满足,也会执行至少一次
     *           do {
     *               sum = sum + i;
     *               i++;
     *           }while(i<100)
     *
     */

    /**
     * 递归结构包括两个部分
     *      递归头: 什么时候不调用自身方法,又叫边界条件
     *      递归体: 什么时候调用自身方法,然后返回阶段返回结果
     *
     *      不需要太过在意返回的值是什么,就只考虑什么时候停止,以及函数体
     *      3*f(2)*f(1) ,然后到了1,停止调用,然后开始计算值
     */
    // 阶乘  5!
    public static int f(int n){
        if (n == 1){
            return 1;
        }else {
            return n*f(n-1);
        }
    }


    /**
     * 构造器
     * 作用是: 1 使用new 关键字的时候,本质调用构造器
     *        2构造器一般用来初始化值
     *
     *
     * 又称为构造方法,创建对象时必须要调用!
     * 没有返回体和void!
     *
     *
     * {
     *     1个类即使什么都不写,他也会存在一个方法
     * }
     *
     *
     *
     */
    public knowledge(){
        // 无参构造的作用: 实例化一些初始值
        this.name = "yukicris";
    }

    public knowledge(String name){
        // 有参构造: 一旦定义了有参构造,无参构造必须显式定义,就是说上面那个构造器必须显式的写出来
        this.name = name;
    }
    // Knowledge knowledge = new Knowledge("Yukicris");


    /**
     * 对象如何new 出来
     *
     * 栈: 方法压进栈,然后从栈中引用变量名(相当于栈中存的都是方法的名字,和变量的名字)
     *
     * 堆: 包括方法区(包括类,方法和常量池以及静态方法区,所以静态方法一般和类一起加载),方法区以外一般存放我们具体的对象
     *
     */


    /**
     *  super关键字
     *
     * 子类调用父类的构造器时候,super(),这个一般影藏,写出来的话必须放在第一行
     *
     * super 必须只能出现在子类方法或者构造方法中
     * super和this不能同时调用构造方法(因为都必须在第一行)
     *
     *
     * this: 本身调用者这个对象
     * super 父类对象的引用
     *
     * 前提:
     *      this: 没有继承也可以使用
     *      super; 只能在继承条件下使用
     * 构造方法
     *      this: 本类构造
     *      super: 父类构造
     *
     * /


     /**
     *  static
     *
     *  静态变量一般和类一起加载,可以用类名调用  Student.age
     *
     *  静态可以调用静态,普通方法可以调用静态方法,但是静态无法调用普通方法,因为还没编译,必须通过实例对象new了才能调用
     *
     *  static {
     *      //静态代码块,永久只执行一次,且最早,后面再次new这个对象不会再执行了
     *  }
     *  {
     *     // 匿名代码块,第二执行
     *  }
     *  //第三执行构造方法
     *
     *
     *  // 静态导入包
     *  import static java.lang.Math.PI;
     */

    /**
     * 抽象类
     *
     * 1 abstract修饰的类就是抽象类
     *
     *
     * // 约束,由别人来完成,
     * //abstract 抽象方法,只有方法名字,没有方法实现
     * 2 public abstract void doSomething();
     *
     * 特点: 1 抽象类不能new ,只能靠子类实现它
     *      2 抽象类中可以写普通方法
     *      3 抽象方法必须在抽象类中
     *      4 有构造器,虽然不能new,但是子类的创建需要通过父类的构造器来实例化
     *
     *      //存在意义,提高开发效率
     *
     */

    /**
     * 接口
     *      普通类: 只有具体实现
     *      抽象类: 具体实现和规范(抽象方法)都有
     *      接口: 只有规范,自己无法写方法     约束实现分离,面向接口编程
     *
     *      接口中的所有定义都是抽象的(都是abstract修饰的)
     *      接口中定义的常量默认是public static final修饰的
     *
     *      接口不能被实例化,接口中没有构造方法
     *      implements 可以实现多个接口
     *      必须要重写接口中的方法
     */

    /**
     * 内部类
     *
     * 成员内部类:
     *
     */
     private int id=10;
     public void out() {
         System.out.println("这是外部类的方法");
     }
     public class Inner{
         public void in(){
             System.out.println("这是内部类的方法");
         }
         //获得外部类的私有属性
         public void getId(){
             System.out.println(id);
         }
     }
     // 通过外部类来实例化内部类
    // Outer.Inner inner = outer.new Inner();

    /**
     * 内部类
     *
     * 静态内部类:
     *
     */
    public void out1() {
        System.out.println("这是外部类的方法");
    }
    public static class Inner1{
        public void in(){
            System.out.println("这是内部类的方法");
        }
        //获得外部类的私有属性
       /* public void getId(){
            System.out.println(id); 这里id 会报红,因为是static修饰的,而id是实例变量,还没有加载出来
        }*/
    }
    // 通过外部类来实例化内部类
    // Outer.Inner inner = outer.new Inner();

    /**
     * 局部内部类
     */
    public void method() {
        class Inner3{
            public void in(){

            }
        }
    }



    /**
     * 异常
     *
     * RuntimeException 运行时异常
     *    ArrayIndexOutOfBoundsException
     *    NullPointerExption
     *    ArithmeticException算术异常
     *    MissingResourceException 丢失资源
     *    ClassNotFoundException 找不到类
     *
     *
     *    快捷键 ctrl+alt+t
     *    system.exit()程序结束
     *
     *    手动抛出异常
     *    throw new Exception();
     *    方法中处理不了这个异常,方法上抛出异常
     *    throws Exception
     */

    /**
     * 自定义异常
     */
    public class MyException extends Exception {
        // 比如传个数大于10,抛出异常
        private int detail;
        //定义构造方法
        public MyException(int a ){
            this.detail = a;
        }

        // 异常的打印信息
        @Override
        public String toString() {
            return "MyException{" +
                    "detail=" + detail +
                    '}';
        }
    }
}


// 一个java类中,可以有多个class类,但是只能有一个public class,
class A{
    public static void main(String[] args) {
        // 一般用来写测试,因为可以写main方法
    }
}
