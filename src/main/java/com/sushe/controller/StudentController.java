package com.sushe.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sushe.annotation.ExportAs;
import com.sushe.po.BusinessException;
import com.sushe.po.Result;
import com.sushe.po.Student;
import com.sushe.po.StudentClean;
import com.sushe.po.export.StudentExport;
import com.sushe.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 用户控制器类
 */
@Controller
public class StudentController {
	// 依赖注入
	@Autowired
	private StudentService studentService;

	/**
	 * 分页查询
	 * pageIndex 当前页码
	 * pageSize  显示条数
	 */
	@RequestMapping(value = "/findStudent")
	public String findStudent(Student student, Model model) {

		model.addAttribute("pageInfo", studentService.findPageInfo(student));
	  model.addAttribute("s_name",student.getS_name());
		return "student/student_list";
	}

	/**
	 * 导出Excel
	 */
	@RequestMapping(value = "/exportstudentlist", method = RequestMethod.POST)
	@ResponseBody
	@ExportAs(StudentExport.class)
	public List<Student> exportStudent(){
		List<Student> studentList = studentService.getAll();
		return studentList;
	}

	/**
	 * 删除学生信息
	 */
	@RequestMapping( "/deleteStudent")
	@ResponseBody
	public String deleteStudent(Integer s_id) {
		int s = studentService.deleteStudent(s_id);
		return "student_list";
	}

	/**
	 * 添加学生信息
	 */
	@RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	@ResponseBody
	public Result<String> addStudent(@RequestBody Student student) {
		try {
			// 基本校验
			if (student.getS_studentid() == null ) {
				return Result.error("学号不能为空");
			}
			if (student.getS_name() == null || "".equals(student.getS_name().trim())) {
				return Result.error("姓名不能为空");
			}
			if (student.getS_dormitoryid() == null) {
				return Result.error("宿舍编号不能为空");
			}

			int result = studentService.addStudent(student);
			if (result > 0) {
				return Result.success("添加成功");
			} else {
				return Result.error("添加失败");
			}
		} catch (BusinessException e) {
			// 业务异常（如床位已满）
			return Result.error(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			return Result.error("添加失败：系统错误");
		}
	}

	/**
	 * 修改学生信息
	 */
	@RequestMapping(value = "/updateStudent" ,method = RequestMethod.POST )
	@ResponseBody
	public Result<String> updateStudent(@RequestBody Student student) {
		try {
			int s = studentService.updateStudent(student);
			if(s > 0){
				return Result.success("操作成功");
			} else {
				return Result.error("修改失败");
			}
		} catch (BusinessException e) {
			return Result.error(e.getMessage());
		} catch (Exception e) {
			return Result.error("系统异常，请联系管理员");
		}
	}



	@RequestMapping( "/findStudentById")
    public String findStudentById(Integer s_id,HttpSession session) {

        Student s= studentService.findStudentById(s_id);
        session.setAttribute("s",s);
        return "student/student_edit";
    }
}
