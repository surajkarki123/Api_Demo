package com.demo.DemoProject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Company {

	private String name;
	private String catchPhrase;
	private String bs;
}
