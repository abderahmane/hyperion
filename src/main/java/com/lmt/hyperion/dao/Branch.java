package com.lmt.hyperion.dao;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data @NoArgsConstructor @ToString
public class Branch extends AbstractEntity{

    @Id
    private String id;

    private String name;

    @JsonProperty("is_parent")
    private boolean isParent;
    private String type;
    private String code;
    private Integer status;

    @JsonProperty("parent_branch_id")
    @Transient
    private OID parentBranchId;


    @Transient
    private String[] alias;

    @Transient
    private String aliass;


    @ManyToOne()
    @JoinColumn(name="branch_id")
    private Branch branch;

    @OneToMany(mappedBy="groupCedant")
    private List<Cedant> cedants;

}
