package com.yukicris;

public class 单元测试 {
    //ctrl+sift+t
    //mokito的veerify,作用是验证是否执行,配合times,验证执行次数
    //


    //mock的意义是验证该对象的某些方法的调用情况,调用了多少次,参数是多少
    //给这个对象的行为做一个定义,用来指定返回的结果或者指定特定的动作
    //如果不对对象进行定义,则返回这个对象的默认值
    /**
     1 mock出一个random对象
    Random random = Mocktio.mock(Random.class);
     2 打印
    souf(random.nextInt); //默认值,random打印0

     2.1 when这一步被称之为打桩,这后面可有很多方法,return是其中一个
     Mocket.when(random.nextInt()).thenReturn(100);

     2.2断言,前面个是期待值,后面参数是实际值,用来校验是否通过
     Assertions.assertEquals(100,random.nextInt());

     3 确认nextInt方法的执行情况,times可以不加,用于确认执行次数的
     Mockito.verify(random,Mocktio.times(1)).nextInt();

     */


    /**
     * 注解
     * @Mock
     * private Random random;
     * 等同于上面第一句
     * Random random = Mocktio.mock(Random.class);
     *
     *
     * !!!!注意!!!!
     * 代码里需要增加MockitoAnnotations.openMocks(this) 让注解生效
     * 这句话一般写setup里
     *
     * 这个会在测试方法调用前就执行
     * @BeforeEach
     * void setUp(){
     *     souf("--测试前准备--")
     * }
     *
     * @BeforeAfter
     * void after(){
     *     souf("测试执行之后")
     * }
     */


    /**
     * Spy
     * 1被spy的对象会走真实的方法,而mock对象会模拟一个方法
     * 2spy的对象时实例,mock的对象是class
     *
     * @Spy
     * private Random random;//这里random为自定义的一个加法
     *
     * void add () {
     *     Assertions.assertEquals(3,random.add(1,2))
     * }
     * //直接走的真实的方法,所以测试成功
     *
     * 如果前面还加了mock打桩,那么它会走打了桩的方法
     *
     *
     */

}
