package com.javatpoint.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

	
	//@RequestMapping(value="/authentication") 
	@RequestMapping(value="authentication")  
    public String authentication(HttpServletRequest req,Model model)  
    {  
		
        //read the provided form data  
        String name=req.getParameter("name");  
        String pass=req.getParameter("pass");  
        if(pass.equals("admin"))  
        {  
            String msg="Hello "+ name;  
            //add a message to the model  
            model.addAttribute("message", msg);  
            return "viewpage";  
        }  
        else  
        {  
            String msg="Sorry "+ name+". You entered an incorrect password";  
            model.addAttribute("message", msg);  
            return "errorpage";  
        }     
    }  
}  