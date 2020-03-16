package com.zglu.mybatis.user.controller;

import com.zglu.mybatis.user.dao.User;
import com.zglu.mybatis.user.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
        userService.add(user);
        return user;
    }

    @GetMapping("/user/{id}")
    @ApiOperation("查")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", dataType = "long", name = "id", value = "id", required = true),
    })
    public User get(@PathVariable long id) {
        return userService.get(id);
    }

    @PutMapping("/user")
    @ApiOperation("覆盖改")
    public User put(@RequestBody User user) {
        userService.put(user);
        return user;
    }

    @PatchMapping("/user")
    @ApiOperation("改")
    public User set(@RequestBody User user) {
        userService.set(user);
        return user;
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
