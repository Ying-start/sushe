package com.sushe.controller;



import com.github.pagehelper.PageInfo;
import com.sushe.annotation.ExportAs;
import com.sushe.po.Admin;
import com.sushe.po.Building;
import com.sushe.po.Dormitory;
import com.sushe.po.export.DormitoryExport;
import com.sushe.service.BuildingService;
import com.sushe.service.DormitoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 用户控制器类
 */
@Controller
public class DormitoryController {
	// 依赖注入
	@Autowired
	private DormitoryService dormitoryService;
	@Autowired
	private BuildingService buildingService;
	/**
	 * 分页查询
	 * pageIndex 当前页码
	 * pageSize  显示条数
	 */
	@RequestMapping(value = "/findDormitory")
	public String findDormitory(Dormitory dormitory, Model model, HttpSession session) {
		Admin currentAdmin = (Admin) session.getAttribute("ad");
	 	Building building= buildingService.findManagerBuilding(currentAdmin.getA_id()).get(0);
		if(building!=null) {
			dormitory.setD_dormbuilding(building.getD_dormbuilding());
		}
	    model.addAttribute("pageInfo",dormitoryService.findPageInfo(dormitory));
		return "dormitory/dormitory_list";
	}

	/**
	 * 导出Excel
	 */
	@RequestMapping(value = "/exportdormitorylist", method = RequestMethod.POST)
	@ResponseBody
	@ExportAs(DormitoryExport.class)
	public List<Dormitory> exportDormitory(){
		List<Dormitory> dormitoryList = dormitoryService.getAll();
		return dormitoryList;
	}

	/**
	 * 添加宿舍信息
	 */
	@RequestMapping(value = "/addDormitory" ,method = RequestMethod.POST)
	@ResponseBody
	public String addDormitory( @RequestBody Dormitory dormitory) {
		int d = dormitoryService.addDormitory(dormitory);
		return "dormitory_list";
	}

	/**
	 * 删除宿舍信息
	 */
	@RequestMapping( "/deleteDormitory")
	@ResponseBody
	public String deleteDormitory(Integer d_id) {
		int d = dormitoryService.deleteDormitory(d_id);
		return "dormitory_list";
	}

	/**
	 * 修改学生信息
	 */
	@RequestMapping( "/updateDormitory")
	public String updateDormitory( Dormitory dormitory) {
		int d = dormitoryService.updateDormitory(dormitory);
		return "redirect:/findDormitory";
	}


	@RequestMapping( "/findDormitoryById")
	public String findDormitoryById(Integer d_id,HttpSession session) {

		Dormitory d= dormitoryService.findDormitoryById(d_id);
		session.setAttribute("d",d);
		return "dormitory/dormitory_edit";
	}

	/**
	 * 宿舍人员信息查询
	 */
	@RequestMapping(value = "/findDormitoryStudent")
	public String findDormitoryStudent(Dormitory dormitory,Model model,HttpSession session, Building building) {
		Admin currentAdmin = (Admin) session.getAttribute("ad");
		building= buildingService.findManagerBuilding(currentAdmin.getA_id()).get(0);
		dormitory.setD_dormbuilding(building.getD_dormbuilding());
		model.addAttribute("pageInfo",dormitoryService.findDormitoryStudent(dormitory));
		return "dormitory_Studentlist";
	}


}
