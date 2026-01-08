package com.sushe.service;

import com.github.pagehelper.PageInfo;
import com.sushe.po.DormRepair;

import java.util.List;

/**
 * @program: dormitorySystem
 * @description: 维修登记
 * @author: Joyrocky
 * @create: 2019-04-28 00:25
 **/
public interface DormRepairService {

    //分页查询
    public PageInfo<DormRepair> findPageInfo(DormRepair dormRepair);

    public int addDormRepair(DormRepair dormrepair);    //添加宿舍信息
    public int deleteDormRepair(Integer r_id);   //删除宿舍信息
    public int updateDormRepair(DormRepair dormrepair); //修改宿舍信息
    public DormRepair findDormRepairById(Integer r_id);
    public List<DormRepair> getAll();
}
