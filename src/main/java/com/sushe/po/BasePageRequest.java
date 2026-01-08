package com.sushe.po;

import lombok.Data;

/**
 * 分页请求基类
 * 所有需要分页的DTO都继承该类
 */
@Data
public class BasePageRequest {
    // 默认第1页
    private Integer page = 1;

    // 默认每页10条
    private Integer limit = 5;
}

