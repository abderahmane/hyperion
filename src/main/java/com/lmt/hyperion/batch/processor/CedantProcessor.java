package com.lmt.hyperion.batch.processor;

import com.lmt.hyperion.dao.Cedant;
import com.lmt.hyperion.dao.Country;
import com.lmt.hyperion.dao.GroupCedant;
import com.lmt.hyperion.dao.Region;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class CedantProcessor implements ItemProcessor<Cedant, Cedant> {

    @Override
    public Cedant process(Cedant cedant) {
        cedant.setId(cedant.get_id().getOid());
        Region region = new Region();
        region.setId(cedant.getRegionId().getOid());
        cedant.setRegion(region);

        Country country = new Country();
        country.setId(cedant.getCountriesId().getOid());
        cedant.setCountry(country);

        GroupCedant groupCedant = new GroupCedant();
        groupCedant.setId(cedant.getGroupsCedantsId().getOid());
        cedant.setGroupCedant(groupCedant);

        cedant.setReinsuranceId(cedant.getReinsurancesId().getOid());
        cedant.setTypeCedantId(cedant.getTypesCedantsId().getOid());
        return cedant;
    }
}
