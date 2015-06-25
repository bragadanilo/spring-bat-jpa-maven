package com.dbraga.springbat.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dbraga.springbat.dao.UserDao;
import com.dbraga.springbat.entity.User;

@Service("userService")
public class UserService {
	
	@Autowired
	UserDao userDao;

	public String sayHello() {
		return "Hello! " + userDao.findAll().get(0).getName();
	}
	
	@Transactional(rollbackFor=Exception.class)
	public void transactionWithError() throws Exception {
		
		User user = new User("User "+ new Date());
		userDao.save(user);
		throw new Exception("Forced Error!");
	}
	
	public int size(){
		return userDao.findAll().size();
	}
}