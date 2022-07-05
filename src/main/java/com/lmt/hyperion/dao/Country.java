package com.lmt.hyperion.dao;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data @NoArgsConstructor @ToString
public class Country extends AbstractEntity{
    @Id
    private String id;

    private String code;
    private String name;
    @Transient
    private OID _id;

    @JsonProperty("regions_id")
    @Transient
    private OID regionId;

    @ManyToOne()
    @JoinColumn(name="region_id")
    private Region region;



}
