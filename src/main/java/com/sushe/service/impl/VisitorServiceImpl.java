package com.sushe.service.impl;

import com.github.pagehelper.PageInfo;
import com.sushe.annotation.PageQuery;
import com.sushe.dao.VisitorDao;
import com.sushe.po.Visitor;
import com.sushe.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: dormitorySystem
 * @description: 访客
 * @author: Joyrocky
 * @create: 2019-05-14 12:39
 **/
@Service("visitorService")
@Transactional
public class VisitorServiceImpl implements VisitorService {
    // 注入studentDao
    @Autowired
    private VisitorDao visitorDao;


    //分页查询
    @Override
    @PageQuery
    public PageInfo<Visitor> findPageInfo(Visitor visitor) {

            List<Visitor> visitorList =	visitorDao.getVisitorList(visitor.getV_name(),visitor.getV_phone());

        return new PageInfo<>(visitorList);
    }

    @Override
    public List<Visitor> getAll(){
        List<Visitor> visitorList = visitorDao.getAll();
        return visitorList;
    }

    //添加学生信息
    @Override
    public  int addVisitor(Visitor visitor) {
        return visitorDao.addVisitor(visitor);
    }
}

