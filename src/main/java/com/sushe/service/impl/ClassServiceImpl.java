package com.sushe.service.impl;


import com.github.pagehelper.Page;
import com.sushe.annotation.PageQuery;
import com.sushe.dao.ClassDao;
import com.sushe.po.Class;
import com.github.pagehelper.PageInfo;
import com.sushe.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户Service接口实现类
 */
@Service("classService")
@Transactional
public class ClassServiceImpl implements ClassService {
	// classDao
	@Autowired
	private ClassDao classDao;


	//分页查询
	@Override
	@PageQuery
	public PageInfo<Class> findClass(Class clazz) {

		List<Class> classList =	classDao.getClassList(clazz.getC_classname(),clazz.getC_classid(),clazz.getC_counsellor());

		return new PageInfo<>(classList);
	}

	@Override
	public List<Class> getAll(){
		List<Class> classList = classDao.getAll();
		return  classList;
	}

	//通过id删除班级信息
	@Override
	public int deleteClass(Integer c_id) {
		return classDao.deleteClass(c_id);
	}

	//添加班级信息
	@Override
	public int addClass(Class uclass) {
		return classDao.addClass(uclass);
	}

	@Override
	public Class findClassById (Integer c_id){
		Class c = classDao.findClassById(c_id);
		return  c;
	}
	//修改班级信息
	@Override
	public int updateClass(Class uclass) {
		return classDao.updateClass(uclass);
	}

	//查询宿舍人员信息
	@Override
	@PageQuery
	public PageInfo<Class> findClassStudent(Class uclass) {
		List<Class> classList = classDao.findClassStudent(uclass);
		return new PageInfo<>(classList);
	}
}
