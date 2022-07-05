package com.lmt.hyperion.batch.processor;

import com.lmt.hyperion.dao.GroupCedant;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class GroupCedantProcessor implements ItemProcessor<GroupCedant, GroupCedant> {

    @Override
    public GroupCedant process(GroupCedant groupCedant) {
        groupCedant.setId(groupCedant.get_id().getOid());
        return groupCedant;
    }
}
