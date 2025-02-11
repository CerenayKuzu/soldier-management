package com.myapp.soldier_management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoldierService {

    private final SoldierMapper soldierMapper;

    @Autowired
    public SoldierService(SoldierMapper soldierMapper) {
        this.soldierMapper = soldierMapper;
    }

    public void addSoldier(Soldier soldier) {
        soldierMapper.insertSoldier(soldier);
    }

    public Soldier getSoldierById(int soldierId) {
        return soldierMapper.getSoldierById(soldierId);
    }

    public List<Soldier> getAllSoldiers() {
        return soldierMapper.getAllSoldiers();
    }

    public void updateSoldier(Soldier soldier) {
        soldierMapper.updateSoldier(soldier);
    }

    public void deleteSoldier(int soldierId) {
        soldierMapper.deleteSoldier(soldierId);
    }
}
