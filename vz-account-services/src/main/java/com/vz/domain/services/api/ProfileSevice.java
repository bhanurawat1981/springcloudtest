/**
 * 
 */
package com.vz.domain.services.api;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vz.domain.services.dao.CustomerProfileRepository;
import com.vz.domain.services.entity.CustomerProfile;
import com.vz.domain.services.exceptions.UserNotFoundException;

/**
 * @author bharawat
 *
 */
@RestController
public class ProfileSevice {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Environment environment;

	/**
	 * 
	 */
	public ProfileSevice() {
	}
	
	@Autowired
	private CustomerProfileRepository customerProfileRepository;

	@GetMapping("/v1/profiles")
	public List<CustomerProfile> getProfiles() {
		logger.info("Request received for /v1/profiles");	
		List<CustomerProfile> response = customerProfileRepository.findAll();
		logger.info("response : {}",response);
		return response;
	}
	
	@GetMapping("/v1/profile/{id}")
	public CustomerProfile getProfile(@PathVariable long id) {
		logger.info("Request received for /v1/profiles/{}",id);	
		Optional<CustomerProfile> customerProfile = customerProfileRepository.findById(id);
		if(customerProfile.isPresent()) {
			CustomerProfile response = customerProfile.get();
			response.setApplicationPort(environment.getProperty("local.server.port"));
			logger.info("response : {}",response);
			return response;
		}
		throw new UserNotFoundException("User not found"); 
	}
	
	@PostMapping("/v1/profile")
	public CustomerProfile createProfiles(@RequestBody CustomerProfile customerProfile) {
		logger.info("Request received for POST /v1/profiles");	
		CustomerProfile response = customerProfileRepository.save(customerProfile);
		logger.info("response : {}",response);
		return response;
	}
	
	@PostMapping("/v1/profile/{id}")
	public CustomerProfile updateProfile(@RequestBody CustomerProfile customerProfile) {
		logger.info("Request received for POST /v1/profiles/{}",customerProfile.getId());	
		if(customerProfileRepository.existsById(customerProfile.getId())) {
			CustomerProfile response = customerProfileRepository.save(customerProfile);	
			logger.info("response : {}",response);
			return response;	
		}
		throw new UserNotFoundException("User doesn't exist");
	}
}
