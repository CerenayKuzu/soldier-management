package com.myapp.soldier_management;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "mission")
@XmlAccessorType(XmlAccessType.FIELD)
public class Mission {

    @XmlElement(name = "mission_id")
    private int missionId;

    @XmlElement(name = "mission_name")
    private String missionName;

    @XmlElement(name = "start_date")
    private String startDate;

    @XmlElement(name = "end_date")
    private String endDate;

    @XmlElement(name = "location")
    private String location;

    @XmlElement(name = "objective")
    private String objective;

    // Getters
    public int getMissionId() { return missionId; }
    public String getMissionName() { return missionName; }
    public String getStartDate() { return startDate; }
    public String getEndDate() { return endDate; }
    public String getLocation() { return location; }
    public String getObjective() { return objective; }
}
