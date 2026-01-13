package com.sushe.service.impl;

import com.sushe.annotation.PageQuery;
import com.sushe.dao.AdminDao;
import com.sushe.po.Admin;
import com.github.pagehelper.PageInfo;
import com.sushe.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户Service接口实现类
 */
@Service
@Transactional
public class AdminServiceImpl implements AdminService {
	// 注入UserDao
	@Autowired
	private AdminDao adminDao;

	//管理登陆查询
	@Override
	public Admin findAdmin(Admin admin) {
		Admin a = adminDao.findAdmin(admin);
		return a;
	}

	@Override
	public List<Admin> getAll(){

		List<Admin> adminList = adminDao.getAll();
		return adminList;
    }

	@Override
	@PageQuery
	public PageInfo<Admin> findPageInfo(Admin admin) {

			List<Admin> adminList =	adminDao.getAdminList(admin.getA_username(),admin.getA_describe(),admin.getA_id());

		return new PageInfo<>(adminList);
	}

	//添加管理员信息
	@Override
	public int addAdmin(Admin admin) {
		return adminDao.addAdmin(admin);
	}

	//通过id删除管理员信息
	@Override
	public int deleteAdmin(Integer a_id) {
		return adminDao.deleteAdmin(a_id);
	}

	//修改管理员信息
	@Override
	public int updateAdmin(Admin admin) {
		return adminDao.updateAdmin(admin);
	}

	@Override
	public Admin findAdminById (Integer a_id){
		Admin a = adminDao.findAdminById(a_id);
		return  a;
	}
}
