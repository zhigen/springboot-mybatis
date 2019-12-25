package com.zglu.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.Map;

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
    Map findById(@Param("id") int id);
}
