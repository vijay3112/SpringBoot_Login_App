package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.controller.LoginUser;

@Repository
public class LoginRepository {

	@Autowired
	MongoTemplate mongoTemplate;

	public Boolean validateLogin(String uName, String pWord) {

		Query query = new Query();
		try {
			Criteria criteria = new Criteria().andOperator(Criteria.where("userName").is(uName),
					Criteria.where("password").is(pWord));
			query.addCriteria(criteria);
			List<LoginUser> loggedUser = mongoTemplate.find(query, LoginUser.class);
			if (loggedUser != null && loggedUser.size() > 0) 
				return true;
			else 
				return false;
		} catch (Exception ex) {
			System.out.println("Exception Occured at LoginRepository vlaidateLogin() method:" + ex.getMessage());
			throw ex;
		}
	}
}
