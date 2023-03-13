package com.yukicris.mybatis.day4;

public class day2 {
    //缓存
    /**
     * 再次查询相同数据的时候,就直接走缓存,而不用走数据库
     *
     * 缓存:放在内存中的临时数据
     *
     * mybatis包含一个非常强大的查询缓存特性,可以非常方便的定制和配置缓存,缓存可以极大提升查询效率
     *
     * mybatis默认定义了2级缓存: 一级和二级
     * 默认情况下只有一级缓存开启(SqlSession级别的缓存,也称之为本地缓存)
     * 二级缓存需要手动开启和配置,基于namespace级别的缓存
     * 为了提高扩展性,Mybatis定义了缓存接口Cache,可以通过实现Cache接口来自定义二级缓存
     */

    /**
     * 一级缓存,在一次性查同一个sqlsession会话,sql只会走一次
     *
     *   @Test
     *     public void test(){
     *         SqlSession sqlSession = MybatisUtils.getSqlSession();
     *         UserMapper mapper = sqlSession.getMapper(UserMapper.class);
     *         //此处执行2遍相同的语句,日志仅仅输出一遍,如果中间执行一条增删改查,就会失效,返回2遍
     *         List<User> user = mapper.getUsers();
     *         List<User> user2 = mapper.getUsers();
     *
     *         //sqlSession.clearcache() 这条语句可以手动清理缓存
     *         for (User user1: user) {
     *             System.out.println(user);
     *         }
     *         sqlSession.close();
     *     }
     *
     *
     * 一级缓存失效: 1所有的select语句结果都会被缓存
     *             2所有的增删改语句都会刷新缓存
     *             3 会使用最近最少使用算法 LRU(least recently Used) 算法来清除掉不必要的缓存
     *             4 不会定时刷新(没有刷新间隔)
     *             5 保存列表对象的1024个引用
     *             6被视为读/写缓存,意味着获取到的对象不是共享的,可以安全的被调用者修改而不干扰其他调用者或者线程所做的潜在修改
     *
     *
     * 一级缓存默认是开启的,只在一次SqlSession中有效,也就是拿到链接到关闭链接这个区间段
     * 一级缓存就是一个Map
     */


    /**
     * 二级缓存
     *
     * 二级缓存也叫全局缓存，一级缓存作用域太低了，所以诞生了二级缓存
     * 基于namespace级别的缓存，一个名称空间，对应一个二级缓存：
     * 工作机制
     * 一个会话查询一条数据，这个数据就会被放在当前会话的一级缓存中：
     * 如果当前会话关闭了，这个会话对应的一级缓存就没了；但是我们想要的是，会话关闭了，一级缓存中的数据被保存到二级缓存中；
     * 新的会话查询信息，就可以从二级缓存中获取内容：
     * 不同的mapper查出的数据会放在自己对应的缓存(map)中；
     * 同名的mapper享有同一个二级缓存
     *
     *
     * <chahe></chahe>
     * 也就是在我们的UserMapper.xml最上面加个这个就行了
     *
     * 具体步骤:
     * 1 显示的开启全局缓存(默认是已开启的): <settings>   <setting name="cacheEnable" value="true"/></settings>
     * 2 在需要使用二级缓存的Mapper中开启
     *   <cache  eviction="FIFO"
     *             flushInterval="60000"
     *             size="512"
     *             readOnly="true"/>
     *
     * 只要开启了二级缓存，在同一个Mapper下就有效
     * 所有的数据都会先放在一级缓存中
     * 只有当会话sqlsession提交，或者关闭的时候才会提交到二级缓存中(类似一个转存的概念)
     * 如果工厂又创建了一个新的sqlsession会话,执行一次commit(改,增,删),会导致这个二级缓存失效,去跑数据库
     *
     * 原理: 缓存顺序：
     *
     * 先看二级缓存中有没有
     * 再看一级缓存中有没有
     * 查询数据库
     *
     * 我们需要将实体类序列化(实现Serializable接口)，(克隆缓存结果)转存需要实现序列化,否则就会报错
     * sqlsession(先开后关)关闭的时候一定要在最后关闭，不能先关闭sqlsession再关闭sqlsession2,这样会导致Cause: org.apache.ibatis.executor.ExecutorException: Executor was closed
     *
     *
     *
     * */


    /**
     * 1 第一次查询先看二级缓存中有没有,再看一级缓存中有没有
     * 2 两个都没有,再查询数据库
     */
}
