package com.zglu.mybatis.db0.user.service;

import com.zglu.mybatis.common.Page;
import com.zglu.mybatis.db0.user.dao.User;
import com.zglu.mybatis.db0.user.dao.UserDao;
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
        return userDao.add(user);
    }

    public User set(User user) {
        return userDao.set(user);
    }

    public int remove(long id) {
        return userDao.remove(id);
    }

    public List<User> get() {
        return userDao.get();
    }

    public User get(long id) {
        return userDao.get(id);
    }

    public Page<User> page(Integer number, Integer size) {
        return userDao.page(number, size);
    }

}
