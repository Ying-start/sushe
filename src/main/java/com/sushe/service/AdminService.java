package com.sushe.service;
import com.sushe.po.Admin;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * 用户Service层接口
 */

public interface AdminService {
	// 通过账号和密码查询用户
	public Admin findAdmin(Admin admin);

	//找到所有所有数据
	public List<Admin> getAll();

	//分页查询
	public PageInfo<Admin> findPageInfo(Admin admin);

	public int addAdmin(Admin admin);    //添加管理员信息
	public int deleteAdmin(Integer a_id);   //删除管理员信息
	public int updateAdmin(Admin admin); //修改管理员信息
	public Admin findAdminById(Integer a_id);
}
