package com.sushe.controller;

import com.github.pagehelper.PageInfo;
import com.sushe.annotation.ExportAs;
import com.sushe.po.Admin;
import com.sushe.po.Building;
import com.sushe.po.DormClean;
import com.sushe.po.export.DormCleanExport;
import com.sushe.service.BuildingService;
import com.sushe.service.DormCleanService;
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
 * @program: dormitorySystem
 * @description: 宿舍卫生控制器
 * @author: Joyrocky
 * @create: 2019-04-24 11:19
 **/

@Controller
public class DormCleanController {

    //依赖注入
    @Autowired
    private DormCleanService dormCleanService;
    @Autowired
    BuildingService buildingService;

    /**
     * 分页查询
     * pageIndex 当前页码
     * pageSize  显示条数
     */
    @RequestMapping(value = "/findDormClean")
    public String findDormClean(DormClean dormClean , Model model,HttpSession session) {
        Admin currentAdmin = (Admin) session.getAttribute("ad");
        Building building= buildingService.findManagerBuilding(currentAdmin.getA_id()).get(0);
        dormClean.setD_dormbuilding(building.getD_dormbuilding());
        PageInfo<DormClean> dormCleanList = dormCleanService.findPageInfo(dormClean);
        model.addAttribute("pageInfo",dormCleanList);
        return "dormclean/dormclean_list";
    }

    /**
     * 导出Excel
     */
    @RequestMapping(value = "/exportdormcleanlist", method = RequestMethod.POST)
    @ResponseBody
    @ExportAs(DormCleanExport.class)
    public List<DormClean> exportDormclean(){
        List<DormClean> dormclean = dormCleanService.getAll();
        return dormclean;
    }

    /**
     * 添加宿舍卫生信息
     */
    @RequestMapping(value = "/addDormClean" ,method = RequestMethod.POST)
    @ResponseBody
    public String addDormClean( @RequestBody DormClean dormclean) {
        int d = dormCleanService.addDormClean(dormclean);
        return "dormclean_list";
    }

    /**
     * 删除宿舍卫生信息
     */
    @RequestMapping( "/deleteDormClean")
    @ResponseBody
    public String deleteDormClean(Integer g_id) {
        int d = dormCleanService.deleteDormClean(g_id);
        return "dormclean_list";
    }

    /**
     * 修改宿舍卫生信息
     */
    @RequestMapping( "/updateDormClean")
    public String updateDormClean( DormClean dormclean) {
        int d = dormCleanService.updateDormClean(dormclean);
        return "redirect:/findDormClean";
    }


    @RequestMapping( "/findDormCleanById")
    public String findDormCleanById(Integer g_id, HttpSession session) {

        DormClean d= dormCleanService.findDormCleanById(g_id);
        session.setAttribute("d",d);
        return "dormclean/dormclean_edit";
    }


}

