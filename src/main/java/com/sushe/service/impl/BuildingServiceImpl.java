package com.sushe.service.impl;

import com.sushe.dao.BuildingDao;
import com.sushe.po.Building;
import com.sushe.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class BuildingServiceImpl implements BuildingService {

    @Autowired
    private BuildingDao buildingDao;

    @Override
    public List<Building> findManagerBuilding(Integer a_id) {
        return buildingDao.findManagerBuilding(a_id);
    }

    @Override
    public List<Building> findBuildings() {
        return buildingDao.findManagerBuilding(0);
    }
}
