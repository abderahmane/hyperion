package com.lmt.hyperion.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
@Data @NoArgsConstructor @ToString @AllArgsConstructor
public class SlipsPremium extends AbstractEntity{

    @Id
    private String id;
    @JsonProperty("approval_status")
    private String approvalStatus;

    @JsonProperty("is_paid")
    private boolean isPaid;
    private String branch;
    @JsonProperty("confirmation_status")
    @JsonView(RecView.class)
    private String confirmationStatus;

    @JsonProperty("confirmation_date")
    private String confirmationDate;
    @JsonProperty("edited_period")
    private String editedPeriod;
    @JsonProperty("file_url")
    private String fileUrl;
    @JsonProperty("published_date")
    private String publishedDate;
    @JsonView(RecView.class)
    private String reference;

    @JsonProperty("invoice_premium_total")
    private Double invoicePremiumTotal;
    @JsonProperty("commission_refunded")
    private Double commissionRefunded;

    @JsonProperty("validation_status")
    @JsonView(RecView.class)
    private String validationStatus;

    @JsonProperty("validation_date")
    private String validationDate;
    @JsonProperty("slip_type")
    private String slip_type;
    @JsonProperty("nature_risque_id")
    private String natureRisqueId;
    @JsonProperty("policy_number")
    private String policyNumber;
    @JsonProperty("insured_capital")
    private Double insuredCapital;
    @JsonProperty("invoiced_premium")
    private Double invoicedPremium;

    @JsonProperty("commission_refunded_total")
    private Double commissionRefundedTotal;
    @JsonProperty("update_progress")
    private Integer updateProgress;
    @JsonProperty("update_status")
    private Integer updateStatus;
    @JsonProperty("warnings_saved")
    private Long warningSaved;
    @JsonProperty("net_amount_total")
    private Double netAmountTotal;

    @JsonProperty("reinsurances_id")
    @Transient
    private OID reinsurancesId;

    @JsonProperty("cedants_type_id")
    @Transient
    private OID cedantsTypeId;

    @JsonProperty("cedants_id")
    @Transient
    private OID cedantsId;

    @JsonProperty("user_cedant_id")
    @Transient
    private OID userCedantId;
    @JsonIgnore
    @Transient
    private Object [] warnings;

}
