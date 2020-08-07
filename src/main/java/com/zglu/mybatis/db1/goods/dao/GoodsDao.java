package com.zglu.mybatis.db1.goods.dao;

import com.zglu.mybatis.common.Page;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zglu
 */
@Component
@AllArgsConstructor
public class GoodsDao {
    private final GoodsMapper mapper;

    public Goods add(Goods t) {
        mapper.add(t);
        return t;
    }

    public Goods set(Goods t) {
        mapper.set(t);
        return t;
    }

    public int remove(long id) {
        return mapper.remove(id);
    }

    public List<Goods> get() {
        return mapper.get();
    }

    public Goods get(long id) {
        return mapper.getById(id);
    }

    public Page<Goods> page(Integer number, Integer size) {
        String sql = "";
        long totalElements = mapper.count(sql);
        Page<Goods> page = new Page<>(totalElements, number, size);
        sql += " LIMIT " + size + " OFFSET " + page.getOffset();
        List<Goods> content = mapper.getBySql(sql);
        page.setContent(content);
        return page;
    }

}
