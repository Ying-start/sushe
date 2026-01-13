package com.sushe.dao;
import com.sushe.po.Student;
import org.apache.ibatis.annotations.Param;


import java.util.List;

/**
 * 管理员DAO层接口
 */
public interface StudentDao {
	/**
	 * 进行分页查询
	 */
	 //获取用户列表
     public List<Student> getStudentList(@Param("s_name") String s_name, @Param("s_studentid")Integer s_studentid,@Param("s_classid")Integer s_classid,
										 @Param("s_classname")String s_classname);

	 public int deleteStudent(Integer s_id);   //删除学生信息
	 public int addStudent(Student student);   //添加学生信息
	 public int updateStudent(Student student); //修改学生信息
	 public Student findStudentById(Integer s_id);
	 public List<Student> getAll();
}
