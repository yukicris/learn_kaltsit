package com.yukicris.Thread.ThreadDay2;

public class Knowledge {
    //实现Callable接口,需要返回值类型
    /**
     * 1 实现Callable接口
     * 2 重写call方法,需要抛出异常
     * 3 创建目标对象
     * 4 创建执行服务 ExecutorService ser = Executor.newFixedThreadPool(1)
     * 5 提交执行 Future<Boolean> result1 = ser.submit(t1);
     * 6 获取结果 boolean r1 = result.get()
     * 7 关闭服务 ser.shutdownNow();
     *
     */


}
