package com.myapp.soldier_management;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "rank")
@XmlAccessorType(XmlAccessType.FIELD)
public class Rank {

    @XmlElement(name = "rank_id")
    private int rankId;

    @XmlElement(name = "rank_name")
    private String rankName;

    @XmlElement(name = "rank_level")
    private int rankLevel;

    // Getters
    public int getRankId() { return rankId; }
    public String getRankName() { return rankName; }
    public int getRankLevel() { return rankLevel; }
}
