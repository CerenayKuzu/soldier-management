package com.myapp.soldier_management;

import jakarta.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "military_database")
@XmlAccessorType(XmlAccessType.FIELD)
public class MilitaryDatabase {
    
    @XmlElementWrapper(name = "soldiers")
    @XmlElement(name = "soldier")
    private List<Soldier> soldiers;

    @XmlElementWrapper(name = "ranks")
    @XmlElement(name = "rank")
    private List<Rank> ranks;

    @XmlElementWrapper(name = "units")
    @XmlElement(name = "unit")
    private List<Unit> units;

    @XmlElementWrapper(name = "departments")
    @XmlElement(name = "department")
    private List<Department> departments;

    @XmlElementWrapper(name = "missions")
    @XmlElement(name = "mission")
    private List<Mission> missions;

    // Getters
    public List<Soldier> getSoldiers() { return soldiers; }
    public List<Rank> getRanks() { return ranks; }
    public List<Unit> getUnits() { return units; }
    public List<Department> getDepartments() { return departments; }
    public List<Mission> getMissions() { return missions; }
}