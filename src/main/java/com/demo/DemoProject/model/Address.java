package com.demo.DemoProject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Address {

	private String street;
	private String suite;
	private String city;
	private String zipcode;
	private GeoLocation geo;
}
