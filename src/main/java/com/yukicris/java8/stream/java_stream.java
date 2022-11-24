package com.yukicris.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


//这部分是中间操作符
public class java_stream {
    //优点: 函数式编程写出的代码简洁意图明确,使用stream接口让你从此告别for
    //多核友好: Java函数式编程使得编写并行程序简单

    // 第一步,把集合转换为流
    // 第二步,操作stream流
    // stream在管道中经过中间操作(intermediate operation)的处理,最后由最终操作(terminal operation)得到签名处理的结果

    // 操作符 :中间操作符  终止操作符

    public static void filter(){
        List<String> strings = Arrays.asList("avc", "", "bc", "de", "ffsd");
        //strings.parallelStream();//并行流
        //判断包含c的流.不写后面.collect(Collectors.toList())那它就是个单纯的流
        List<String> filter = strings.stream().filter(str -> str.contains("c")).collect(Collectors.toList());
        System.out.println("filter"+filter);
    }


    public static void distinct(){
        List<String> strings = Arrays.asList("avc", "avc", "bc", "de", "ffsd");
        List<String> distinct = strings.stream().distinct().collect(Collectors.toList());
        System.out.println("distinct"+distinct);
        //对象去重
        ArrayList<User> user = new ArrayList<>();
        user.add(new User(1,"1"));
        user.add(new User(1,"1"));
        user.add(new User(2,"2"));
        user.add(new User(3,"3"));
        List<User> distinctUser = user.stream().distinct().collect(Collectors.toList());
        System.out.println("distinct_对象"+distinctUser);
    }


    public static void limit(){
        List<String> strings = Arrays.asList("avc", "avc", "bc", "de", "ffsd");
        List<String> limit = strings.stream().limit(3).collect(Collectors.toList());
        System.out.println("分页limit"+limit);

    }

    public static void skip(){
        List<String> strings = Arrays.asList("avc", "avc", "bc", "de", "ffsd");
        List<String> skip = strings.stream().skip(3).collect(Collectors.toList());
        System.out.println("skip"+skip);

    }


    public static void map(){
        //对流中所有元素做统一处理
        List<String> strings = Arrays.asList("avc", "avc", "bc", "de", "ffsd");
        //统一拼接yukiki
        List<String> yukiki = strings.stream().map(str -> str.concat("yukiki")).collect(Collectors.toList());
        System.out.println("map统一处理"+yukiki);

    }

    //流的扁平化处理
    public static void flatMap(){
        List<String> strings = Arrays.asList("avc", "avc", "bc", "de", "ffsd");
        //flatMap需要传进去一个流
        List<Character> collect = strings.stream().flatMap(str -> getCharacterByString(str)).collect(Collectors.toList());
        // flatmap先和map一样,挨个解析成流元素 [a,v,c],[a,v,c],[b,c]...
        //然后它比map多一步,合并成一个元素 [a,v,c,a,v,c,b,c]
        System.out.println("flatmap"+collect);
    }

    //公共方法: 字符串转换成字符流
    public static Stream<Character> getCharacterByString(String str){
        List<Character> characterList = new ArrayList<>();
        for(Character character:str.toCharArray()){
            characterList.add(character);
        }
        return  characterList.stream();
    }
    
    
    public static void map2flatmap(){
        // 对比flat和map
        List<String> strings1 = Arrays.asList("avc", "avc", "bc", "de", "ffsd");
        Stream<Object> flatmap = strings1.stream().flatMap(str -> getCharacterByString(str));
        flatmap.forEach(s-> System.out.print(s));


        List<String> strings2 = Arrays.asList("avc", "avc", "bc", "de", "ffsd");
        //这是个流中流
        Stream<Stream<Character>> map = strings2.stream().map(str -> getCharacterByString(str));

        //层级深建议用flatmap,但是map可以保留原有结构
        map.forEach(s-> s.forEach(s1-> System.out.println(s1)));


    }


    public static void sorted(){
        List<String> strings1 = Arrays.asList("avc", "avc", "bc", "de", "ffsd");
        //可以传比较器
        List<String> sort = strings1.stream().sorted().collect(Collectors.toList());
        System.out.println("sort"+sort);
    }


    public static void main(String[] args) {
        //过滤集合中不符合条件的元素
        filter();

        //去重,记得这里对象是无法去重的,如果使用了lombook做注解,会去重,因为它重写了对象的equals和hashcode方法
        //本质是根据流所生产的元素的hashCode和equals进行判断
        distinct();

        //分页,取要获取的前几个值
        limit();

        //skip 跳过前几个值
        skip();

        //统一处理
        map();

        //流的扁平化处理
        flatMap();

        //map和flatmap对比,map可以保留原有结构,flatmap可以少一个层级
        map2flatmap();

        //排序
        sorted();
/* filter[avc, bc]
distinct[avc, bc, de, ffsd]
distinct_对象[com.yukicris.java8.stream.User@7aec35a, com.yukicris.java8.stream.User@67424e82, com.yukicris.java8.stream.User@42110406, com.yukicris.java8.stream.User@531d72ca]
分页limit[avc, avc, bc]
skip[de, ffsd]
map统一处理[avcyukiki, avcyukiki, bcyukiki, deyukiki, ffsdyukiki]
flatmap[a, v, c, a, v, c, b, c, d, e, f, f, s, d]
avcavcbcdeffsda
v
c
a
v
c
b
c
d
e
f
f
s
d
sort[avc, avc, bc, de, ffsd]*/


    }
}
