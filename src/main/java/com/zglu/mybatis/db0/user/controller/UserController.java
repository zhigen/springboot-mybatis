package com.zglu.mybatis.db0.user.controller;

import com.zglu.mybatis.common.Page;
import com.zglu.mybatis.db0.user.dao.User;
import com.zglu.mybatis.db0.user.dto.UserDto;
import com.zglu.mybatis.db0.user.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zglu
 */
@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private final UserService service;

    @PostMapping
    @ApiOperation("增")
    public User add(@RequestBody UserDto dto) {
        return service.add(dto.toEntity());
    }

    @PatchMapping
    @ApiOperation("改，忽略空属性")
    public User set(@RequestBody UserDto dto) {
        return service.set(dto.toEntity());
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删")
    public void remove(@PathVariable long id) {
        service.remove(id);
    }

    @GetMapping
    @ApiOperation("查")
    public List<User> get() {
        return service.get();
    }

    @GetMapping("/{id}")
    @ApiOperation("查")
    public User get(@PathVariable long id) {
        return service.get(id);
    }

    @GetMapping("/page")
    @ApiOperation("查分页")
    public Page<User> page(@RequestParam Integer page, @RequestParam Integer size) {
        return service.page(page, size);
    }

}
