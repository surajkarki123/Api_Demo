package com.demo.DemoProject.model;

import java.math.BigInteger;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Post {

	private BigInteger id;
	private BigInteger userId;
	private String title;
	private String body;
}
