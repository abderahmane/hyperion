package com.lmt.hyperion.dao;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data @NoArgsConstructor @ToString
public class CaseNotLifePremium extends AbstractEntity{

    @Id
    private String id;

    private String name;

    @JsonProperty("active_status")
    private boolean activeStatus;
    private String branch;
    @JsonProperty("case_validation_status")
    private String caseValidationStatus;
    @JsonProperty("case_variant")
    private String case_variant;
    private String category;

    @JsonProperty("commission_cession")
    private Double commissionCession;
    @JsonProperty("commission_refunded")
    private Double commissionRefunded;
    @JsonProperty("date_effective")
    private String dateEffective;
    @JsonProperty("date_transaction")
    private String dateTransaction;
    private String deadline;
    private String nature_risque_id;
    private String policy_number;
    private Double insured_capital;
    private Double invoiced_premium;
    private Double net_amount;
    private Double paid_commission;
    private Double part_cedant_coass;
    private Double premium_ceded;
    private Double premium_ht;
    private Double prime_net_ceded;

    @JsonProperty("branches_id")
    @Transient
    private OID branchesId;

    @JsonProperty("slipes_prime_id")
    @Transient
    private OID slipesPrimeId;

    @JsonProperty("sub_branches_id")
    @Transient
    private OID subBranchesId;



    @JsonProperty("cedants_id")
    @Transient
    private OID cedantsId;

}
