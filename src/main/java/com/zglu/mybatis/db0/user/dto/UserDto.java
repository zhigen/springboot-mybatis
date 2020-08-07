package com.zglu.mybatis.db0.user.dto;

import com.zglu.mybatis.db0.user.dao.User;
import lombok.Data;

/**
 * @author zglu
 */
@Data
public class UserDto {
    private Long id;
    private String name;

    public User toEntity(){
        User user = new User();
        user.setId(id);
        user.setName(name);
        return user;
    }

}
