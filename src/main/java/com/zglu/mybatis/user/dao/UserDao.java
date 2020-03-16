package com.zglu.mybatis.user.dao;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author zglu
 */
@Component
@AllArgsConstructor
public class UserDao {
    private final UserMapper userMapper;

    public User insert(User user) {
        user.setCreatedDate(LocalDateTime.now());
        user.setEnable(true);
        userMapper.insert(user);
        return user;
    }

    public User select(long id) {
        return userMapper.select(id);
    }

    public User updateAll(User user) {
        userMapper.updateAll(user);
        return user;
    }

    public User update(User user) {
        user.setLastModifiedDate(LocalDateTime.now());
        userMapper.update(user);
        return user;
    }

    public User disable(long id) {
        User user = new User();
        user.setId(id);
        user.setEnable(false);
        return this.update(user);
    }

    public int delete(long id) {
        return userMapper.delete(id);
    }

}
