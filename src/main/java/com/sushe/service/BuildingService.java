package com.sushe.service;

import com.sushe.po.Building;

import java.util.List;

public interface BuildingService {
    List<Building> findManagerBuilding(Integer a_id);

    List<Building> findBuildings();
}
