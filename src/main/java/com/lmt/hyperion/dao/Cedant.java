package com.lmt.hyperion.dao;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data @NoArgsConstructor @ToString
public class Cedant extends AbstractEntity{
    @Id
    private String id;

    private String code;
    private String name;

    private String color1;
    private String color2;

    private String contact;
    private String email;

    @JsonProperty("estimation_type")
    private String estimationType;
    private String logo;
    @JsonProperty("benefit_percentage")
    private Float benefitPercentage;

    @JsonProperty("reinsurances_id")
    @Transient
    private OID reinsurancesId;
    @JsonProperty("types_cedants_id")
    @Transient
    private OID typesCedantsId;

    private String reinsuranceId;
    private String typeCedantId;


    @JsonProperty("currencies_id")
    @Transient
    private OID currenciesId;

    @JsonProperty("region_id")
    @Transient
    private OID regionId;

    @JsonProperty("groups_cedants_id")
    @Transient
    private OID groupsCedantsId;

    @JsonProperty("countries_id")
    @Transient
    private OID countriesId;

    @ManyToOne()
    @JoinColumn(name="region_id")
    private Region region;

    @ManyToOne()
    @JoinColumn(name="country_id")
    private Country country;

    @ManyToOne()
    @JoinColumn(name="group_cedant_id")
    private GroupCedant groupCedant;



}
