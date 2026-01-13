package com.sushe.dao;

import com.sushe.po.Building;

import java.util.List;

public interface BuildingDao {
    Building findBuildingByAdminId(Integer a_id);
    List<Building> findAllBuildings();

    /**
     * 根据宿舍楼名称查询对应的管理员姓名
     */
    String findAdminNameByBuilding(String d_dormbuilding);
}
