/**
 * 
 */
package com.vz.aggregator.services.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.vz.aggregator.services.client.AccountServiceClient;
import com.vz.aggregator.services.entity.CustomerProfile;

/**
 * @author bharawat
 *
 */
@RestController
public class UserService {

	@Autowired 
	private AccountServiceClient accountServiceClient;
	
	@GetMapping("/v1/users")
	public List<CustomerProfile> getUsers() {

		/*
		 * ResponseEntity<List> responseEntity = new
		 * RestTemplate().getForEntity("http://localhost:8001/v1/profiles", List.class);
		 * if (responseEntity.hasBody()) { return responseEntity.getBody(); } throw new
		 * RuntimeException();
		 */
		return accountServiceClient.getProfiles();
	}

	@GetMapping("/v1/user/{id}")
	public CustomerProfile getUser(@PathVariable long id) {
		/*
		 * Map<String, Object> urlVariables = new HashMap<>(); urlVariables.put("id",
		 * id); ResponseEntity<CustomerProfile> responseEntity = new RestTemplate()
		 * .getForEntity("http://localhost:8001/v1/profile/{id}", CustomerProfile.class,
		 * urlVariables); if (responseEntity.hasBody()) { return
		 * responseEntity.getBody(); } throw new RuntimeException();
		 */
		return accountServiceClient.getProfile(id);
	}
}
