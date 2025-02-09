package com.myapp.soldier_management;

import javax.xml.bind.annotation.*;
import java.util.Date;

@XmlRootElement(name = "soldier") 
@XmlAccessorType(XmlAccessType.FIELD)
public class soldier {

    @XmlAttribute(name = "id")
    private int id;

    @XmlElement(name = "firstName") 
    private String firstName;

    @XmlElement(name = "lastName")
    private String lastName;

    @XmlElement(name = "enlistmentDate")
    private Date enlistmentDate;


    public soldier() {}

    public soldier(int id, String firstName, String lastName, Date enlistmentDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.enlistmentDate = enlistmentDate;
    }

    // Getters ve Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public Date getEnlistmentDate() { return enlistmentDate; }
    public void setEnlistmentDate(Date enlistmentDate) { this.enlistmentDate = enlistmentDate; }
}
