package com.myapp.soldier_management;

import javax.xml.bind.annotation.*;
import java.util.Date;
import java.util.List;

@XmlRootElement(name = "soldier") 
@XmlAccessorType(XmlAccessType.FIELD) 
public class soldier {

    @XmlAttribute(name = "id") 
    @JsonProperty("soldier_id") 
    private int soldierId;

    @XmlElement(name = "firstName") 
    @JsonProperty("first_name") 
    private String firstName;

    @XmlElement(name = "lastName")
    @JsonProperty("last_name")
    private String lastName;

    @XmlElement(name = "dob")
    @JsonProperty("dob")
    @JsonFormat(shape = JsonFormat.Shape.toString(), pattern = "yyyy-MM-dd") 
    private Date dob;

    @XmlElement(name = "rank")
    @JsonProperty("rank")
    private Rank rank;

    @XmlElement(name = "unit")
    @JsonProperty("unit")
    private Unit unit;

    @XmlElement(name = "department")
    @JsonProperty("department")
    private Department department;

    @XmlElementWrapper(name = "missions") // XML'de <missions> etiketi oluşturur
    @XmlElement(name = "mission") // XML içinde her öğe <mission> olarak adlandırılır
    @JsonProperty("missions")
    private List<Mission> missions;

    // Boş Constructor (JAXB için gerekli)
    public soldier() {}

    // Parametreli Constructor
    public soldier(int soldierId, String firstName, String lastName, Date dob, Rank rank, Unit unit, Department department, List<Mission> missions) {
        this.soldierId = soldierId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.rank = rank;
        this.unit = unit;
        this.department = department;
        this.missions = missions;
    }

    // Getters & Setters
    public int getSoldierId() { return soldierId; }
    public void setSoldierId(int soldierId) { this.soldierId = soldierId; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public Date getDob() { return dob; }
    public void setDob(Date dob) { this.dob = dob; }

    public Rank getRank() { return rank; }
    public void setRank(Rank rank) { this.rank = rank; }

    public Unit getUnit() { return unit; }
    public void setUnit(Unit unit) { this.unit = unit; }

    public Department getDepartment() { return department; }
    public void setDepartment(Department department) { this.department = department; }

    public List<Mission> getMissions() { return missions; }
    public void setMissions(List<Mission> missions) { this.missions = missions; }
}
