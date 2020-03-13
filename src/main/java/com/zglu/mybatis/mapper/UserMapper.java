package com.zglu.mybatis.mapper;

import com.zglu.mybatis.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

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
    @Insert("insert into user(user_name) values(#{userName})")
    @SelectKey(statement = "select last_insert_id()", keyProperty = "id", before = false, resultType = long.class)
    long insert(User user);

    /**
     * R
     *
     * @param id 记录id
     * @return 记录
     */
    @Select("select * from user where id = #{id}")
    User select(@Param("id") long id);

    /**
     * U
     *
     * @param user 记录
     * @return 影响行数
     */
    @Update("update user set " +
            "user_name=#{userName} " +
            "where id=#{id}")
    long update(User user);

    /**
     * D
     *
     * @param id 记录id
     * @return 影响行数
     */
    @Delete("delete from user where id=#{id}")
    long delete(@Param("id") long id);
}
