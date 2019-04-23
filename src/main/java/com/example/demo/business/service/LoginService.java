/**
 * 
 */
package com.example.demo.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.LoginRepository;

/**
 * @author AG04007
 *
 */
@Service
public class LoginService {

	@Autowired
	private LoginRepository loginRepo;

	/**
	 * 
	 * @param _uName
	 * @param _pwd
	 */
	public Boolean doLogin(String _uName, String _pwd) {
		Boolean isValidUser = loginRepo.validateLogin(_uName, _pwd);
		// needs to add more conditions.
		/*if (isValidUser) {
			
		} else {
			
		}*/
		return isValidUser;
	}
}
