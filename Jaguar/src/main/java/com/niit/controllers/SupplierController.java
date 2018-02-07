package com.niit.controllers;

import java.util.List;

import org.apache.tomcat.util.log.UserDataHelper.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.Dao.SupplierDao;
import com.niit.model.Supplier;

@Controller


public class SupplierController 
{
	
	private static final String obsupjsp = null;
  
@Autowired
SupplierDao supplierDao;

//RETRIEVEING DATA FROM DATABASE
@RequestMapping("/supplierlist")
public String slist(Model m)
{  
	 List<Supplier> sl= supplierDao.retrieve();
	 m.addAttribute("listofsupp",sl);
	return "supplier";
}
 
/*@RequestMapping("/supplieravailability")
public String s()
	{
		return "supplier";
	}*/

//CALLING OBJECT obsupjsp OF SUPPLIER.JSP THROUGH CONTEXT addingsupplier by POST method

@ModelAttribute("obsupjsp")
public Supplier newsup()
{
	return new Supplier();
}

//savingthings and returning to page again

@RequestMapping(value="/addingsupplier",method=RequestMethod.POST)
public String addingsupp(@ModelAttribute("obprodjsp") Supplier obsupjsp)
{
	supplierDao.insertSupplier(obsupjsp);
	return "redirect:/supplierlist";
}

//CRUD OPERATION
@Autowired
Supplier supplier;

@RequestMapping("/updatesupplier-{sid}")
private String editsupplier(@PathVariable("sid") int sid,Model m) {
	supplier=supplierDao.findBySuppId(sid);
	m.addAttribute("obsupjsp",supplier);
	return "supplier";
}


@RequestMapping("/deletesupplier-{sid}")
private String deletesupplier(@PathVariable("sid") int sid,Model m) {
	supplier=supplierDao.findBySuppId(sid);
	supplierDao.removesupplier(supplier);
	return "redirect:/supplierlist";
}

}



