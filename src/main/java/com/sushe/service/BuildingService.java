package com.sushe.service;

import com.sushe.po.Building;

import java.util.List;

public interface BuildingService {
    Building findManagerBuilding(Integer a_id);

    List<Building> findBuildings();

    /**
     * 根据宿舍楼名称查询对应管理员姓名
     */
    String findAdminNameByBuilding(String d_dormbuilding);
}
