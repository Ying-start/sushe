package com.sushe.service.impl;


import com.github.pagehelper.PageInfo;
import com.sushe.annotation.PageQuery;
import com.sushe.dao.DormitoryDao;
import com.sushe.dao.StudentDao;
import com.sushe.po.BusinessException;
import com.sushe.po.Dormitory;
import com.sushe.po.Student;
import com.sushe.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户Service接口实现类
 */
@Service("studentService")
@Transactional
public class StudentServiceImpl implements StudentService {
	// 注入studentDao
	@Autowired
	private StudentDao studentDao;
	@Autowired
	private DormitoryDao dormitoryDao;



	//分页查询
	@Override
	@PageQuery
	public PageInfo<Student> findPageInfo(Student student) {

		List<Student> studentList =	studentDao.getStudentList(student.getS_name(),student.getS_studentid(),student.getS_classid(),student.getS_classname());

		return new PageInfo<>(studentList);
	}

	@Override
	public List<Student> getAll(){
		List<Student> studentList = studentDao.getAll();
		return studentList;
	}

	//通过id删除学生信息
	@Override
	@Transactional
	public int deleteStudent(Integer s_id) {
		Student student= studentDao.findStudentById(s_id);
		Dormitory dormitory = dormitoryDao.findBuliding(student.getS_dormitoryid());
		dormitory.setD_bed(dormitory.getD_bed() - 1);
		dormitoryDao.updateDormitory(dormitory);
		return studentDao.deleteStudent(s_id);
	}
	//添加学生信息
	@Override
	@Transactional
	public  int addStudent(Student student) {

		Dormitory dormitory = dormitoryDao.findBuliding(student.getS_dormitoryid());
		if (dormitory == null) {
			throw new BusinessException("宿舍编号[" + student.getS_dormitoryid() + "]不存在");
		}

		// 2. 判断床位是否充足
		if (dormitory. getD_bed() >= dormitory.getD_bedtotal()) {
			throw new BusinessException("宿舍床位已满（" + dormitory.getD_bed() +
					"/" + dormitory.getD_bedtotal() + "），无法添加学生");
		}
		dormitory.setD_bed(dormitory.getD_bed() + 1);
		dormitoryDao.updateDormitory(dormitory);
		return studentDao.addStudent(student);

	}
	//修改学生信息
	@Override
	@Transactional
	public int updateStudent(Student student) {
		Dormitory oldDormitory = dormitoryDao.findBuliding(studentDao.findStudentById(student.getS_id()).getS_dormitoryid());
		Dormitory newDormitory = dormitoryDao.findBuliding(student.getS_dormitoryid());
		if (oldDormitory == null || newDormitory == null) throw new BusinessException("宿舍不存在");

		// 如果更换宿舍
		if (!oldDormitory.getD_id().equals(newDormitory.getD_id())) {
			// 判断新宿舍床位是否已满
			if (newDormitory.getD_bed() >= newDormitory.getD_bedtotal()) {
				throw new BusinessException("宿舍床位已满（" + newDormitory.getD_bed() +
						"/" + newDormitory.getD_bedtotal() + "），无法分配");
			}

			// old宿舍-1，新宿舍+1
			oldDormitory.setD_bed(Math.max(oldDormitory.getD_bed() - 1, 0));
			newDormitory.setD_bed(newDormitory.getD_bed() + 1);
			dormitoryDao.updateDormitory(oldDormitory);
			dormitoryDao.updateDormitory(newDormitory);
		}

		return studentDao.updateStudent(student);
	}

	@Override
	public Student findStudentById (Integer s_id){
		Student s = studentDao.findStudentById(s_id);
         return  s;
	}


}
