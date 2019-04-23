/**
 * 
 */
package com.example.demo.controller;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

/**
 * @author AG04007
 *
 */
@Getter
@Setter
@Document(collection = "logindata")
public class LoginUser implements Serializable {

	/**
	 * serialVersionUID value;
	 */
	private static final long serialVersionUID = 1L;
	
	private String userName;
	private String password;

}
