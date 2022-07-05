package com.lmt.hyperion.dao;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data @NoArgsConstructor @ToString
public class GroupCedant extends AbstractEntity{

    @Id
    private String id;

    private String name;


    @OneToMany(mappedBy="groupCedant")
    private List<Cedant> cedants;

}
