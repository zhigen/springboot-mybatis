package com.zglu.mybatis.db1.goods.service;

import com.zglu.mybatis.common.Page;
import com.zglu.mybatis.db1.goods.dao.Goods;
import com.zglu.mybatis.db1.goods.dao.GoodsDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zglu
 */
@Service
@AllArgsConstructor
public class GoodsService {
    private final GoodsDao dao;

    public Goods add(Goods user) {
        return dao.add(user);
    }

    public Goods set(Goods user) {
        return dao.set(user);
    }

    public int remove(long id) {
        return dao.remove(id);
    }

    public List<Goods> get() {
        return dao.get();
    }

    public Goods get(long id) {
        return dao.get(id);
    }

    public Page<Goods> page(Integer number, Integer size) {
        return dao.page(number, size);
    }

}
