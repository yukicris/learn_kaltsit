package com.yukicris.lambdaLearn;

@FunctionalInterface
public interface Homework3Child<T,R> {
    public R getValue(T t1,T t2);
}
