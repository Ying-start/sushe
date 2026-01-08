package com.sushe.service;
import com.sushe.po.Class;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 用户Service层接口
 */
public interface ClassService {

	//分页查询
	public PageInfo<Class> findClass(Class clazz);

	public int deleteClass(Integer c_id);   //删除班级信息
	public int addClass(Class ucalss);    //添加班级信息
	public Class findClassById(Integer c_id);
	public int updateClass(Class uclass); //修改班级信息
	public PageInfo<Class> findClassStudent(Class uclass);//查询班级人员信息
	public List<Class> getAll();
}
