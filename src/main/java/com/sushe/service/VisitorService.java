package com.sushe.service;

import com.github.pagehelper.PageInfo;
import com.sushe.po.Visitor;

import java.util.List;

/**
 * @program: dormitorySystem
 * @description: 访客
 * @author: Joyrocky
 * @create: 2019-05-14 12:39
 **/
public interface VisitorService {
    //分页查询
    public PageInfo<Visitor> findPageInfo(Visitor visitor);
    public int addVisitor(Visitor visitor);   //添加访客信息
    public List<Visitor> getAll();
}
