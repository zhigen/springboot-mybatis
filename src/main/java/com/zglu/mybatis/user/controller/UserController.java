package com.zglu.mybatis.user.controller;

import com.zglu.mybatis.Page;
import com.zglu.mybatis.user.dao.User;
import com.zglu.mybatis.user.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zglu
 */
@RestController
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/user")
    @ApiOperation("增")
    public User add(@RequestBody User user) {
        return userService.add(user);
    }

    @GetMapping("/user/{id}")
    @ApiOperation("查")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", dataType = "long", name = "id", value = "id", required = true),
    })
    public User get(@PathVariable long id) {
        return userService.get(id);
    }

    @GetMapping("/user")
    @ApiOperation("查")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "string", name = "q", value = "搜索，语法与SQL一致，除属性驼峰外全小写", defaultValue = "id >= 2 and id<=10"),
            @ApiImplicitParam(paramType = "query", dataType = "string", name = "order", value = "排序，语法与SQL一致，除属性驼峰外全小写", defaultValue = "name asc, id desc"),
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "offset", value = "偏移量", defaultValue = "0"),
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "limit", value = "行数", defaultValue = "10"),
    })
    public List<User> list(String q, String order, Integer offset, Integer limit) {
        return userService.list(q, order, offset, limit);
    }

    @GetMapping("/user/page")
    @ApiOperation("查分页")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", dataType = "string", name = "q", value = "搜索，语法与SQL一致，除属性驼峰外全小写", defaultValue = "id >= 2 and id<=10"),
            @ApiImplicitParam(paramType = "query", dataType = "string", name = "order", value = "排序，语法与SQL一致，除属性驼峰外全小写", defaultValue = "name asc, id desc"),
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "number", value = "页号", defaultValue = "0"),
            @ApiImplicitParam(paramType = "query", dataType = "int", name = "size", value = "行数", defaultValue = "10"),
    })
    public Page<User> page(String q, String order, Integer number, Integer size) {
        return userService.page(q, order, number, size);
    }

    @PutMapping("/user")
    @ApiOperation("增或覆盖改")
    public User put(@RequestBody User user) {
        return userService.put(user);
    }

    @PatchMapping("/user")
    @ApiOperation("改")
    public User set(@RequestBody User user) {
        return userService.set(user);
    }

    @PatchMapping("/user/{id}")
    @ApiOperation("逻辑删")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", dataType = "long", name = "id", value = "id", required = true),
    })
    public User disable(@PathVariable long id) {
        return userService.disable(id);
    }

    @DeleteMapping("/user/{id}")
    @ApiOperation("删")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", dataType = "long", name = "id", value = "id", required = true),
    })
    public int remove(@PathVariable long id) {
        return userService.remove(id);
    }

}