package com.yukicris.exception;

public class knowledge1 {
    /**
     * 1.Exception和Error的区别
     * Exception和Error都继承自Throwable，在Java中只有Throwable类型的实例才可以被抛出或捕获。Error指正常情况下不太可能出现的情况，绝大部分的Error或导致程序崩溃，处于非正常的不可恢复的状态,如OutOfMemoryError、StackOverflowError。是程序中不应该试图捕获的严重问题。Exception是程序正常运行中可以预料的意外情况，可以捕获并处理。
     *
     * 2.运行时异常和一般异常的区别
     * 受检查异常:在编译时被强制检查的异常。在方法的声明中声明的异常。
     * (举例:ClassNotFoundException、IOException)不受检查异常:不受检查异常通常是在编码中可以避免的逻辑错误，根据需求来判断如何处理，不需要再编译期强制要求。
     *
     * 3.写出几种常见的运行时异常(考察编程经验)
     * 运行时异常RuntimeException是所有不受检查异常的基类。
     * NullPointerException、ClassCastException、NumberFormatException、IndexOutOfBoundsException
     *
     * ————————————————
     * 版权声明：本文为CSDN博主「alan true」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。`
     * 原文链接：https://blog.csdn.net/weixin_43556773/article/details/109756306
     */
}
