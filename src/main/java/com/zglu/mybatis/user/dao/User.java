package com.zglu.mybatis.user.dao;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author zglu
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;
    private String name;
    private LocalDateTime createdDate;
    private Long createdBy;
    private LocalDateTime lastModifiedDate;
    private Long lastModifiedBy;
    private Boolean enable;

}
