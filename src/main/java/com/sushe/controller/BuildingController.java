package com.sushe.controller;


import com.sushe.po.Building;
import com.sushe.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

}
