package com.cg.ofr.dto;

import org.springframework.stereotype.Component;

import com.cg.ofr.entities.FlatAddress;
@Component
public class FlatDto {
	private Integer flatId;
	private Double cost;
	private String availability;
	private FlatAddress flatAddress;
	
	public FlatDto() {}
	
	public FlatDto(Integer flatId, Double cost, String availability, FlatAddress flatAddress) {
		super();
		this.flatId = flatId;
		this.cost = cost;
		this.availability = availability;
		this.flatAddress = flatAddress;
	}

	public Integer getFlatId() {
		return flatId;
	}
	public void setFlatId(Integer flatId) {
		this.flatId = flatId;
	}
	public Double getCost() {
		return cost;
	}
	public  void setCost(Double cost) {
		this.cost = cost;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	public FlatAddress getFlatAddress() {
		return flatAddress;
	}
	public void setFlatAddress(FlatAddress flatAddress) {
		this.flatAddress = flatAddress;
	}

	@Override
	public String toString() {
		return "FlatDto [flatId=" + flatId + ", cost=" + cost + ", availability=" + availability + ", flatAddress="
				+ flatAddress + "]";
	}
	
   
}

