package com.sushe.annotation;


import java.lang.annotation.*;

/**
 * 分页查询注解
 * 加在方法上，自动开启 PageHelper 分页
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PageQuery {

}
