package com.yukicris.JVM;

public class Car {

    public int age;

    public static void main(String[] args) {
        // 类是模板,对象是具体的
        Class<Car> carClass = Car.class;

        // 类加载装置,进行实例化
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();

        car1.age =1;
        car2.age =2;
        car3.age =3;

        // 这三个是不一样的
        System.out.println(car1.hashCode());
        System.out.println(car2.hashCode());
        System.out.println(car3.hashCode());

        Class<? extends Car> aClass1 = car1.getClass();
        Class<? extends Car> aClass2 = car1.getClass();
        Class<? extends Car> aClass3 = car1.getClass();

        //打印的这三个是一样的
        System.out.println(aClass1);
        System.out.println(aClass2);
        System.out.println(aClass3);


        // 这三个也是一样的,说明class永远都是同一个(同一个模板),不过对象会不同
        System.out.println(aClass1.hashCode());
        System.out.println(aClass2.hashCode());
        System.out.println(aClass3.hashCode());

        ClassLoader classLoader = aClass1.getClassLoader();
        System.out.println(classLoader);// AppClassLoader
        System.out.println(classLoader.getParent()); //ExtClassLoader(额外类加载器)   \jre\lib\ext
        System.out.println(classLoader.getParent().getParent()); // null 1.不存在 2.java程序获取不到  rt.jar
    }
}
