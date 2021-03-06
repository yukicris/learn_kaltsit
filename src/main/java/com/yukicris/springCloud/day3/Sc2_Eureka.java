package com.yukicris.springCloud.day3;

public class Sc2_Eureka {
    //Eureka

    /**
     *
     * Euraka遵循的AP原则
     *
     * 代码见 7001-7003 和8001之间配合使用,7001-7003为搭建的注册中心集群
     *
     *
     *  是一个基于REST的服务,用于定位服务,以实现云端中间层服务发现和故障转移
     *  ,服务注册与发现对于微服务来说十分重要,有了服务发现与注册,只需要使用服务的标识符,就可以访问到服务,不需要修改服务调用的配置文件,类似Zookeeper
     *
     *
     *
     *  基本架构:
     *    SpringCloud封装了NetFlix公司开发的Eureka模块来实现服务注册与发现
     *
     *    Eureka采用cs架构,EurekaServer作为服务注册功能的服务器,他是服务注册中心
     *
     *    系统中其他的微服务,使用Eureka的客户端来链接到EurekaServer保持心跳连接,这样系统的维护人员可以通过Eureka
     *    Srtver来监测系统中的各个微服务是否正常运行,Spring cloud中的一些其他模块(比如Zuul)可以通过EurekaServer来发现系统中其他微服务
     *
     *    和Dubbo架构对比
     *
     *
     *  三大角色:
     *     Eureka Server : 提供服务注册与发现. 类似Zookeeper
     *     Service Provider: 将自身服务注册到Eureka中,从而使消费方可以找到
     *     Server Consumer: 服务消费方从Eureka中获取注册服务列表,从而找到消费服务
     *
     *
     * (配置这鬼玩意如果找不到bean很可能是版本的问题,要检查spring_boot和springcloud的版本对应关系)
     *
     *    ***  注册中心配置 :1 配置依赖  2 写配置文件 3 配置启动类添加Enable_eureka支持,开启这个功能
     *          (经过测试(先启动7001,再启动8001),可以把8001的服务自动注册到7001 EurekaServer中),访问7001地址 http://localhost:7001/ ,
     *          Application对应配置文件的spring:application:name
     *
     *  已注册的服务点进去,页面报错的话,说明没有添加监控信息包 actuator,可以在配置文件的info中添加配置,写入服务相关信息描述
     *
     *  自我保护机制: (爆红) 比如我把8001强制关了,或者服务崩了或者断电,过一会就会爆红(默认90s),他并不会立即清理,而是依旧对该服务的信息进行保存,
     *  保护注册表中的信息,不再注销任何服务实例,当网络环境恢复后,服务器又恢复了,它会退出保护机制
     *  也就是 宁可同时保留所有微服务(健康与不健康的),也不盲目注销任何健康的微服务
     *  可关闭: eureka.server.enable-self-preservation = false禁用自我保护[一般不推荐关闭]
     *
     *
     *
     *  团队协作:
     *      EnableDiscoryClient 进行服务发现,来找到已注册的服务相关的信息
     *
     *     注册中心集群配置 :
     *
     *    # 单机 defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka/
     *    # 集群(多个关联,比如7001关联7002和7003) http://7002的ip:7002/eureka/,http://7002的ip:7002/eureka/   多个用逗号拼接,然后去02和03也互相配置
     *
     *      然后服务端,同理
     *      也是配置文件中在defaultZone中把01,02,03都加上去,这样一次就可以注册上多个注册中心
     *
     *
     *   CAP原则 C(Consistency) 强一致性
     *          A(Availabilty) 可用性
     *          P(Partition tolerance) 分区容错性
     *          三进二原则 : CA或AP或CP满足其中2个,一般三个要素只能实现2个,不可能同时兼顾
     *
     *
     *          (引一段话)
     *          一个分布式系统里面，节点组成的网络本来应该是连通的。然而可能因为一些故障，使得有些节点之间不连通了，整个网络就分成了几块区域。数据就散布在了这些不连通的区域中。这就叫分区。
     *          当你一个数据项只在一个节点中保存，那么分区出现后，和这个节点不连通的部分就访问不到这个数据了。这时分区就是无法容忍的。
     *          提高分区容忍性的办法就是一个数据项复制到多个节点上，那么出现分区之后，这一数据项就可能分布到各个区里。容忍性就提高了。
     *          然而，要把数据复制到多个节点，就会带来一致性的问题，就是多个节点上面的数据可能是不一致的。要保证一致，每次写操作就都要等待全部节点写成功，而这等待又会带来可用性的问题。
     *          总的来说就是，数据存在的节点越多，分区容忍性越高，但要复制更新的数据就越多，一致性就越难保证。为了保证一致性，更新所有节点数据所需要的时间就越长，可用性就会降低。
     *
     *          一般分区容错性在分布式系统中必须要保证,所谓p 分区容错，即当某一节点宕了，节点之间不再联通，若宕机节点的数据没有丢失，复制到了其他节点，
     *          即满足了分区容错性，
     *          所以只能在a和c之间权衡
     *
     *          zookeeper 保证CP     容忍注册中心返回几分钟以前的注册信息,不接受服务直接down掉不可用,即一致性高于可用性,当主节点与其他节点失去联系,会再选取一个主节点,但是会花费几分钟时间,导致整个zk集群服务不可用,注册服务瘫痪
     *          Eureka    保证AP     保证可用性,各个节点平等,注册时发现某个链接失败自动切换其他节点,有一台Eureka在,就能保证可用性,不过信息可能不是最新的,还有自我保护机制
     *
     *          自我保护机制 在15分钟内85%的节点没有正常心跳,Eureka会认为客户端与注册中心出了网络故障,会出现以下2种情况
     *          1 Eureka不再从注册列表移除长时间没有收到心跳应该过期的服务
     *          2 Eureka任然能够接受新的服务注册和查询请求,但是不会同步到其他节点上(保证当前节点依然可用),
     *          3 网络稳定时 ,当前实例新的注册信息会被同步到其他节点上
     *
     *          因此,Eureka可以很好的应对因网络故障导致部分节点失去联系的情况,不会像zookper那样使整个注册服务瘫痪
     *
     *
     *
     *
     *
     *
     *
     */
}
