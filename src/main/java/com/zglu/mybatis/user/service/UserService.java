package com.zglu.mybatis.user.service;

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
        return userDao.insert(user);
    }

    public User get(long id) {
        return userDao.selectById(id);
    }

    public List<User> list(String q, String order, Integer offset, Integer limit) {
        return userDao.select(q, order, offset, limit);
    }

    public User put(User user) {
        return userDao.updateAll(user);
    }

    public User set(User user) {
        return userDao.update(user);
    }

    public User disable(long id) {
        return userDao.disable(id);
    }

    public int remove(long id) {
        return userDao.delete(id);
    }

}
