package com.lmt.hyperion.dao;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import java.util.List;

@Entity
@Data @NoArgsConstructor @ToString
public class Region extends AbstractEntity{

    @Id
    private String id;

    private String code;
    private String name;


    @OneToMany(mappedBy="region")
    private List<Country> countries;

}
