package com.sushe.service.impl;


import com.github.pagehelper.PageInfo;
import com.sushe.annotation.PageQuery;
import com.sushe.dao.StudentDao;
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
	public int deleteStudent(Integer s_id) {
		return studentDao.deleteStudent(s_id);
	}
    //添加学生信息
	@Override
	public  int addStudent(Student student) {
		return studentDao.addStudent(student);
	}
	//修改学生信息
	@Override
	public int updateStudent(Student student) { return studentDao.updateStudent(student); }

	@Override
	public Student findStudentById (Integer s_id){
		Student s = studentDao.findStudentById(s_id);
         return  s;
	}


}
