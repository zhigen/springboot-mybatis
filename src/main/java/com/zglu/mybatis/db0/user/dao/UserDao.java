package com.zglu.mybatis.db0.user.dao;

import com.zglu.mybatis.common.Page;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zglu
 */
@Component
@AllArgsConstructor
public class UserDao {
    private final UserMapper userMapper;

    public User add(User user) {
        userMapper.add(user);
        return user;
    }

    public User set(User user) {
        userMapper.set(user);
        return user;
    }

    public int remove(long id) {
        return userMapper.remove(id);
    }

    public List<User> get() {
        return userMapper.get();
    }

    public User get(long id) {
        return userMapper.getById(id);
    }

    public Page<User> page(Integer number, Integer size) {
        String sql = "";
        long totalElements = userMapper.count(sql);
        Page<User> page = new Page<>(totalElements, number, size);
        sql += " LIMIT " + size + " OFFSET " + page.getOffset();
        List<User> content = userMapper.getBySql(sql);
        page.setContent(content);
        return page;
    }

}
