package com.telecom.plan_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telecom.plan_service.dto.PlanDTO;
import com.telecom.plan_service.exception.ResourceNotFoundException;
import com.telecom.plan_service.service.PlanService;

@RestController
@RequestMapping("/api/plans")
public class PlanController {

	@Autowired
	private PlanService plansService;

	@GetMapping
	public ResponseEntity<List<PlanDTO>> getAllPlans() {
		return ResponseEntity.ok(plansService.getAllPlans());
	}

	@GetMapping("/{planId}")
	public ResponseEntity<PlanDTO> getPlanId(@PathVariable Long planId) {
		return plansService.getPlanById(planId).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<PlanDTO> createPlan(@RequestBody PlanDTO planDTO) {
	    PlanDTO created = plansService.createPlan(planDTO);
	    return ResponseEntity.status(201).body(created);
	}

	@PutMapping("/{id}")
	public ResponseEntity<PlanDTO> updatePlan(@PathVariable Long id, @RequestBody PlanDTO planDTO) throws ResourceNotFoundException {
		PlanDTO updated = plansService.updatePlan(id, planDTO);
		return ResponseEntity.ok(updated);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePlan(@PathVariable Long id) {
		plansService.deletePlan(id);
		return ResponseEntity.noContent().build();

	}
}
