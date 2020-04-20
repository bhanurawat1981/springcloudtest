/**
 * 
 */
package com.vz.aggregator.services.client;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.vz.aggregator.services.entity.CustomerProfile;

/**
 * @author bharawat
 *
 */
//@FeignClient(name="vz-account-services", url="localhost:8001")
@FeignClient(name="vz-zuul-service")
@RibbonClient(name="vz-account-services")
public interface AccountServiceClient {

	@GetMapping("/vz-account-services/v1/profiles")
	public List<CustomerProfile> getProfiles();
	
	@GetMapping("/vz-account-services/v1/profile/{id}")
	public CustomerProfile getProfile(@PathVariable("id") long id);
}
