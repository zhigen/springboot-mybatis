package com.zglu.mybatis.user.service;

import com.zglu.mybatis.Page;
import com.zglu.mybatis.user.dao.User;
import com.zglu.mybatis.user.dao.UserDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zglu
 */
@Service
@AllArgsConstructor
public class UserService {
    private final UserDao userDao;

    public User add(User user) {
        return userDao.save(user);
    }

    public User get(long id) {
        return userDao.findById(id);
    }

    public List<User> list(String q, String order, Integer offset, Integer limit) {
        return userDao.findAll(q, order, offset, limit);
    }

    public Page<User> page(String q, String order, Integer number, Integer size) {
        long totalElements = userDao.count(q);
        Page<User> page = new Page<>(totalElements, number, size);
        List<User> content = userDao.findAll(q, order, page.getOffset(), size);
        page.setContent(content);
        return page;
    }

    public User put(User user) {
        if (userDao.updateAll(user) <= 0) {
            userDao.save(user);
        }
        return user;
    }

    public User set(User user) {
        return userDao.update(user);
    }

    public User disable(long id) {
        User user = new User();
        user.setId(id);
        user.setEnable(false);
        return userDao.update(user);
    }

    public int remove(long id) {
        return userDao.deleteById(id);
    }

}