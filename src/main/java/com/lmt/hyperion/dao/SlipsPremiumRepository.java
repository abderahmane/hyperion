package com.lmt.hyperion.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SlipsPremiumRepository extends JpaRepository <SlipsPremium, String> {
}
