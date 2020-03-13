package com.zglu.mybatis.mapper;

import com.zglu.mybatis.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * @author zglu
 */
@Component
public interface UserMapper {

    /**
     * 查询记录
     *
     * @param id 记录id
     * @return 记录
     */
    @Select("select * from user where id = #{id}")
    User findById(@Param("id") int id);
}
