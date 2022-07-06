package com.lmt.hyperion.dao;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @NoArgsConstructor @ToString @AllArgsConstructor
public class ModelSaerch {

    private String id;
    private String branch;

    @JsonProperty("validation_status")
    private String validationStatus;

    @JsonProperty("confirmation_status")
    private String confirmationStatus;


    private String reference;
    private String country;
    private String cedants;

    @JsonProperty("publish_date")
    private String publishDate = "";

    private Float rec;

    private int page;
    private int size;

}
