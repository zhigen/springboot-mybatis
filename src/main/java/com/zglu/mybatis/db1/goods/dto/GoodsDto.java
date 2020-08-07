package com.zglu.mybatis.db1.goods.dto;

import com.zglu.mybatis.db1.goods.dao.Goods;
import lombok.Data;

/**
 * @author zglu
 */
@Data
public class GoodsDto {
    private Long id;
    private String name;

    public Goods toEntity(){
        Goods user = new Goods();
        user.setId(id);
        user.setName(name);
        return user;
    }

}
