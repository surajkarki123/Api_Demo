package com.demo.DemoProject.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.DemoProject.model.User;
import com.demo.DemoProject.processor.DemoProcessor;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/demo")
@AllArgsConstructor
public class DemoController {

	private DemoProcessor demoProcessor;

	@GetMapping
	private List<User> getUserDetails() {
		return demoProcessor.process();
	}

}
