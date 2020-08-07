package com.zglu.mybatis.db1.goods.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zglu
 */
@Component
public interface GoodsMapper {

    /**
     * C
     *
     * @param t 记录
     * @return 影响行数
     */
    @Insert("INSERT INTO goods(id, name, created_date, created_by, last_modified_date, last_modified_by, deleted) " +
            "VALUES(#{id}, #{name}, #{createdDate}, #{createdBy}, #{lastModifiedDate}, #{lastModifiedBy}, #{deleted})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = long.class)
    int add(Goods t);

    /**
     * U
     *
     * @param t 记录
     * @return 影响行数
     */
    @Update("UPDATE goods SET " +
            "name = CASE WHEN #{name} IS NULL THEN name ELSE #{name} END, " +
            "created_date = CASE WHEN #{createdDate} IS NULL THEN created_date ELSE #{createdDate} END, " +
            "created_by = CASE WHEN #{createdBy} IS NULL THEN created_by ELSE #{createdBy} END, " +
            "last_modified_date = CASE WHEN #{lastModifiedDate} IS NULL THEN last_modified_date ELSE #{lastModifiedDate} END, " +
            "last_modified_by = CASE WHEN #{lastModifiedBy} IS NULL THEN last_modified_by ELSE #{lastModifiedBy} END, " +
            "deleted = CASE WHEN #{deleted} IS NULL THEN deleted ELSE #{deleted} END " +
            "WHERE id = #{id}")
    int set(Goods t);

    /**
     * D
     *
     * @param id 记录id
     * @return 影响行数
     */
    @Delete("UPDATE goods SET deleted = 1 WHERE id = #{id}")
    int remove(@Param("id") long id);

    /**
     * R
     *
     * @return 记录集
     */
    @Select("SELECT * FROM goods WHERE deleted = 0")
    List<Goods> get();

    /**
     * R
     *
     * @param id 记录id
     * @return 记录
     */
    @Select("SELECT * FROM goods WHERE deleted = 0 AND id = #{id}")
    Goods getById(@Param("id") long id);

    /**
     * count
     *
     * @param sql 补充语句
     * @return 记录总数
     */
    @Select("SELECT COUNT(id) FROM goods ${sql}")
    long count(@Param("sql") String sql);

    /**
     * count
     *
     * @param sql 补充语句
     * @return 记录总数
     */
    @Select("SELECT * FROM goods ${sql}")
    List<Goods> getBySql(@Param("sql") String sql);

}
