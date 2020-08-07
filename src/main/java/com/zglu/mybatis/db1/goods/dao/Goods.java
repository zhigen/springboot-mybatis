package com.zglu.mybatis.db1.goods.dao;

import com.zglu.mybatis.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author zglu
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Goods extends BaseEntity {
    private String name;

}
