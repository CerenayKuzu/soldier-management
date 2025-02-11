package com.myapp.soldier_management;

import org.apache.ibatis.annotations.*;

import java.util.List;

public interface SoldierMapper {
    
    @Insert("INSERT INTO soldiers(soldier_id, first_name, last_name, dob, enlistment_date, rank_id, unit_id, department_id) VALUES(#{soldierId}, #{firstName}, #{lastName}, #{dob}, #{enlistmentDate}, #{rank.rankId}, #{unit.unitId}, #{department.departmentId})")
    void insertSoldier(Soldier soldier);
    
    @Select("SELECT * FROM soldiers WHERE soldier_id = #{soldierId}")
    Soldier getSoldierById(int soldierId);
    
    @Select("SELECT * FROM soldiers")
    List<Soldier> getAllSoldiers();
    
    @Update("UPDATE soldiers SET first_name=#{firstName}, last_name=#{lastName}, dob=#{dob}, enlistment_date=#{enlistmentDate} WHERE soldier_id = #{soldierId}")
    void updateSoldier(Soldier soldier);
    
    @Delete("DELETE FROM soldiers WHERE soldier_id = #{soldierId}")
    void deleteSoldier(int soldierId);
}
