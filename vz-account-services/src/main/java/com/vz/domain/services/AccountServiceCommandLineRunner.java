/**
 * 
 */
package com.vz.domain.services;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.vz.domain.services.dao.CustomerProfileRepository;
import com.vz.domain.services.dao.ProfileDao;
import com.vz.domain.services.entity.CustomerProfile;

/**
 * @author bharawat
 *
 */
@Component
public class AccountServiceCommandLineRunner implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ProfileDao profileDao;

	@Autowired
	private CustomerProfileRepository customerProfileRepository;

	@Override
	public void run(String... args) throws Exception {
		getDefaultProfiles().forEach(customerProfile -> logger.info("User inserted with id : "+
				profileDao.createCustomerProfile(customerProfile)));

		List<CustomerProfile> customerProfileList = customerProfileRepository.saveAll(getDefaultProfiles());
		customerProfileList
				.forEach(customerProfile -> logger.info("User inserted with id : "+ customerProfile.getId()));
	}

	public List<CustomerProfile> getDefaultProfiles() {
		return Arrays.asList(
				new CustomerProfile("ABCL Enterprise", "Roop Mehal", "Prem Gali", null, "Kholi", "#", "420",
						"Enterprise"),
				new CustomerProfile("Vijay Dinanath Chauhan", "Jank khayela tabela", null, "match fixing gali",
						"betting road", "toote khke k peechhe", "shamshan", "EndUser"));
	}
}
