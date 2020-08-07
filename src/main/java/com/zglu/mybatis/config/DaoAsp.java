package com.zglu.mybatis.config;

import com.zglu.mybatis.common.BaseEntity;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

/**
 * @author zglu
 */
@Aspect
@Component
public class DaoAsp implements Ordered {
    private static final String TOKEN_KEY = "token";

    @Pointcut("execution(* com.zglu.mybatis..dao..*(..))")
    public void by() {
    }

    @Around("by()")
    public Object needLogin(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        Assert.notNull(servletRequestAttributes, "servletRequestAttributes must not be null!");
        HttpServletRequest request = servletRequestAttributes.getRequest();
        long userId = Long.parseLong(request.getHeader(TOKEN_KEY));
        Object[] args = proceedingJoinPoint.getArgs();
        for (Object arg : args) {
            if (arg instanceof BaseEntity) {
                ((BaseEntity) arg).setLastModifiedBy(userId);
                ((BaseEntity) arg).setLastModifiedDate(LocalDateTime.now());
                if (((BaseEntity) arg).getId()==null || ((BaseEntity) arg).getId()<=0) {
                    ((BaseEntity) arg).setCreatedBy(userId);
                    ((BaseEntity) arg).setCreatedDate(LocalDateTime.now());
                }
            }
        }
        return proceedingJoinPoint.proceed();
    }

    @Override
    public int getOrder() {
        return 0;
    }

}
