package com.telecom.plan_service.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telecom.plan_service.dto.PlanDTO;
import com.telecom.plan_service.entity.PlanEntity;
import com.telecom.plan_service.exception.ResourceNotFoundException;
import com.telecom.plan_service.repository.PlanRepository;


@Service
public class PlanServiceImpl implements PlanService {

	@Autowired
	private PlanRepository planRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public PlanDTO createPlan(PlanDTO planDTO) {
		PlanEntity entity = modelMapper.map(planDTO, PlanEntity.class);
		PlanEntity saved = planRepository.save(entity);
		return modelMapper.map(saved, PlanDTO.class);
	}

	@Override
	public List<PlanDTO> getAllPlans() {
		return planRepository.findAll().stream().map(plan -> modelMapper.map(plan, PlanDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public Optional<PlanDTO> getPlanById(Long planId) {
		// TODO Auto-generated method stub
		return planRepository.findById(planId).map(plan -> modelMapper.map(plan, PlanDTO.class));
	}

	@Override
	public PlanDTO updatePlan(Long planId, PlanDTO planDTO) throws ResourceNotFoundException {
	    PlanEntity existing = planRepository.findById(planId)
	            .orElseThrow(() -> new ResourceNotFoundException("Plan not found with ID: " + planId));

	    planDTO.setPlanId(planId);
	    PlanEntity updated = modelMapper.map(planDTO, PlanEntity.class);
	    PlanEntity saved = planRepository.save(updated);
	    
	    return modelMapper.map(saved, PlanDTO.class);
	}

	@Override
	public void deletePlan(Long planId) {
		planRepository.deleteById(planId);
	}

}
