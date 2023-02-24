package com.masai.model;

import jakarta.persistence.Entity;
import lombok.Data;


@Data
public class PropertyCriteria {
	private String config;
	private String offer;
	private String city;
	private double minCost;
	private double maxcost;
	

}
