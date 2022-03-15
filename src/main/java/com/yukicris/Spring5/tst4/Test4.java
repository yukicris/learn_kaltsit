package com.yukicris.Spring5.tst4;

import com.yukicris.Spring5.tst4.pojo.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test4 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans4.xml");

        Person person = context.getBean("person",Person.class);
        person.getCat().shut();
        person.getDog().shut();
    }
}
