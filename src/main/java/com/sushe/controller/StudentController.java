package com.sushe.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sushe.annotation.ExportAs;
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

   @RequestMapping(value = "/addStudent" ,method = RequestMethod.POST)
   @ResponseBody
   public String addStudent(@RequestBody Student student) {
	   int s = studentService.addStudent(student);
	    return "student_list";
    }

	/**
	 * 修改学生信息
	 */
	@RequestMapping(value = "/updateStudent" ,method = RequestMethod.POST )
	public String updateStudent( Student student) {
		int s = studentService.updateStudent(student);
		return "redirect:/findStudent";
	}


    @RequestMapping( "/findStudentById")
    public String findStudentById(Integer s_id,HttpSession session) {

        Student s= studentService.findStudentById(s_id);
        session.setAttribute("s",s);
        return "student/student_edit";
    }
}
