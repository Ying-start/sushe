package com.sushe.service.impl;



import com.github.pagehelper.PageInfo;
import com.sushe.annotation.PageQuery;
import com.sushe.dao.DormitoryDao;
import com.sushe.po.Building;
import com.sushe.po.Dormitory;
import com.sushe.service.DormitoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户Service接口实现类
 */
@Service("dormitoryService")
@Transactional
public class DormitoryServiceImpl implements DormitoryService {
	// classDao
	@Autowired
	private DormitoryDao dormitoryDao;


	//分页查询
	@Override
	@PageQuery
	public PageInfo<Dormitory> findPageInfo(Dormitory dormitory) {

		List<Dormitory> dormitoryList =	dormitoryDao.getDormitoryList(dormitory.getA_name(),dormitory.getS_dormitoryid(),dormitory.getD_dormbuilding());

		return new PageInfo<>(dormitoryList);
	}

	@Override
	public List<Dormitory> getAll(){
		List<Dormitory> dormitoryList = dormitoryDao.getAll();
		return dormitoryList;
	}

	//添加宿舍信息
	@Override
	public int addDormitory(Dormitory dormitory) {
		return dormitoryDao.addDormitory(dormitory);
	}

	//通过id删除宿舍信息
	@Override
	public int deleteDormitory(Integer d_id) {
		return dormitoryDao.deleteDormitory(d_id);
	}

	//修改宿舍信息
	@Override
	public int updateDormitory(Dormitory dormitory) {
		return dormitoryDao.updateDormitory(dormitory);
	}

	@Override
	public Dormitory findDormitoryById (Integer d_id){
		Dormitory d = dormitoryDao.findDormitoryById(d_id);
		return  d;
	}
	@Override
	public Dormitory findBuliding(Integer s_dormitoryid) {
		Dormitory d = dormitoryDao.findBuliding(s_dormitoryid);
		return d;
	}



	//查询宿舍人员信息
	@Override
	@PageQuery
	public PageInfo<Dormitory> findDormitoryStudent(Dormitory dormitory) {
		List<Dormitory> dormitoryList = dormitoryDao.findDormitoryStudent(dormitory);
		return new PageInfo<>(dormitoryList);
	}


}
