/**
 * 
 */
package com.vz.domain.services.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vz.domain.services.entity.CustomerProfile;

/**
 * @author bharawat
 *
 */
public interface CustomerProfileRepository extends JpaRepository<CustomerProfile, Long> {

}
