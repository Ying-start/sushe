package com.sushe.service;

import com.sushe.po.DormClean;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @program: dormitorySystem
 * @description: 宿舍卫生服务接口
 * @author: Joyrocky
 * @create: 2019-04-24 15:18
 **/
public interface DormCleanService {
    //分页查询
    public PageInfo<DormClean> findPageInfo(DormClean dormClean);

    public int addDormClean(DormClean dormclean);    //添加宿舍信息
    public int deleteDormClean(Integer g_id);   //删除宿舍信息
    public int updateDormClean(DormClean dormclean); //修改宿舍信息
    public DormClean findDormCleanById(Integer g_id);
    public List<DormClean> getAll();
}
