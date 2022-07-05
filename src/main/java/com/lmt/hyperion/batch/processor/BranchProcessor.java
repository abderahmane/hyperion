package com.lmt.hyperion.batch.processor;

import com.lmt.hyperion.dao.*;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class BranchProcessor implements ItemProcessor<Branch, Branch> {

    @Override
    public Branch process(Branch branch) {
        branch.setId(branch.get_id().getOid());

        if(branch.getParentBranchId() != null){
            Branch branch2 = new Branch();
            branch2.setId(branch.getParentBranchId().getOid());
            branch.setBranch(branch2);
        }
        branch.setAliass(String.join(",", branch.getAlias()));

        return branch;
    }
}
