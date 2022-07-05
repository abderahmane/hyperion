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
    private Float commissionCession;
    @JsonProperty("commission_refunded")
    private Float commissionRefunded;
    @JsonProperty("date_effective")
    private String dateEffective;
    @JsonProperty("date_transaction")
    private String dateTransaction;
    private String deadline;
    @JsonProperty("nature_risque_id")
    private String natureRisqueId ;
    @JsonProperty("policy_number")
    private String policyNumber;
    @JsonProperty("insured_capital")
    private Float insuredCapital;
    @JsonProperty("invoiced_premium")
    private Float invoicedPremium;
    @JsonProperty("net_amount")
    private Float netAmount;
    @JsonProperty("paid_commission")
    private Float paidCommission;
    @JsonProperty("part_cedant_coass")
    private Float partCedantCoass;
    @JsonProperty("premium_ceded")
    private Float premiumCeded;

    @JsonProperty("premium_ht")
    private Float premiumHt;
    private Float prime_net_ceded;

    @JsonProperty("branches_id")
    @Transient
    private OID branchesId;

    private String brancheId;

    @JsonProperty("slipes_prime_id")
    @Transient
    private OID slipesPrimeId;

    private String slipePrimeId;

    @JsonProperty("sub_branches_id")
    @Transient
    private OID subBranchesId;


    private String country;

    private String cedants;

    @JsonProperty("cedants_id")
    @Transient
    private OID cedantsId;

}
