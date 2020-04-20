/**
 * 
 */
package com.vz.domain.services.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author bharawat
 *
 */
@Entity
public class CustomerProfile {	
	
	/**
	 * 
	 */
	public CustomerProfile() {
	}

	@Id
	@GeneratedValue
	private long id;
	private String customerName;
	private String addressLine1;
	private String addressLine2;
	private String addressLine3;
	private String city;
	private String state;
	private String country;
	private String customerType;
	private String applicationPort;
	
	/**
	 * @param customerName
	 * @param addressLine1
	 * @param addressLine2
	 * @param addressLine3
	 * @param city
	 * @param state
	 * @param country
	 * @param customerType
	 */
	public CustomerProfile(String customerName, String addressLine1, String addressLine2, String addressLine3,
			String city, String state, String country, String customerType) {
		this.customerName = customerName;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.addressLine3 = addressLine3;
		this.city = city;
		this.state = state;
		this.country = country;
		this.customerType = customerType;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 * @return the addressLine1
	 */
	public String getAddressLine1() {
		return addressLine1;
	}

	/**
	 * @param addressLine1 the addressLine1 to set
	 */
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	/**
	 * @return the addressLine2
	 */
	public String getAddressLine2() {
		return addressLine2;
	}

	/**
	 * @param addressLine2 the addressLine2 to set
	 */
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	/**
	 * @return the addressLine3
	 */
	public String getAddressLine3() {
		return addressLine3;
	}

	/**
	 * @param addressLine3 the addressLine3 to set
	 */
	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the customerType
	 */
	public String getCustomerType() {
		return customerType;
	}

	/**
	 * @param customerType the customerType to set
	 */
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the applicationPort
	 */
	public String getApplicationPort() {
		return applicationPort;
	}

	/**
	 * @param string the applicationPort to set
	 */
	public void setApplicationPort(String applicationPort) {
		this.applicationPort = applicationPort;
	}
	
	@Override
	public String toString() {
		return String.join("Profile : ", "name :", getCustomerName(), "; address : ", getAddressLine1(),
				getAddressLine2(), getAddressLine3(), getCity(), getState(), getCountry(), "; customer type : ",
				getCustomerType());
	}
}