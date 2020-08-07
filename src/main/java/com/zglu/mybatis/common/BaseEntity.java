package com.zglu.mybatis.common;

import lombok.Data;
import lombok.experimental.FieldNameConstants;

import java.time.LocalDateTime;

/**
 * @author zglu
 */
@Data
@FieldNameConstants
public class BaseEntity {
    private static final long serialVersionUID = -8296239665382719900L;
    private Long id;
    private LocalDateTime createdDate;
    private Long createdBy;
    private LocalDateTime lastModifiedDate;
    private Long lastModifiedBy;
    private Boolean deleted = false;

}
