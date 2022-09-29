package com.yukicris.mybatis.day3;

public class note4 {
    //动态sql,根据不同条件生产不同的sql语句
/*
    if
    choose (when, otherwise)
    trim (where, set)
    foreach
    */


    /*
     choose
     <select id="queryBlogIF" parameterType="map" resultType="blog">
    select *from mybatis.blog where 1=1

        <if test="title != null">
    and title = #{title}
        </if>

        <if test="author != null">
    and author = #{author}
        </if>
    </select>
    */

   /* <select id="queryBlogChoose" parameterType="map" resultType="blog">
    select *from mybatis.blog
            <where>
        <choose>
            <when test="title !=null">
    title = #{title}
            </when>
            <when test="author !=null">
    and author = #{author}
            </when>
            <otherwise>
    and views = #{views}
            </otherwise>
        </choose>
    </where>
    </select>*/

    /*
    where 元素只会在子元素返回任何内容的情况下才插入 “WHERE” 子句。
    而且，若子句的开头为 “AND” 或 “OR”，where 元素也会将它们去除

    * <select id="queryBlogIF" parameterType="map" resultType="blog">
        select *from mybatis.blog
        <where>
        <if test="title != null">
             title = #{title}
        </if>
        <if test="author != null">
            and author = #{author}
        </if>
        </where>
       </select>
    * */


    /*
    set元素会动态地在行首插入 SET 关键字，并会删掉额外的逗号

   <update id="updateBlog" parameterType="map">
    update mybatis.blog
    <set>
        <if test="title != null">
            title = #{title},
        </if>
        <if test="author != null">
            author = #{author}
        </if>
    </set>
    where id = #{id}
     </update>/


     */

/*
    <trim prefix="WHERE" prefixOverrides="AND |OR ">
            ...
   </trim>
prefixOverrides 属性会忽略通过管道符分隔的文本序列（注意此例中的空格是必要的）。上述例子会移除所有 prefixOverrides 属性中指定的内容，并且插入 prefix 属性中指定的内容

这个例子中，set 元素会动态地在行首插入 SET 关键字，并会删掉额外的逗号（这些逗号是在使用条件语句给列赋值时引入的）。

或者，你可以通过使用trim元素来达到同样的效果：

   等同于
   <trim prefix="SET" suffixOverrides=",">
  ...
   </trim>

   */

/**
 * sql片段和include标签
 *
 */
/*
<sql id="if-title-author">
    <if test="title != null">
    title = #{title}
    </if>

    <if test="author != null">
    and author = #{author}
    </if>
</sql>
            ————————————————
    <select id="queryBlogIF" parameterType="map" resultType="blog">
    select *from mybatis.blog
            <where>
    <include refid="if-title-author"></include>
        </where>
     </select>*/


    /**
     * foreach
     */
  /*
    <select id="selectPostIn" resultType="domain.blog.Post">
    SELECT *
    FROM POST P
            <where>
    <foreach item="item" index="index" collection="list"
    open="ID in (" separator="," close=")" nullable="true">
            #{item}
    </foreach>
    </where>
    </select>*/

}
