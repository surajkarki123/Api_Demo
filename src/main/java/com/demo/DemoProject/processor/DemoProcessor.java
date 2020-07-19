package com.demo.DemoProject.processor;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.demo.DemoProject.model.Post;
import com.demo.DemoProject.model.User;
import com.demo.DemoProject.service.PostService;
import com.demo.DemoProject.service.UserService;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class DemoProcessor {

	private UserService userService;
	private PostService postService;

	public List<User> process() {

		List<User> users = null;
		List<Post> posts = null;

		CompletableFuture<List<User>> userServiceFuture = CompletableFuture.supplyAsync(() -> userService.fetchUsers());
		CompletableFuture<List<Post>> postServiceFuture = CompletableFuture.supplyAsync(() -> postService.fetchPosts());

		try {
			if (Objects.nonNull(userServiceFuture.get()) && Objects.nonNull(postServiceFuture.get())) {
				users = userServiceFuture.get();
				posts = postServiceFuture.get();

				if (!CollectionUtils.isEmpty(users) && !CollectionUtils.isEmpty(posts)) {
					mapUserPost(users, posts);
				}
			}
		} catch (InterruptedException | ExecutionException e) {
			System.out.println("Exception occured while fetch users/post info. Error Msg : " + e.getMessage());
		}
		return users;
	}

	private void mapUserPost(List<User> users, List<Post> posts) {
		users.stream().forEach(user -> {
			Post userPost = fetchUserPost(user, posts);
			if (Objects.nonNull(userPost)) {
				user.setTitle(userPost.getTitle());
				user.setBody(userPost.getBody());
			}
		});
	}

	private Post fetchUserPost(User user, List<Post> posts) {
		Optional<Post> tempPost = posts.stream().filter(post -> post.getId().compareTo(user.getId()) == 0)
				.findFirst();
		return tempPost.isPresent() ? tempPost.get() : null;
	}
}
