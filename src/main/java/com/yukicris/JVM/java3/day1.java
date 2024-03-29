package com.yukicris.JVM.java3;

public class day1 {
    //PC寄存器
    //每个线程都有一个程序计数器,是线程私有的,就是一个指针,指向方法区的方法字节码(用来存储指向一条指令的地址)
    //也即将要执行的指令代码,在执行引擎读取下一条指令,是一个非常小的内存空间,几乎可以忽略不计
    //在线程切换的时候,会从这个寄存器里拿到对应的字节码,知道这个线程执行到哪一步了,然后继续执行
    //线程是最小的执行单位,他只负责干,没有记忆的功能,这个记忆的功能就交给了寄存器



    //方法区(Method Area)
    //方法区是被所有线程所共享,所有字段和方法字节码以及一些特殊方法,比如构造函数,接口代码也在此定义,简单说,所有定义方法的信息都保存在该区域,
    //此区域属于共享空间
    /**
     * 静态变量,常量,类信息(构造方法,接口定义)运行时的常量池存在方法区中(就是参数初始化的时候给的值都放在方法区),但是实例变量(就是new出来以后赋值的参数)存在堆内存中,和 方法区无关
     *
     * static ,final ,Class加载器,运行时的常量池 就放在方法区
     */


    //栈: 数据结构
    // 程序 = 数据结构+算法
    // 我 :程序 = 框架+业务逻辑 = 淘汰
    // 栈 : 先进后出 ,后进先出
    // 队列: 先进先出(FIFO: first input first output)

    /**
     * main方法调用test ,程序先把main方法压进栈,然后main方法调用test,把test压入栈,test执行完,从栈中弹出,再弹出main
     * 如果这里 test调用a,a又调用test,就会无限压栈,stackoverflowError,栈溢出
     *
     * 栈内存,主管程序的运行,生命周期和线程同步;线程结束,栈内存也就释放了对于栈来说不存在垃圾回收问题,一旦线程结束了,栈就OVER了
     *
     * 栈: 8大基本类型+对象引用+实例的方法都会在栈里面
     *
     * 栈运行原理: 栈帧
     * 方法在栈里面就产生出一个栈帧: 包含方法索引(index),输入输出参数,本地变量,ClassFile引用,父帧,子帧 (上面例子里,main的子帧调用test的子帧,test父帧调用main')
     * 程序正在执行的方法,一定在栈顶,执行完了就弹出
     * 无限递归,即栈帧过多会导致栈内存溢出问题  -Xss:该参数规定了每个线程虚拟机栈的大小；
     *
     * 1.7以后,常量池逻辑上在方法区,实际上在堆内存中
     * 栈+堆+方法区
     *
     * 一个class被执行,会在栈中存放方法的引用,然后这个引用会去堆里面找到对象具体的实例,常量会去常量池中找
     *
     * 一个对象实例化的过程在内存中:
     * 1 加载,根据类的全限定名称获取其二进制字节流,将二进制字节流所代表的静态存储结构转化为方法区中运行时数据结构。在内存中创建一个代表该类的Java.lang.Class对象，
     * 作为方法区(主要是这个)这个类的各种数据的访问入口。
     * 2 验证 文件格式验证,数据验证,字节码验证,符号引用验证,保证合规不会影响虚拟机运行
     * 3 准备 ,将类变量(也就是静态变量)分配内存并赋初始值,比如static int a = 0;一般都是0值,final修饰的为赋的值
     * 4 解析,把常量池中的符号替换为直接引用
     * 5 初始化,执行类的构造器方法,为参数赋值
     * 6 分配内存,在堆内存中开辟一个对象内存空间
     * 7 初始化零值 把实例变量赋值为初始值 int b = 0;
     * 8 设置对象头 对象头就是对象的元数据,类似对象的身份证,指定这个对象是哪个类的实例,比如int b=0是属于方法test的,一个指针指向方法区中的test
     * 9 实例对象初始化 虚拟机调用实例构造器方法,根据程序员意愿初始化对象,调用构造函数,完成实例对象初始化 int b = 10;
     * 10 创建引用,入栈: 此时堆内存已经完成了对象创建,这一步在栈中创建对象的引用,压入栈,返回出来给我们使用
     * 11 至此对象创建完成
     */

}
