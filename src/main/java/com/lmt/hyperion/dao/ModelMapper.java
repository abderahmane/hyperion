package com.lmt.hyperion.dao;


import org.mapstruct.Mapper;


@Mapper(componentModel = "spring", uses = {})
public interface ModelMapper extends EntityMapper<Model, SlipsPremium> {

    default SlipsPremium fromId(String id) {
        if (id == null) {
            return null;
        }
        SlipsPremium slipsPremium = new SlipsPremium();
        slipsPremium.setId(id);
        return slipsPremium;
    }
}
