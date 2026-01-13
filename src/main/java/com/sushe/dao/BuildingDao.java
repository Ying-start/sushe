package com.sushe.dao;

import com.sushe.po.Building;

import java.util.List;

public interface BuildingDao {
    public List<Building> findManagerBuilding(Integer a_id);
}
