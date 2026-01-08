package com.sushe.controller;

import com.sushe.annotation.ExportAs;
import com.sushe.po.Visitor;
import com.sushe.po.export.VisitorExport;
import com.sushe.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @program: dormitorySystem
 * @description: 访客管理
 * @author: Joyrocky
 * @create: 2019-05-14 12:37
 **/
@Controller
public class VisitorController {
    //依赖注入
    @Autowired
    private VisitorService visitorService;
    /**
     * 分页查询
     * pageIndex 当前页码
     * pageSize  显示条数
     */
    @RequestMapping(value = "/findVisitor")
    public String findVisitor(Visitor visitor, Model model) {

        model.addAttribute("pageInfo",visitorService.findPageInfo(visitor));
        model.addAttribute("v_name",visitor.getV_name());
        return "visitor/visitor_list";
    }

    /**
     * 导出Excel
     */
    @RequestMapping(value = "/exportvisitorlist", method = RequestMethod.POST)
    @ResponseBody
    @ExportAs(VisitorExport.class)
    public List<Visitor> exportVisitor(){
        List<Visitor> visitorList = visitorService.getAll();
        return visitorList;
    }

    /**
     * 添加学生信息
     */

    @RequestMapping(value = "/addVisitor" ,method = RequestMethod.POST)
    @ResponseBody
    public String addStudent(@RequestBody Visitor visitor) {
        int v = visitorService.addVisitor(visitor);
        return "visitor_list";
    }

}

