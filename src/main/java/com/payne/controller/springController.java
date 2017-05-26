package com.payne.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.payne.biz.springBiz;
@Controller
@RequestMapping("spring")
public class springController {
	private static final Logger log = Logger.getLogger(springController.class);
	@Autowired
	private springBiz biz ;
    public springController() {
		log.info("springController was loaded");
	}
	@RequestMapping("getBoards")
	public void getBoards(){
		biz.getBoards();
	}
}
