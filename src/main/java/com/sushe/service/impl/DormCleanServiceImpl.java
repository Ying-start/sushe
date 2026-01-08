package com.sushe.service.impl;

import com.sushe.annotation.PageQuery;
import com.sushe.dao.DormCleanDao;
import com.sushe.po.DormClean;
import com.github.pagehelper.PageInfo;
import com.sushe.service.DormCleanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: dormitorySystem
 * @description: 宿舍卫生服务接口实现
 * @author: Joyrocky
 * @create: 2019-04-24 15:19
 **/
@Service("dormCleanService")
@Transactional
public class DormCleanServiceImpl implements DormCleanService {
    // classDao
    @Autowired
    private DormCleanDao dormCleanDao;


    //分页查询
    @Override
    @PageQuery
    public PageInfo<DormClean> findPageInfo(DormClean dormClean) {

            List<DormClean> dormCleanList =	dormCleanDao.getDormCleanList(dormClean.getD_id(),dormClean.getD_dormbuilding());

        return new PageInfo<>(dormCleanList);
    }

    @Override
    public List<DormClean> getAll(){
        List<DormClean> dormCleanList = dormCleanDao.getAll();
        return dormCleanList;
    }

    //添加宿舍卫生信息
    @Override
    public int addDormClean(DormClean dormclean) {
        return dormCleanDao.addDormClean(dormclean);
    }

    //通过id删除宿舍卫生信息
    @Override
    public int deleteDormClean(Integer g_id) {
        return dormCleanDao.deleteDormClean(g_id);
    }

    //修改宿舍卫生信息
    @Override
    public int updateDormClean(DormClean dormclean) {
        return dormCleanDao.updateDormClean(dormclean);
    }

    @Override
    public DormClean findDormCleanById (Integer g_id){
        DormClean d = dormCleanDao.findDormCleanById(g_id);
        return  d;
    }

}

