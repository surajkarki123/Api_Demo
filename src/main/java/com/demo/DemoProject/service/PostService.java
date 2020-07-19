package com.demo.DemoProject.service;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.DemoProject.model.Post;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PostService {

	private static final String URL = "http://jsonplaceholder.typicode.com/posts";
	private RestTemplate restTemplate;

	public List<Post> fetchPosts() {
		List<Post> posts = null;

		try {
			ResponseEntity<List<Post>> response = restTemplate.exchange(URL, HttpMethod.GET, null,
					new ParameterizedTypeReference<List<Post>>() {
					});

			if (response != null) {
				posts = response.getBody();
			}
		} catch (Exception e) {
			System.out.println("Exception ovccured while calling the post service. Exp Msg : " + e.getMessage());
		}
		return posts;
	}
}
