package com.telecom.plan_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telecom.plan_service.entity.PlanEntity;

@Repository
public interface PlanRepository extends JpaRepository<PlanEntity, Long> {
}