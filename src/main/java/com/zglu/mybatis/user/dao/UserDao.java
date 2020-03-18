package com.zglu.mybatis.user.dao;

import com.zglu.mybatis.ReplaceUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author zglu
 */
@Component
@AllArgsConstructor
public class UserDao {
    private final UserMapper userMapper;

    public User save(User user) {
        user.setCreatedDate(LocalDateTime.now());
        user.setLastModifiedDate(LocalDateTime.now());
        user.setEnable(true);
        userMapper.save(user);
        return user;
    }

    public User findById(long id) {
        return userMapper.findById(id);
    }

    public List<User> findAll(String q, String order, Integer offset, Integer limit) {
        String searchSql = "";
        if (StringUtils.hasText(q)) {
            searchSql += "WHERE " + ReplaceUtils.getColumnName(q);
        }
        if (StringUtils.hasText(order)) {
            searchSql += " ORDER BY " + ReplaceUtils.getColumnName(order);
        }
        if (offset != null && limit != null) {
            searchSql += " LIMIT " + limit + " OFFSET " + offset;
        }
        return userMapper.findAll(searchSql);
    }

    public long count(String q) {
        String searchSql = "";
        if (StringUtils.hasText(q)) {
            searchSql += "WHERE " + ReplaceUtils.getColumnName(q);
        }
        return userMapper.count(searchSql);
    }

    public User put(User user) {
        Assert.notNull(user.getId(), "id must not be null!");
        Assert.isTrue(user.getId() != 0L, "id must not be zero!");
        if (userMapper.updateAll(user) <= 0) {
            userMapper.save(user);
        }
        return user;
    }

    public User update(User user) {
        user.setLastModifiedDate(LocalDateTime.now());
        userMapper.update(user);
        return user;
    }

    public int deleteById(long id) {
        return userMapper.deleteById(id);
    }

}
