package com.zglu.mybatis.user.service;

import com.zglu.mybatis.user.dao.User;
import com.zglu.mybatis.user.dao.UserDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author zglu
 */
@Service
@AllArgsConstructor
public class UserService {
    private final UserDao userDao;

    public User add(User user) {
        userDao.insert(user);
        return user;
    }

    public User get(long id) {
        return userDao.select(id);
    }

    public User put(User user) {
        userDao.updateAll(user);
        return user;
    }

    public User set(User user) {
        userDao.update(user);
        return user;
    }

    public User disable(long id) {
        return userDao.disable(id);
    }

    public int remove(long id) {
        return userDao.delete(id);
    }

}
