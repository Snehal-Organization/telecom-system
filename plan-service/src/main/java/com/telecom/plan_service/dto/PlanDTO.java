package com.telecom.plan_service.dto;

public class PlanDTO {
	private Long PlanId;
	private String planName;
	private String type;
	private double price;
	private int validityInDays;

	public PlanDTO() {
	}

	public Long getPlanId() {
		return PlanId;
	}

	public void setPlanId(Long planId) {
		PlanId = planId;
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
		return "PlanDTO [PlanId=" + PlanId + ", planName=" + planName + ", type=" + type + ", price=" + price
				+ ", validityInDays=" + validityInDays + "]";
	}

}