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
		return customerProfileRepository.findAll();
	}
	
	@GetMapping("/v1/profile/{id}")
	public CustomerProfile getProfile(@PathVariable long id) {
		Optional<CustomerProfile> customerProfile = customerProfileRepository.findById(id);
		if(customerProfile.isPresent()) {
			customerProfile.get().setApplicationPort(environment.getProperty("local.server.port"));
			return customerProfile.get();
		}
		throw new UserNotFoundException("User not found"); 
	}
	
	@PostMapping("/v1/profile")
	public CustomerProfile createProfiles(@RequestBody CustomerProfile customerProfile) {
		return customerProfileRepository.save(customerProfile);
	}
	
	@PostMapping("/v1/profile/{id}")
	public CustomerProfile updateProfile(@RequestBody CustomerProfile customerProfile) {
		if(customerProfileRepository.existsById(customerProfile.getId())) {
			return customerProfileRepository.save(customerProfile);	
		}
		throw new UserNotFoundException("User doesn't exist");
	}
}
