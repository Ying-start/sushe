package com.sushe.service.impl;

import com.github.pagehelper.PageInfo;
import com.sushe.annotation.PageQuery;
import com.sushe.dao.DormRepairDao;
import com.sushe.po.DormRepair;
import com.sushe.service.DormRepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: dormitorySystem
 * @description: 维修登记
 * @author: Joyrocky
 * @create: 2019-04-28 00:24
 **/
@Service("dormRepairService")
@Transactional
public class DormRepairServiceImpl implements DormRepairService {
    // classDao
    @Autowired
    private DormRepairDao dormRepairDao;


    //分页查询
    @Override
    @PageQuery
    public PageInfo<DormRepair> findPageInfo(DormRepair dormRepair) {

            List<DormRepair> dormRepairList =	dormRepairDao.getDormRepairList(dormRepair.getD_id(),dormRepair.getD_dormbuilding());

        return new PageInfo<>(dormRepairList);
    }

    @Override
    public List<DormRepair> getAll(){
        List<DormRepair> dormRepairList = dormRepairDao.getAll();
        return dormRepairList;
    }

    //添加宿舍信息
    @Override
    public int addDormRepair(DormRepair dormrepair) {
        return dormRepairDao.addDormRepair(dormrepair);
    }

    //通过id删除宿舍信息
    @Override
    public int deleteDormRepair(Integer r_id) {
        return dormRepairDao.deleteDormRepair(r_id);
    }

    //修改宿舍信息
    @Override
    public int updateDormRepair(DormRepair dormrepair) {
        return dormRepairDao.updateDormRepair(dormrepair);
    }

    @Override
    public DormRepair findDormRepairById (Integer r_id){
        DormRepair d = dormRepairDao.findDormRepairById(r_id);
        return  d;
    }

}

