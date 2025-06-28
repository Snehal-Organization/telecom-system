package com.telecom.plan_service.service;

import java.util.List;
import java.util.Optional;

import com.telecom.plan_service.dto.PlanDTO;
import com.telecom.plan_service.exception.ResourceNotFoundException;

public interface PlanService {
    PlanDTO createPlan(PlanDTO planDTO);
    List<PlanDTO> getAllPlans();
    Optional<PlanDTO> getPlanById(Long id);
    PlanDTO updatePlan(Long planId, PlanDTO planDTO) throws ResourceNotFoundException;
    void deletePlan(Long planId);
}