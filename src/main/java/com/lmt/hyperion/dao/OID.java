package com.lmt.hyperion.dao;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OID {
    @JsonProperty("$oid")
    String oid;
}
