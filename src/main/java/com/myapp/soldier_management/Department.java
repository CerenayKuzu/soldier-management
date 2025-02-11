package com.myapp.soldier_management;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "department") 
@XmlAccessorType(XmlAccessType.FIELD) 
public class Department {

    @XmlElement(name = "department_id") 
    @JsonProperty("department_id") 
    private int departmentId;

    @XmlElement(name = "department_name")
    @JsonProperty("department_name")
    private String departmentName;

    @XmlElement(name = "description")
    @JsonProperty("description")
    private String description;


    public Department() {}


    public Department(int departmentId, String departmentName, String description) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.description = description;
    }

    // Getters & Setters
    public int getDepartmentId() { return departmentId; }
    public void setDepartmentId(int departmentId) { this.departmentId = departmentId; }

    public String getDepartmentName() { return departmentName; }
    public void setDepartmentName(String departmentName) { this.departmentName = departmentName; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
