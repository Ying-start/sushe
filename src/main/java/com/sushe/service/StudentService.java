package com.sushe.service;
import com.github.pagehelper.PageInfo;
import com.sushe.po.Student;

import java.util.List;

/**
 * 用户Service层接口
 */
public interface StudentService {

	//分页查询
	public PageInfo<Student> findPageInfo(Student student);

	public int deleteStudent(Integer s_id);   //通过id删除学生信息
	public int addStudent(Student student);   //添加学生信息
	public int updateStudent(Student student); //修改学生信息
	public Student findStudentById(Integer s_id);
	public List<Student> getAll();

}
