package com.niit.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.niit.Dao.CartDao;
import com.niit.Dao.CategoryDao;
import com.niit.Dao.ProductDao;
import com.niit.Dao.SupplierDao;
import com.niit.Dao.UserDao;
import com.niit.FileIO.util.FileIO;
import com.niit.model.Category;
import com.niit.model.Product;
import com.niit.model.Supplier;
import java.nio.file.Path;




import java.awt.Graphics;

import java.awt.Image;

import java.awt.image.ImageObserver;

import java.awt.image.ImageProducer;

import java.io.File;

import java.nio.file.Path;

import java.nio.file.Paths;@Controller
public class ProductController {
	
	
	@Autowired
	ProductDao productDao;
	//crud operation;
	


@Autowired
Category category;

@Autowired
Supplier supplier;
	@Autowired
	CategoryDao categoryDao;
	
	private Path path;
	
	@Autowired
	SupplierDao supplierDao;
	
	@RequestMapping("/productlist")
	public String plist(Model m) {
		List<Product> pl=productDao.retrieve();  
		m.addAttribute("Listofprod",pl);
		m.addAttribute("categoryList",categoryDao.retrieve());//for retriveing the data from the categoryDao
		m.addAttribute("supplierList",supplierDao.retrieve());//same as above
		return "product";
	}
@RequestMapping("/productavailability")
public String p()
{
	return "product";
}

 

@ModelAttribute("obprodjsp")
public Product newpr()
{
	return new Product();
}

 
@RequestMapping(value="/addingproduct",method=RequestMethod.POST)
public String addingpro(@ModelAttribute("obprodjsp") Product obprodjsp, HttpServletRequest request)
{
	
	
	category=obprodjsp.getCategory();
	String catname=category.getCname();
 	category=categoryDao.getcatbyname(catname);
	categoryDao.insertCategory(category);
	obprodjsp.setCid(category.getCid());
	
	
	supplier=obprodjsp.getSupplier();
	String supname=supplier.getSname();
	supplier=supplierDao.getsupbyname(supname);
	supplierDao.insertSupplier(supplier);
	
	obprodjsp.setCategory(category);
	obprodjsp.setSupplier(supplier);
	obprodjsp.setSid(supplier.getSid());
	productDao.insertProduct(obprodjsp);

	 
	
	// for image saving
	MultipartFile f=obprodjsp.getPimage();
	String rootDirectory=request.getSession().getServletContext().getRealPath("/");
    /*path=Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\"+product.getPro_id()+".jpg");*/
    path = Paths.get(rootDirectory + "\\resources\\images\\" + obprodjsp.getPid() + ".jpg");

	
     if(f!=null && !f.isEmpty()){
	   {

		try{

			f.transferTo(new File(path.toString()));
        	System.out.println("Image Uploaded to Product.....");

		    }catch(Exception e)

		{
            e.printStackTrace();
            throw new RuntimeException("image saving failed ",e);

		}
	
	}

	

	System.out.println("path converting to string");
	FileIO.upload(path, f, obprodjsp.getPid() + ".jpg");
    System.out.println("path converted to string" + obprodjsp.getPid());

	 
 
	
}
	return  "redirect:/productlist";
}


@Autowired
Product product;

@RequestMapping("/updateproduct-{pid}")
private String editproduct(@PathVariable("pid") int pid,Model m) {
	product=productDao.findByPID(pid);
	m.addAttribute("obprodjsp",product);
	return "product";
}


@RequestMapping("/deleteproduct-{pid}")
private String deleteproduct(@PathVariable("pid") int pid,Model m) {
	product=productDao.findByPID(pid);
	productDao.removeproduct(product);
	return "redirect:/productlist";
}
}


//@Autowired
//CartDao cartDao;
//
//@RequestMapping("/AddToCart")
//public String crt
//}
//








  


