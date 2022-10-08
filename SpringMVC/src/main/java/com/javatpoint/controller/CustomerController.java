package com.javatpoint.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CustomerController {
	
	@RequestMapping(value = "dispalyaddcustomerpage", method = RequestMethod.GET)
	public String dispalyaddcustomerpage()
	{
    	
    	return "addcustomer";
	}
	
    @RequestMapping(value = "savecustomerinfo", method = RequestMethod.GET)
	public String addCustomer(@RequestParam Optional<String> firstname, Model model)
	{
    	model.addAttribute("firstname", firstname);
    	return "displaycustomerinfo";
	}
}
