package com.zglu.mybatis.user.dao;

import com.zglu.mybatis.Page;
import com.zglu.mybatis.ReplaceUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
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

    public User insert(User user) {
        user.setCreatedDate(LocalDateTime.now());
        user.setEnable(true);
        userMapper.insert(user);
        return user;
    }

    public User selectById(long id) {
        return userMapper.selectById(id);
    }

    public List<User> select(String q, String order, Integer offset, Integer limit) {
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
        return userMapper.select(searchSql);
    }

    public Page<User> selectForPage(String q, String order, Integer page, Integer size) {
        long total = userMapper.count();
        int offset = page * size;
        this.select(q, order, offset, size);
        Page<User> page = new Page();
        return page;
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
