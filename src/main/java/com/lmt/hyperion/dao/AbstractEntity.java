package com.lmt.hyperion.dao;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Transient;
import java.io.Serializable;

@Data
public class AbstractEntity  implements Serializable {
    @Transient
    private OID _id;

    @JsonProperty("updated_at")
    @Transient
    private ODate updatedAt;

    @Transient
    @JsonProperty("created_at")
    private ODate createdAt;

    @Transient
    @JsonProperty("deleted_at")
    private ODate deletedAt;
}
