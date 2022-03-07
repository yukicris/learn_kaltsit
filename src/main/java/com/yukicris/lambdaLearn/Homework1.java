package com.yukicris.lambdaLearn;

import com.yukicris.lambdaLearn.po.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Homework1 {
    //调用Collection.sort() 方法 ,通过定制排序比较两个Employee,
    // 先按年龄比,年龄相同姓名比) 使用lambda作为参数传递
    List<Employee> emps = Arrays.asList(
            new Employee(101,"阿三",8),
            new Employee(102,"李四",59),
            new Employee(103,"王五",28),
            new Employee(104,"赵六",8),
            new Employee(105,"田七",38)
    );

    @Test
    public void test1() {


        Collections.sort(emps,(e1,e2) -> {
            if (e1.getAge() == e2.getAge()){
                return e1.getName().compareTo(e2.getName());
            }else {
                //倒序加个减号
                return -Integer.compare(e1.getAge(),e2.getAge());
            }
        });


        for (Employee emp: emps) {
            System.out.println(emp);
        }
    }


}
