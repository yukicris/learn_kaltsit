package com.yukicris.FaceTest;

public class Face5 {
    // spring 生命周期

    /**
     * 1. 实例化Bean
     * 对于BeanFactory容器，当客户向容器请求一个尚未初始化的bean时，或初始化bean的时候需要注入另一个尚未初始化的依赖时，容器就会调用createBean进行实例化。
     * 对于ApplicationContext容器，当容器启动结束后，便实例化所有的bean。
     * 容器通过获取BeanDefinition对象中的信息进行实例化。并且这一步仅仅是简单的实例化，并未进行依赖注入。
     * 实例化对象被包装在BeanWrapper对象中，BeanWrapper提供了设置对象属性的接口，从而避免了使用反射机制设置属性。
     *
     * 2. 设置对象属性（依赖注入）
     * 实例化后的对象被封装在BeanWrapper对象中，并且此时对象仍然是一个原生的状态，并没有进行依赖注入。
     * 紧接着，Spring根据BeanDefinition中的信息进行依赖注入。 并且通过BeanWrapper提供的设置属性的接口完成依赖注入。
     *
     * 3. 注入Aware接口
     * 紧接着，Spring会检测该对象是否实现了xxxAware接口，并将相关的xxxAware实例注入给bean。
     *
     * 4. BeanPostProcessor
     * 当经过上述几个步骤后，bean对象已经被正确构造，但如果你想要对象被使用前再进行一些自定义的处理，就可以通过BeanPostProcessor接口实现。 该接口提供了两个函数：postProcessBeforeInitialzation( Object bean, String beanName ) 当前正在初始化的bean对象会被传递进来，我们就可以对这个bean作任何处理。 这个函数会先于InitialzationBean执行，因此称为前置处理。 所有Aware接口的注入就是在这一步完成的。postProcessAfterInitialzation( Object bean, String beanName ) 当前正在初始化的bean对象会被传递进来，我们就可以对这个bean作任何处理。 这个函数会在InitialzationBean完成后执行，因此称为后置处理。
     *
     * 5. InitializingBean与init-method
     * 当BeanPostProcessor的前置处理完成后就会进入本阶段。 InitializingBean接口只有一个函数：afterPropertiesSet()这一阶段也可以在bean正式构造完成前增加我们自定义的逻辑，但它与前置处理不同，由于该函数并不会把当前bean对象传进来，因此在这一步没办法处理对象本身，只能增加一些额外的逻辑。 若要使用它，我们需要让bean实现该接口，并把要增加的逻辑写在该函数中。然后Spring会在前置处理完成后检测当前bean是否实现了该接口，并执行afterPropertiesSet函数。当然，Spring为了降低对客户代码的侵入性，给bean的配置提供了init-method属性，该属性指定了在这一阶段需要执行的函数名。Spring便会在初始化阶段执行我们设置的函数。init-method本质上仍然使用了InitializingBean接口。
     *
     * 6. DisposableBean和destroy-method
     * 和init-method一样，通过给destroy-method指定函数，就可以在bean销毁前执行指定的逻辑。
     * @return
     */

    // spring 三级缓存
 /**   pring的三级缓存分别是
    // 从上至下 分表代表这“三级缓存”
    private final Map<String, Object> singletonObjects = new ConcurrentHashMap<>(256); //一级缓存
    private final Map<String, Object> earlySingletonObjects = new HashMap<>(16); // 二级缓存
    private final Map<String, ObjectFactory<?>> singletonFactories = new HashMap<>(16); // 三级缓存


    singletonObjects：用于存放完全初始化好的 bean，从该缓存中取出的 bean 可以直接使用
    earlySingletonObjects：提前曝光的单例对象的cache，存放原始的 bean 对象（尚未填充属性），用于解决循环依赖
    singletonFactories：单例对象工厂的cache，存放 bean 工厂对象，用于解决循环依赖

    先从一级缓存singletonObjects中去获取。（如果获取到就直接return）
    如果获取不到或者对象正在创建中（isSingletonCurrentlyInCreation()），那就再从二级缓存earlySingletonObjects中获取。（如果获取到就直接return)
    如果还是获取不到，且允许singletonFactories（allowEarlyReference=true）通过getObject()获取。
    就从三级缓存singletonFactory.getObject()获取。（
    如果获取到了就从singletonFactories中移除，并且放进earlySingletonObjects。
    其实也就是从三级缓存移动（是剪切、不是复制哦~）到了二级缓存）此处的移动保证了，之后在init时候仍然是同一个对象


  一个或多个对象之间存在直接或间接的依赖关系，这种依赖关系构成一个环形调用，有下面 3 种方式。
  A依赖自身    AB 互相依赖    多个对象互相依赖 A>B>C>A

  什么是循环依赖
  在第一层中，先去获取 A 的 Bean，发现没有就准备去创建一个，然后将 A 的代理工厂放入“三级缓存”（这个 A 其实是一个半成品，还没有对里面的属性进行注入 ），但是 A 依赖 B 的创建，就必须先去创建 B；
  在第二层中，准备创建 B，发现 B 又依赖 A，需要先去创建 A；
  在第三层中，去创建 A，因为第一层已经创建了 A 的代理工厂，直接从“三级缓存”中拿到 A 的代理工厂，获取 A 的代理对象，放入“二级缓存” ，并清除“三级缓存”；
  回到第二层，现在有了 A 的代理对象，对 A 的依赖完美解决（这里的 A 仍然是个半成品 ），B 初始化成功；
  回到第一层，现在 B 初始化成功，完成 A 对象的属性注入，然后再填充 A 的其它属性，以及 A 的其它步骤（包括 AOP），完成对 A 完整的初始化功能（这里的 A 才是完整的 Bean ）。
  将 A 放入“一级缓存”。
*/

    // 是否支持多个IOC
    //springboot是1个,mvc是1或2 ,cloud环境可以是1,2,3,4...
    // 自动装配原理

    // mybatis 二级缓存


    // 简单观察模式


    // sql 查重
    //select dept from test group by dept having count(*) >2;

    // union 和union all的区别 union all 不去重

    //null本质是什么
    public static  String textstr() {
        return null; //像null这种的返回值只能匹配到String,Double,Integer等包装类,相当于是空对象,不能返回boolean,int等基本类型
    }
}
