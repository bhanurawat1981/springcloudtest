/**
 * 
 */
package com.vz.domain.services.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author bharawat
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5483593063440439245L;
	
	/**
	 * 
	 */
	public UserNotFoundException(String message) {
		super(message);
	}
}
