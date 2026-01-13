package com.sushe.controller;


import com.sushe.po.Building;
import com.sushe.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BuildingController {
    @Autowired
    private BuildingService buildingService;

    @RequestMapping(method = RequestMethod.GET,value = "/findAllBuildings")
    @ResponseBody
    public List<Building> findAllBuildings() {
        return buildingService.findBuildings();
    }

    /**
     * 根据宿舍楼名称查询对应的管理员姓名
     * 显式指定 UTF-8，避免中文被浏览器解码成问号
     */
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/findAdminNameByBuilding",
            produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String findAdminNameByBuilding(@RequestParam("d_dormbuilding") String d_dormbuilding) {
        return buildingService.findAdminNameByBuilding(d_dormbuilding);
    }

}
