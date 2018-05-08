package com.reidconner.contractconsumer.service;

import com.reidconner.contractconsumer.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {

	private RestTemplate restTemplate;

	@Autowired
	public UserService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public User getUserById(String id) {
		ResponseEntity<User> response = restTemplate.getForEntity(
				"http://localhost:6565/users/" + id,
				User.class
		);

		return response.getBody();
	}

}
