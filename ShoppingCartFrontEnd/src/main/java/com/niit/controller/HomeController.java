package com.niit.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcartbackend.dao.CategoryDAO;
import com.niit.shoppingcartbackend.dao.ProductDAO;
import com.niit.shoppingcartbackend.dao.SupplierDAO;
import com.niit.shoppingcartbackend.domain.Category;
import com.niit.shoppingcartbackend.domain.Product;
import com.niit.shoppingcartbackend.domain.Supplier;


@Controller
public class HomeController {
	
	//http://localhost:8080/ShoppingCart/
	
	
	@Autowired HttpSession session;
	
	@Autowired  Category category;
	
	@Autowired  CategoryDAO  categoryDAO;
	
	@Autowired Product product;
	@Autowired ProductDAO productDAO;
	
	@Autowired Supplier supplier;
	@Autowired SupplierDAO supplierDAO;
	
	
	@RequestMapping("/")	
		public ModelAndView goToHome() {
		
			ModelAndView mv = new ModelAndView("Home");
			mv.addObject("isUserAtHomePage", "true");
			mv.addObject("message","Thank You For Visiting Shopper's Land");
			
			// get all categories
			List<Category> categoryList = categoryDAO.list();

			// attach category to session
			session.setAttribute("categoryList", categoryList);
			session.setAttribute("category", category);

			// get products
			List<Product> productList = productDAO.list();

			// attach products to session
			session.setAttribute("productList", productList);
			session.setAttribute("product", product);

			
			// get products
			List<Supplier> supplierList = supplierDAO.list();

			// attach supplier to session
			session.setAttribute("supplierList", supplierList);
			session.setAttribute("supplier", supplierList);

			return mv;
			// return "Home";
			//return "Home"
	}
	
	
	@RequestMapping("/LoginPage")
	public String loginPage(Model model)
	{
		model.addAttribute("isUserClickedLogin", "true");
	
		return "Home";
	}
	
	@RequestMapping("/RegistrationPage")
	public String registrationPage(Model model)
	{
		model.addAttribute("isUserClickedRegister", "true");
		
		return "Home";
	}
	
	@RequestMapping("/ContactUsPage")
	public String contactUsPage(Model model)
	{
		model.addAttribute("isUserClickedContactUs","true");
		return "Home";
	}
	
	
	@RequestMapping("/myCartPage")
	public String cartPage(Model model) {
		model.addAttribute("isUserClickedCart", "true");
		return "Home";
	}
	@RequestMapping("/checkOutPage")
	public String checkoutPage(Model model) {
		model.addAttribute("isUserClickedCheckout", "true");
		return "Home";
	}
    
	@RequestMapping("/SignOut")
	public ModelAndView userSignOut() {
		ModelAndView mv = new ModelAndView("redirect:/");
		session.setAttribute("isUserLoggedIn", "false");
		session.setAttribute("isAdmin", "false");
		mv.addObject("isUserAtHomePage", "true");
		return mv;
	}



}
