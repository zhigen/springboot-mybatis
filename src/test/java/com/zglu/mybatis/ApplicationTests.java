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
        User user = userMapper.findById(1);
        log.info(user);
    }

}
