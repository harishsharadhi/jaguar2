 package com.niit.controllers;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.Dao.CategoryDao;
import com.niit.Dao.ProductDao;
import com.niit.Dao.SupplierDao;
import com.niit.Dao.UserDao;
import com.niit.DaoImpl.CatgeoryDaoImpl;
import com.niit.DaoImpl.ProductDaoImpl;
import com.niit.DaoImpl.SupplierDaoImpl;
import com.niit.model.Category;
import com.niit.model.Product;
import com.niit.model.Supplier;
import com.niit.model.User;

@Controller
public class AdminController {

	@Autowired 
	SupplierDao supplierDao;
	
	@Autowired
	CategoryDao categoryDao;
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	UserDao userDao;
   @Autowired
	User user;
  @RequestMapping("/adminpage")
   public String adding()
   {
	   return "admin";
   }
  
  
	@RequestMapping("/register")
	public String registerUser(Model model) {

		User usersDetail = new User();
		model.addAttribute("usersDetail", usersDetail);
		return "register";
	}
	
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView registerUserPost(@Valid @ModelAttribute("usersDetail") User usersDetail,
			BindingResult result) {
		
		if (result.hasErrors()) {					
			ModelAndView model=new ModelAndView("customerRegister");
			model.addObject("message", "You have entered invalid details");
			
			System.out.println("Page has errors");
			return model;
		}
		
		List<User> usersDetailList = userDao.getAllUsers();

        for (int i=0; i< usersDetailList.size(); i++) {
        	ModelAndView model=new ModelAndView("customerRegister");
        	if(usersDetail.getEmail().equals(usersDetailList.get(i).getEmail())) {
                model.addObject("emailError", "Email already exists");

                return model;
            }

            if(usersDetail.getName().equals(usersDetailList.get(i).getName())) {
                model.addObject("usernameError", "Username already exists");
                return model;
            }
            if(usersDetail.getPhone().equals(usersDetailList.get(i).getPhone())) {
                model.addObject("userPhoneError", "User phone already exists");
                return model;
            }
        }
		
		usersDetail.setEnabled(true);
		userDao.insertUser(usersDetail);
		ModelAndView model=new ModelAndView("registrationSuccess");
		return model;
	}
	@RequestMapping(value="/saveSupp",method=RequestMethod.POST)
	@Transactional
	public ModelAndView saveSuppData(@RequestParam("sid")int sid,@RequestParam("sname")String sname)
	{
		ModelAndView mv=new ModelAndView();
		Supplier ss=new Supplier();
		ss.setSid(sid);
		ss.setSname(sname);
		 
		supplierDao.insertSupplier(ss);
		mv.setViewName("modal");
		return mv;
		
}
	/*@RequestMapping(value="/saveCat",method=RequestMethod.POST)
	@Transactional
	public ModelAndView saveCatData(@RequestParam("cid")int cid,@RequestParam("cname")String cname)
	{
		ModelAndView mv=new ModelAndView();
		Category cc=new Category();
		cc.setCid(cid);
		cc.setCname(cname);
		categoryDao.insertCategory(cc);
		mv.setViewName("modal");
		return mv;
		
}*/
	/*@RequestMapping(value="/saveproduct",method=RequestMethod.POST)
	public String saveProd(HttpServletRequest request,@RequestParam("file")MultipartFile file)
	{
		Product prod=new Product();
		prod.setPname(request.getParameter("pName"));
		prod.setPrice(Double.parseDouble(request.getParameter("pPrice")));
		prod.setStock(Integer.parseInt(request.getParameter("pStock")));
		prod.setCategory(((CatgeoryDaoImpl) categoryDao).findByCatId(Integer.parseInt(request.getParameter("pCategory"))));
		prod.setSupplier(((SupplierDaoImpl) supplierDao).findBySuppId(Integer.parseInt(request.getParameter("pSupplier"))));
		
		String filepath=request.getSession().getServletContext().getRealPath("/");
		String filename=file.getOriginalFilename();
		prod.setImgName(filename);
		
		productDao.insertProduct(prod);
		System.out.println("File path"+ filepath);
		
		try
		{
			byte imagebyte[]=file.getBytes();
			BufferedOutputStream fos=new BufferedOutputStream(new FileOutputStream(filepath+"/resources/"+filename));
			fos.write(imagebyte);
			fos.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return "register";
		
	}*/
	@ModelAttribute
	public void loadingDataInPage(Model m)
	{
		m.addAttribute("satList",supplierDao.retrieve());
		m.addAttribute("catList",categoryDao.retrieve());
		m.addAttribute("prodList",productDao.retrieve());
	}
	@RequestMapping("/productList")
	public ModelAndView prodList()
	{
		ModelAndView mv=new ModelAndView("prodDetails");
		mv.addObject("prodList",productDao.retrieve());
		//mv.setViewName("productAdminList");
		return mv;
	}
	@RequestMapping("/supplierList")
	public ModelAndView suppList()
	{
		ModelAndView mv=new ModelAndView();
		mv.addObject("suppList",((CategoryDao) supplierDao).retrieve());
		mv.setViewName("suppAdminList");
		return mv;
	}
	/*@RequestMapping("/categoryList")
	public ModelAndView catList()
	{
		ModelAndView mv=new ModelAndView();
		mv.addObject("catList",categoryDao.retrieve());
		mv.setViewName("categoryAdminList");
		return mv;
	}*/
	/*@RequestMapping("/deleteProd/{pid}")
	public String deleteProduct(@PathVariable("pid")int pid)
	{
		 ((ProductDaoImpl) productDao).deleteProd(pid);
		return "redirect:/admin/productList?del";
	}
	@RequestMapping("/updateProd")
	public ModelAndView updateproduct(@RequestParam("pid") int pid)
	{
		ModelAndView mv= new ModelAndView();
		Product p=productDao.findByPID(pid);
		mv.addObject("prod", p);
		mv.addObject("cList",categoryDao.retrieve());
		mv.addObject("sList",((CategoryDao) supplierDao).retrieve());
		mv.setViewName("updateProduct");
		return mv;
	}*/
	@RequestMapping(value="/productUpdate",method=RequestMethod.POST)
	public String updateProd(HttpServletRequest request,@RequestParam("file")MultipartFile file)
	{
		String pid=(request.getParameter("pid"));
		Product prod=new Product();
		prod.setPid(Integer.parseInt(pid));
		prod.setPname(request.getParameter("pName"));
		prod.setPrice(Double.parseDouble(request.getParameter("pPrice")));
		prod.setDescription(request.getParameter("pDescription"));
		prod.setStock(Integer.parseInt(request.getParameter("pStock")));
		String cat=request.getParameter("pCategory");
		String sat=request.getParameter("pSupplier"); 
		prod.setCategory(((CatgeoryDaoImpl) categoryDao).findByCatId(Integer.parseInt(cat)));
		prod.setSupplier(((SupplierDaoImpl) supplierDao).findBySuppId(Integer.parseInt(sat)));
		
		String filepath=request.getSession().getServletContext().getRealPath("/");
		String filename=file.getOriginalFilename();
		
		((ProductDaoImpl) productDao).update(prod);
		
		System.out.println("File path"+ filepath);
		
		try
		{
			byte imagebyte[]=file.getBytes();
			BufferedOutputStream fos= new BufferedOutputStream(new FileOutputStream(filepath+"/resources/"+filepath));
			
			fos.write(imagebyte);
			fos.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "redirect:/productList?update";
	
					
		
		
		
	}
	
	
			
}