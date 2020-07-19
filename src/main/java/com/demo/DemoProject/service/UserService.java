package com.demo.DemoProject.service;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.DemoProject.model.User;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {
	private static final String URL = "https://jsonplaceholder.typicode.com/users";
	private RestTemplate restTemplate;

	public List<User> fetchUsers() {
		List<User> users = null;
		try {
			ResponseEntity<List<User>> response = restTemplate.exchange(URL, HttpMethod.GET, null,
					new ParameterizedTypeReference<List<User>>() {
					});

			if (response != null) {
				users = response.getBody();
			}
		} catch (Exception e) {
			System.out.println("Exception ovccured while calling the user service. Exp Msg : " + e.getMessage());
		}
		return users;
	}
}
