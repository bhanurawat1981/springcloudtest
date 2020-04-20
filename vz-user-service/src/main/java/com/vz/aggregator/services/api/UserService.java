/**
 * 
 */
package com.vz.aggregator.services.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.vz.aggregator.services.client.AccountServiceClient;
import com.vz.aggregator.services.entity.CustomerProfile;

/**
 * @author bharawat
 *
 */
@RestController
public class UserService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired 
	private AccountServiceClient accountServiceClient;
	
	@GetMapping("/v1/users")
	public List<CustomerProfile> getUsers() {
		logger.info("Request received for /v1/users");		
		/*
		 * ResponseEntity<List> responseEntity = new
		 * RestTemplate().getForEntity("http://localhost:8001/v1/profiles", List.class);
		 * if (responseEntity.hasBody()) { return responseEntity.getBody(); } throw new
		 * RuntimeException();
		 */
		List<CustomerProfile> response = accountServiceClient.getProfiles();
		logger.info("response : {}",response);
		return response;
	}

	@GetMapping("/v1/user/{id}")
	public CustomerProfile getUser(@PathVariable long id) {
		logger.info("Request received for /v1/users/{}",id);
		/*
		 * Map<String, Object> urlVariables = new HashMap<>(); urlVariables.put("id",
		 * id); ResponseEntity<CustomerProfile> responseEntity = new RestTemplate()
		 * .getForEntity("http://localhost:8001/v1/profile/{id}", CustomerProfile.class,
		 * urlVariables); if (responseEntity.hasBody()) { return
		 * responseEntity.getBody(); } throw new RuntimeException();
		 */
		CustomerProfile response = accountServiceClient.getProfile(id);
		logger.info("response : {}",response);
		return response;
	}
}
