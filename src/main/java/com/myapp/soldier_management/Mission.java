package com.myapp.soldier_management;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

@XmlRootElement(name = "mission") 
@XmlAccessorType(XmlAccessType.FIELD) 
public class Mission {

    @XmlElement(name = "mission_id") 
    @JsonProperty("mission_id")
    private int missionId;

    @XmlElement(name = "mission_name")
    @JsonProperty("mission_name")
    private String missionName;

    @XmlElement(name = "start_date")
    @JsonProperty("start_date")
    @JsonFormat(shape = JsonFormat.Shape.toString(), pattern = "yyyy-MM-dd")
    private Date startDate;

    @XmlElement(name = "end_date")
    @JsonProperty("end_date")
    @JsonFormat(shape = JsonFormat.Shape.toString(), pattern = "yyyy-MM-dd")
    private Date endDate;

    @XmlElement(name = "location")
    @JsonProperty("location")
    private String location;

    @XmlElement(name = "objective")
    @JsonProperty("objective")
    private String objective;


 
    public Mission() {}


    public Mission(int missionId, String missionName, Date startDate, Date endDate, String location, String objective) {
        this.missionId = missionId;
        this.missionName = missionName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.objective = objective;
    }


    public int getMissionId() { return missionId; }
    public void setMissionId(int missionId) { this.missionId = missionId; }

    public String getMissionName() { return missionName; }
    public void setMissionName(String missionName) { this.missionName = missionName; }

    public Date getStartDate() { return startDate; }
    public void setStartDate(Date startDate) { this.startDate = startDate; }

    public Date getEndDate() { return endDate; }
    public void setEndDate(Date endDate) { this.endDate = endDate; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getObjective() { return objective; }
    public void setObjective(String objective) { this.objective = objective; }
}
