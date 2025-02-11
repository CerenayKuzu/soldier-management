package com.myapp.soldier_management;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "rank")
@XmlAccessorType(XmlAccessType.FIELD)
public class Rank {

    @XmlElement(name = "rank_id") 
    @JsonProperty("rank_id")
    private int rankId;

    @XmlElement(name = "rank_name")
    @JsonProperty("rank_name")
    private String rankName;

    @XmlElement(name = "rank_level")
    @JsonProperty("rank_level")
    private int rankLevel;


    public Rank() {}


    public Rank(int rankId, String rankName, int rankLevel) {
        this.rankId = rankId;
        this.rankName = rankName;
        this.rankLevel = rankLevel;
    }


    public int getRankId() { return rankId; }
    public void setRankId(int rankId) { this.rankId = rankId; }

    public String getRankName() { return rankName; }
    public void setRankName(String rankName) { this.rankName = rankName; }

    public int getRankLevel() { return rankLevel; }
    public void setRankLevel(int rankLevel) { this.rankLevel = rankLevel; }
}
