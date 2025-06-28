package com.telecom.plan_service.entity;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import lombok.*;

@Entity
@Table(name = "plans")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlanEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long planId;
	private String planName;
	private String type;
	private double price;
	private int validityInDays;

	public Long getPlanId() {
		return planId;
	}

	public void setPlanId(Long planId) {
		this.planId = planId;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getValidityInDays() {
		return validityInDays;
	}

	public void setValidityInDays(int validityInDays) {
		this.validityInDays = validityInDays;
	}

	@Override
	public String toString() {
		return "PlanEntity [planId=" + planId + ", planName=" + planName + ", type=" + type + ", price=" + price
				+ ", validityInDays=" + validityInDays + "]";
	}

	public PlanEntity(Long planId, String planName, String type, double price, int validityInDays) {
		super();
		this.planId = planId;
		this.planName = planName;
		this.type = type;
		this.price = price;
		this.validityInDays = validityInDays;
	}

	public PlanEntity() {

	}
}
