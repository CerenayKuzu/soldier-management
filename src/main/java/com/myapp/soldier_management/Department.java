package com.myapp.soldier_management;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "department")
@XmlAccessorType(XmlAccessType.FIELD)
public class Department {

    @XmlElement(name = "department_id")
    private int departmentId;

    @XmlElement(name = "department_name")
    private String departmentName;

    @XmlElement(name = "description")
    private String description;

    // Getters
    public int getDepartmentId() { return departmentId; }
    public String getDepartmentName() { return departmentName; }
    public String getDescription() { return description; }
}
