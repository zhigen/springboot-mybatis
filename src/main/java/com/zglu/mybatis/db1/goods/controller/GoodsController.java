package com.zglu.mybatis.db1.goods.controller;

import com.zglu.mybatis.common.Page;
import com.zglu.mybatis.db1.goods.dao.Goods;
import com.zglu.mybatis.db1.goods.dto.GoodsDto;
import com.zglu.mybatis.db1.goods.service.GoodsService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zglu
 */
@RestController
@RequestMapping("/goods")
@AllArgsConstructor
public class GoodsController {
    private final GoodsService service;

    @PostMapping
    @ApiOperation("增")
    public Goods add(@RequestBody GoodsDto dto) {
        return service.add(dto.toEntity());
    }

    @PatchMapping
    @ApiOperation("改，忽略空属性")
    public Goods set(@RequestBody GoodsDto dto) {
        return service.set(dto.toEntity());
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删")
    public void remove(@PathVariable long id) {
        service.remove(id);
    }

    @GetMapping
    @ApiOperation("查")
    public List<Goods> get() {
        return service.get();
    }

    @GetMapping("/{id}")
    @ApiOperation("查")
    public Goods get(@PathVariable long id) {
        return service.get(id);
    }

    @GetMapping("/page")
    @ApiOperation("查分页")
    public Page<Goods> page(@RequestParam Integer page, @RequestParam Integer size) {
        return service.page(page, size);
    }

}
