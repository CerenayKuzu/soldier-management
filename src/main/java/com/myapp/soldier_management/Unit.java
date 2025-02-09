package com.myapp.soldier_management;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "unit")
@XmlAccessorType(XmlAccessType.FIELD)
public class Unit {

    @XmlElement(name = "unit_id")
    private int unitId;

    @XmlElement(name = "unit_name")
    private String unitName;

    @XmlElement(name = "unit_type")
    private String unitType;

    @XmlElement(name = "location")
    private String location;

    // Getters
    public int getUnitId() { return unitId; }
    public String getUnitName() { return unitName; }
    public String getUnitType() { return unitType; }
    public String getLocation() { return location; }
}
