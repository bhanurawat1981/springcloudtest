/**
 * 
 */
package com.vz.domain.services.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.vz.domain.services.entity.CustomerProfile;

/**
 * @author bharawat
 *
 */
@Repository
@Transactional
public class ProfileDao {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@PersistenceContext
	private EntityManager entityManager;

	public long createCustomerProfile(CustomerProfile customerProfile) {
		entityManager.persist(customerProfile);
		logger.info("ProfileDao - customerProfile persisted : ", customerProfile.getId());
		return customerProfile.getId();
	}
}
