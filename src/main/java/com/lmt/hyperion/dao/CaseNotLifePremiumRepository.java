package com.lmt.hyperion.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CaseNotLifePremiumRepository extends JpaRepository <CaseNotLifePremium, String> {
    @Query("SELECT SUM(premiumHt) FROM CaseNotLifePremium WHERE slipePrimeId=?1")
    Float totalPremium(String slipePrimeId);

    List<CaseNotLifePremium> findBySlipePrimeId(String id);
}
