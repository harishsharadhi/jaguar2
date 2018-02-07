package com.niit.controllers;

 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.Dao.ProductDao;
import com.niit.Dao.UserDao;
import com.niit.model.Product;
import com.niit.model.User;





@Controller
public class UserController {
	
	private static final String obuserjsp = null;
	@Autowired
	UserDao userDao;
	
	 
//for signing up
	@RequestMapping("/signup")
	
		public String u()
		{
			return "user";
		}

	@RequestMapping("/user")
	public String s()
	{
		return "user";
	}
	
@ModelAttribute("obuserjsp")
	public User shop()
	{
	
	return new User();
	
	}

@RequestMapping(value="/userrequest",method=RequestMethod.POST)
public String userdetail(@ModelAttribute("obuserjsp") User obuserjsp)
{
	userDao.insertUser(obuserjsp);
	return "";
}
}
