package com.payne.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.payne.service.HelloService;
import com.payne.util.JSONUtil;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/hello")
public class HelloController {
	 private static final Logger log = Logger.getLogger(HelloController.class);
	 @Autowired
	 private HelloService helloService;
	 @Autowired
	 ApplicationContext applicationContext;
	 public HelloController(){
		 log.info("HelloController was Loaded");
	 }
	 @RequestMapping("p1")
	   public @ResponseBody String fun1(ModelMap model) {
		  log.info("p1 mapping is executed");
	      model.addAttribute("message", "Hello pan");
	      return "{name:'payne100'}";
	   }
	 @RequestMapping(value="p2",method=RequestMethod.POST)
	   public @ResponseBody Map<String, Object> fun2(@RequestParam(value="params") String params, HttpServletResponse resp) {
		  log.info("p2 mapping is executed");
	      String str = "{name:\"payne\"}";
	      return JSONUtil.fromJson(params);
	   }
	 @RequestMapping(value="p3",method=RequestMethod.POST)
	   public @ResponseBody JSONObject fun3(@RequestParam(value="params") String params, HttpServletResponse resp) {
		  log.info("p3 mapping is executed");
	      String str = "{name:\"payne\"}";
	      return JSONObject.fromObject(params);
	   }
	 @RequestMapping(value="p4")
	 public void fun4(@RequestParam(value="params") String params,HttpServletResponse response,HttpServletRequest request){
		 System.out.println(helloService.testService(params));
		 PrintWriter pw = null;
		 try {
			pw = new PrintWriter(response.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		 pw.println("<html><h2>Hello World</h2></html>");
		 pw.flush();
	 }
	 
	 @RequestMapping(value="p5")
	 public void fun5(@RequestParam(value="params") String params,HttpServletResponse response,HttpServletRequest request){
		helloService.testCommonDao();
		 PrintWriter pw = null;
		 try {
			pw = new PrintWriter(response.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		 pw.println("<html><h2>Hello World</h2></html>");
		 pw.flush();
	 }
	 /*
	  * 显示已经加载的Bean
	  */
	 @RequestMapping(value="p6")
	 public void fun6(){
		 String[] beanNames = applicationContext.getBeanDefinitionNames();
		 for(String name:beanNames)
			 System.out.println(name);
	 }
}
