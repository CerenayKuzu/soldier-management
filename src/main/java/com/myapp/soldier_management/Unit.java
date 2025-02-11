package com.myapp.soldier_management;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "unit")
@XmlAccessorType(XmlAccessType.FIELD)
public class Unit {

    @XmlElement(name = "unit_id")
    @JsonProperty("unit_id") 
    private int unitId;

    @XmlElement(name = "unit_name")
    @JsonProperty("unit_name")
    private String unitName;

    @XmlElement(name = "unit_type")
    @JsonProperty("unit_type")
    private String unitType;

    @XmlElement(name = "location")
    @JsonProperty("location")
    private String location;


    public Unit() {}


    public Unit(int unitId, String unitName, String unitType, String location) {
        this.unitId = unitId;
        this.unitName = unitName;
        this.unitType = unitType;
        this.location = location;
    }

    // Getters & Setters
    public int getUnitId() { return unitId; }
    public void setUnitId(int unitId) { this.unitId = unitId; }

    public String getUnitName() { return unitName; }
    public void setUnitName(String unitName) { this.unitName = unitName; }

    public String getUnitType() { return unitType; }
    public void setUnitType(String unitType) { this.unitType = unitType; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
}
