package com.sushe.service;

import com.github.pagehelper.PageInfo;
import com.sushe.po.Dormitory;

import java.util.List;

/**
 * 用户Service层接口
 */
public interface DormitoryService {

	//分页查询
	public PageInfo<Dormitory> findPageInfo(Dormitory dormitory);

	public int addDormitory(Dormitory dormitory);    //添加宿舍信息
	public int deleteDormitory(Integer d_id);   //删除宿舍信息
	public int updateDormitory(Dormitory dormitory); //修改宿舍信息
	public Dormitory findDormitoryById(Integer d_id);
	public Dormitory findBuliding(Integer s_dormitoryid);

	public PageInfo<Dormitory> findDormitoryStudent(Dormitory dormitory);//查询宿舍人员信息
	public List<Dormitory> getAll();

}
