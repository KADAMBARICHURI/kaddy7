package com.niit.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.niit.shoppingcartbackend.dao.ProductDAO;
import com.niit.shoppingcartbackend.dao.SupplierDAO;
import com.niit.shoppingcartbackend.domain.Product;
import com.niit.shoppingcartbackend.domain.Supplier;

@Controller
public class SupplierController {
private static Logger log = LoggerFactory.getLogger(SupplierController.class);
	
	@Autowired HttpSession session;
	
	@Autowired SupplierDAO supplierDAO;
	
	@Autowired Supplier supplier;
	
	@Autowired ProductDAO productDAO;
	
	@Autowired Product product;
	
	/*
	 * Add Suppliers
	 */
	@RequestMapping("/manage_supplier_add")
	public ModelAndView createSupplier(@RequestParam("id") String id,@RequestParam("name") String name,@RequestParam("address") String address, RedirectAttributes redirectAttributes)
	{
		
		log.debug("Starting of method createSupplier");
		
		supplier.setId(id);
		supplier.setName(name);
		supplier.setAddress(address);
		
		ModelAndView mv = new ModelAndView("redirect:/manageSuppliers");
		
		//mv.addObject("isAdminClickedSuppliers","true");
		//mv.addObject("isAdmin","true");
		
		//before calling save method check whether record is exist in db or not
		// if it is does not exist, then only call save method
		
		if(supplierDAO.getSupplierById(id) != null)
		{
			log.debug("Supplier all ready exist in database");
			//mv.addObject("message","Supplier Already exist with the id"+id);
			redirectAttributes.addFlashAttribute("message","Supplier Already exist with the id"+id);
			return mv;
		}
		else
		{
			supplierDAO.save(supplier);
			log.debug("Supplier Saved Successfully"+id);
			//mv.addObject("message","Supplier Created Successfully");
			redirectAttributes.addFlashAttribute("message","Supplier Created Successfully");
		}
		
		//session.setAttribute("supplierList", supplierDAO.list());
		//session.setAttribute("supplier", supplier);
		
		log.debug("Ending of the method createSupplier");
		return mv;
	}
	
	
	
	/*
	 * 
	 * Edit Suppliers
	 */
	@RequestMapping("manage_supplier_edit/{id}")
	public ModelAndView editSupplier(@PathVariable("id") String id)
	{
		log.debug("Starting of the method Edit Suppliers");
		log.debug("You are going to edit supplier : "+id);
		
		supplier = supplierDAO.getSupplierById(id);
		ModelAndView mv = new ModelAndView("redirect:/manageSuppliers");
		
		mv.addObject("selectedSupplier",supplier);
		session.setAttribute("selectedSupplier", supplier);
		
		log.debug("Ending of method Edit Suppliers");
		return mv;
	}
	
	
	/**
	 * 
	 * Delete Suppliers
	 */
	
	@RequestMapping("manage_supplier_delete/{id}")
	public ModelAndView deleteSupplier(@PathVariable("id") String id,RedirectAttributes redirectAttributes)
	{
		log.debug("Starting of method delete Supplier");
		log.debug("You are Going to delete" +id);
		
		ModelAndView mv = new ModelAndView("redirect:/manageSuppliers");
		
		// check whether the product are there for  this supplier or not
		int size = productDAO.getAllProductsBySupplierId(id).size();
		if(size != 0)
		{
			log.debug("Few Product under this Supplier you can not delete it");
			//mv.addObject("message","There are "+size+"Product under this Supplier "+id+"you can not delete it");
			redirectAttributes.addFlashAttribute("message","There are "+size+"Product under this Supplier "+id+"you can not delete it");
			return mv;
		}
		
		if(supplierDAO.delete(id) == true)
		{
			//mv.addObject("message","Successfully Deleted Suppliers");
			redirectAttributes.addFlashAttribute("message","Successfully Deleted Suppliers");
		}
		else
		{
			//mv.addObject("message","Not able to delete Supplier");
			redirectAttributes.addFlashAttribute("message","Not able to delete Supplier");
		}
		
		log.debug("Ending of the Method Delete Supplier");
		return mv;
	}
	
	/**
	 * 
	 * Update Suppliers
	 */
	
	@PostMapping("/manage_supplier_update")
	public ModelAndView updateSupplier(@RequestParam("id") String id,@RequestParam("name") String name, @RequestParam("address") String address, RedirectAttributes redirectAttributes)
	{
		log.debug("Starting of Method Update Suppliers");
		log.debug("You are going to edit the Supplier : "+id);
		
		supplier.setId(id);
		supplier.setName(name);
		supplier.setAddress(address);
		
		ModelAndView mv = new ModelAndView("redirect:/manageSuppliers");
		
		if(supplierDAO.getSupplierById(id) == null)
		{
			log.debug("Supplier does not exist with in database");
			//mv.addObject("message","Supplier does not exist with id :"+id);
			redirectAttributes.addFlashAttribute("message","Supplier does not exist with id :"+id);
			return mv;
		}
		else {
			supplierDAO.update(supplier);
			//mv.addObject("message","Supplier updated Sucessfully with id :"+id);
			redirectAttributes.addFlashAttribute("message","Supplier updated Sucessfully with id :"+id);
			log.debug("Supplier updated Successfully");
		}
		session.setAttribute("selectedSupplier", new Supplier());
		
		log.debug("Ending of method updateSupplier");
		return mv;
	}
}




