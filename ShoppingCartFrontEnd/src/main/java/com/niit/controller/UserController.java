package com.niit.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcartbackend.dao.CategoryDAO;
import com.niit.shoppingcartbackend.dao.SupplierDAO;
import com.niit.shoppingcartbackend.dao.UserDAO;
import com.niit.shoppingcartbackend.domain.Category;
import com.niit.shoppingcartbackend.domain.Supplier;
import com.niit.shoppingcartbackend.domain.User;



@Controller
public class UserController {
	
	
	private static Logger log = LoggerFactory.getLogger(UserController.class);
	@Autowired
	HttpSession session;

	@Autowired UserDAO userDAO;
	@Autowired User  user;
	
	
	@Autowired CategoryDAO categoryDAO;
	
	@Autowired  Category  category;
	
	@Autowired Supplier supplier;
	
	@Autowired SupplierDAO supplierDAO;
	
	
	
	
	//Get the user id and password from login page
	//send these values to userDAO.validate
	//based on response, you can navigate to either login.jps or Home.jsp
	
	
	
	//Whenever we configure spring security - we can remove this method
	
	@RequestMapping("validate")
	public ModelAndView login(@RequestParam("userName") String id, 
			@RequestParam("password") String password)
	
	{
		
		log.debug("Starting of the method login");
		
		log.info("You are login with the id "+id);
		ModelAndView mv = new ModelAndView("/Home");
		 if(userDAO.validate(id, password)==true)
		 {
			 log.debug("Valid credentials");
			 
			 user = userDAO.get(id);
			 
			 //${message}  - to display in the Home.jsp
			 mv.addObject("message", " Welcome " + user.getName());
			 mv.addObject("categoryList", categoryDAO.list());
				mv.addObject("category", categoryDAO);

				mv.addObject("supplierList", supplierDAO.list());
				mv.addObject("supplier", supplierDAO);
				
			 
			 session.setAttribute("loggedInUserID", id);
			 

			 
			 //check whether user is customer or admin
			 
			 if(user.getRole().equals("admin"))
			 {
				 log.debug("You are admin");
				 mv.addObject("isAdmin", "true");
				 session.setAttribute("role", "ROLE_ADMIN");
				 session.setAttribute("isAdminLoggedIn", "true");
					mv.addObject("isAdminAtHomePage","true");
				 
				 
			 }
			 else
			 {
				 log.debug("You are customer");
				 mv.addObject("isAdmin", "false");
				 session.setAttribute("role", "ROLE_USER");
					session.setAttribute("isUserLoggedIn", "true");
					mv.addObject("isUserAtHomePage","true");
				 
			 }
			 
			 
		 }
		 else
		 {
			 log.debug("Invalid user");
			 mv.addObject("message", "Invalid credentials..please try again.");
		 }
		 
		 log.debug("Ending of the method login");
		 return mv;
		
	}
	
	
	
	//We need to implement
	//create user
	//update user
	//getAllUsers
	//
	
	
	
	

}
