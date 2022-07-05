package com.lmt.hyperion.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CaseNotLifePremiumRepository extends JpaRepository <CaseNotLifePremium, String> {
    @Query("SELECT SUM(premiumHt) FROM CaseNotLifePremium WHERE slipePrimeId=?1")
    Float totalPremium(String slipePrimeId);
}
