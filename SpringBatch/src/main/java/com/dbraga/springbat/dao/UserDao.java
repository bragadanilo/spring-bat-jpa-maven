package com.dbraga.springbat.dao;

import org.springframework.stereotype.Repository;

import com.dbraga.springbat.entity.User;

@Repository("userDao")
public class UserDao extends GenericDAO<Long, User>{
	
	
}
