/**
 * 
 */
package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.business.service.LoginService;

/**
 * @author AG04007
 *
 */
@RestController
@RequestMapping("/employee")
@CrossOrigin
public class LoginController {

	@Autowired
	private LoginService loginService;

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public Boolean loginCustomer(@RequestBody LoginUser loginUser) {
		Boolean isValidUser = false;
		if (!StringUtils.isEmpty(loginUser.getUserName()) && !StringUtils.isEmpty(loginUser.getPassword())) {
			isValidUser = loginService.doLogin(loginUser.getUserName(), loginUser.getPassword());
		}
		return isValidUser;
	}
}
