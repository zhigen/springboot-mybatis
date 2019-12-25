package com.zglu.mybatis;

import com.zglu.mybatis.mapper.UserMapper;
import lombok.extern.log4j.Log4j2;
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
        int id = 1;
        log.info(userMapper.findById(id));
    }

}
