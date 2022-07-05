package com.lmt.hyperion.dao;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ODate {
    @JsonProperty("$date")
    String date;
}
