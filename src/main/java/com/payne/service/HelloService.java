package com.payne.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payne.controller.HelloController;
import com.payne.dao.ICommonDAO;
import com.payne.entity.User;

@Service
public class HelloService {
	private static final Logger log = Logger.getLogger(HelloController.class);
	@Autowired
	private ICommonDAO commonDao;
	public HelloService() {
		log.info("HelloService was loaded");
	}

	public String testService(String str){
		return str;
	}
	public void testCommonDao(){
		User user = (User)commonDao.get(User.class, 2);
		System.out.println(user);
	}
}
