package com.zglu.mybatis;

import com.zglu.mybatis.entity.User;
import com.zglu.mybatis.mapper.UserMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @author zglu
 */
@Log4j2
@ExtendWith(SpringExtension.class)
@SpringBootTest
@MapperScan(value = "com.zglu.mybatis.mapper")
class ApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        Assertions.assertNotNull(userMapper, "userMapper not be null");
        User user = new User(null, "a");
        long row = userMapper.insert(user);
        log.info("增" + row + "行：" + user);
        user = userMapper.select(user.getId());
        log.info("查" + "：" + user);
        user.setUserName("b");
        row = userMapper.update(user);
        log.info("改" + row + "行：" + user);
        row = userMapper.delete(user.getId());
        log.info("删" + row + "行：" + user.getId());
        user = userMapper.select(user.getId());
        log.info("查" + "：" + user);
    }

}
