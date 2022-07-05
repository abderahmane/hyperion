package com.lmt.hyperion.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Primary
@Repository
public interface RegionRepository extends JpaRepository <Region, String> {
}
