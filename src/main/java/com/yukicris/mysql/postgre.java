package com.yukicris.mysql;

public class postgre {
    /**
     *
     *
     * PostgreSQL 物化视图快速入门
     *
     * 梦想画家
     *
     * 于 2021-08-07 16:28:31 发布
     *
     * 792
     *  收藏 6
     * 分类专栏： PostgreSQL
     * 版权
     *
     * PostgreSQL
     * 专栏收录该内容
     * 77 篇文章12 订阅
     * 订阅专栏
     * 本文介绍PostgreSQL 物化视图 (materialized views) ，物化视图用于存储物理的查询结果并可周期性更新。
     *
     * 视图是底层物理表的虚拟表，其本身不保存数据。为了区别我们称为简单视图，postgres 9.5 版本之后默认也可以通过视图更新底层表数据。
     *
     * 物化视图扩展简单视图概念，允许存储物理数据。物化视图缓存复杂查询结果并可以周期性刷新结果。主要用于需要快速访问数据的场景，如数据仓库和商务智能应用中。
     *
     * 物化视图介绍
     * 创建物化视图
     * 使用 CREATE MATERIALIZED VIEW 语句，语法如下：
     *
     * CREATE MATERIALIZED VIEW view_name
     * AS
     * query
     * WITH [NO] DATA;
     * 1
     * 2
     * 3
     * 4
     * 首先在 CREATE MATERIALIZED VIEW子句后面指定视图名称
     * 其次在AS 关键字后面 增加获取数据的查询
     * 最后，如果需要创建时加载数据，使用 WITH DATA 选项；否则使用 WITH NO DATA，此时视图标记为不可读，即在加载数据之前不能查询物化视图。
     * 刷新数据
     * 使用 REFRESH MATERIALIZED VIEW 语句载入数据：
     *
     * REFRESH MATERIALIZED VIEW view_name;
     * 1
     * 当刷新物化视图时，PostgreSQL 锁定整个表，因此你不能查询表。可以通过使用 CONCURRENTLY 关键字避免锁表：
     *
     * REFRESH MATERIALIZED VIEW CONCURRENTLY view_name;
     * 1
     * 使用 CONCURRENTLY 关键字选项，PostgreSQL 创建物化视图的临时更新版本，通过对比两个版本执行对差异部分执行 插入和更新操作，更新物化视图同时可以执行查询操作。
     *
     * 使用CONCURRENTLY 选项的条件需要物化视图有唯一索引。
     *
     * 注意CONCURRENTLY 选项仅从 PostgreSQL 9.4 版本才引入。
     *
     * 删除物化视图
     * 删除物化视图语法比较直接，语法：
     *
     * DROP MATERIALIZED VIEW view_name;
     * 1
     * 物化视图示例
     * 下面创建物化视图 rental_by_category ：
     *
     * CREATE MATERIALIZED VIEW rental_by_category
     * AS
     *  SELECT c.name AS category,
     *     sum(p.amount) AS total_sales
     *    FROM (((((payment p
     *      JOIN rental r ON ((p.rental_id = r.rental_id)))
     *      JOIN inventory i ON ((r.inventory_id = i.inventory_id)))
     *      JOIN film f ON ((i.film_id = f.film_id)))
     *      JOIN film_category fc ON ((f.film_id = fc.film_id)))
     *      JOIN category c ON ((fc.category_id = c.category_id)))
     *   GROUP BY c.name
     *   ORDER BY sum(p.amount) DESC
     * WITH NO DATA;
     * 这里使用 WITH NO DATA 选项，我们不能查询视图。直接查询会产生错误：
     *
     * select * from rental_by_category
     * 1
     * SQL 错误 [55000]: 错误: 物化视图 "rental_by_category"未被初始化
     * 建议：使用命令 REFRESH MATERIALIZED VIEW.
     *
     * 错误信息已经提示，让我们执行刷新语句。
     *
     * REFRESH MATERIALIZED VIEW rental_by_category;
     * 1
     * 再次查询有了结果：
     *
     * category	total_sales
     * Sports	4892.19
     * Sci-Fi	4336.01
     * Animation	4245.31
     * Drama	4118.46
     * Comedy	4002.48
     * New	3966.38
     * Action	3951.84
     * Foreign	3934.47
     * Games	3922.18
     * Family	3830.15
     * Documentary	3749.65
     * Horror	3401.27
     * Classics	3353.38
     * Children	3309.39
     * Travel	3227.36
     * Music	3071.52
     * 我们也可以使用 REFRESH MATERIALIZED VIEW 语句刷新视图，但如果使用 CONCURRENTLY 选项，首先需要创建唯一索引。
     *
     * CREATE UNIQUE INDEX rental_category ON rental_by_category (category);
     * 1
     * 现在可以并行进行刷新：
     *
     * REFRESH MATERIALIZED VIEW CONCURRENTLY rental_by_category;
     * 1
     * 总结
     * 本文学习了PostgreSQL的物化视图，如何创建、删除及加载数据，并同时示例进行实战演示。
     * ————————————————
     * 版权声明：本文为CSDN博主「梦想画家」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
     * 原文链接：https://blog.csdn.net/neweastsun/article/details/119488601
     */
}
