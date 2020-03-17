package com.zglu.mybatis.user.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zglu
 */
@Component
public interface UserMapper {

    /**
     * C
     *
     * @param user 记录
     * @return 影响行数
     */
    @Insert("INSERT INTO user(id, name, create_date, create_by, enable) " +
            "VALUES(#{id}, #{name}, #{createdDate}, #{createdBy}, #{enable})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = long.class)
    int save(User user);

    /**
     * R
     *
     * @param id 记录id
     * @return 记录
     */
    @Select("SELECT * FROM user WHERE id = #{id}")
    User findById(@Param("id") long id);

    /**
     * R
     *
     * @param searchSql 搜索语句
     * @return 记录集
     */
    @Select("SELECT * FROM user ${searchSql}")
    List<User> findAll(@Param("searchSql") String searchSql);

    /**
     * count
     *
     * @param searchSql 搜索语句
     * @return 记录总数
     */
    @Select("SELECT count(id) FROM user ${searchSql}")
    long count(@Param("searchSql") String searchSql);

    /**
     * U
     *
     * @param user 记录
     * @return 影响行数
     */
    @Update("UPDATE user SET " +
            "name = #{name}, " +
            "create_date = #{createdDate}, " +
            "create_by = #{createdBy}, " +
            "last_modified_date = #{lastModifiedDate}, " +
            "last_modified_by = #{lastModifiedBy}, " +
            "enable = #{enable} " +
            "WHERE id = #{id}")
    int updateAll(User user);

    /**
     * U
     *
     * @param user 记录
     * @return 影响行数
     */
    @Update("UPDATE user SET " +
            "name = CASE WHEN #{name} IS NULL THEN name ELSE #{name} END, " +
            "create_date = CASE WHEN #{createdDate} IS NULL THEN create_date ELSE #{createdDate} END, " +
            "create_by = CASE WHEN #{createdBy} IS NULL THEN create_by ELSE #{createdBy} END, " +
            "last_modified_date = CASE WHEN #{lastModifiedDate} IS NULL THEN last_modified_date ELSE #{lastModifiedDate} END, " +
            "last_modified_by = CASE WHEN #{lastModifiedBy} IS NULL THEN last_modified_by ELSE #{lastModifiedBy} END, " +
            "enable = CASE WHEN #{enable} IS NULL THEN enable ELSE #{enable} END " +
            "WHERE id=#{id}")
    int update(User user);

    /**
     * D
     *
     * @param id 记录id
     * @return 影响行数
     */
    @Delete("DELETE FROM user WHERE id=#{id}")
    int deleteById(@Param("id") long id);

}
