package com.zglu.mybatis.db0.user.dao;

import com.zglu.mybatis.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author zglu
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity {
    private String name;

}
