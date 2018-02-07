//package com.niit.controllers;
//
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import com.niit.Dao.CartDao;
//import com.niit.model.Cart;
// 
//@Controller
//
//public class NewCartController {
//	
//	@Autowired
//	CartDao cartDao;
//
//	@Autowired
//	Cart cart;
//	
//	
//	
//	@RequestMapping("/cart")
//	public String crt(Model m) {
//    List<Cart> crtl=cartDao.retrive();
//	m.addAttribute("Listofitems",crtl);
//	return"cart";
//
//}
//	
//	@ModelAttribute("obcartjsp")
//	public Cart ct()
//	{
//		return new Cart();
//	}
//	
//	
//	@RequestMapping(value="/addingtocart",method=RequestMethod.POST)
//	public String addcrt(@ModelAttribute("obcartjsp")Cart obcartjsp,HttpServletRequest request) {
//		 
//	
//	cart=obcartjsp.getCart();
//	int ctname=cart.getCartId();
// 	cart=cartDao.getCartId(ctname);
//	cartDao.insertCart(cart);
//	obcartjsp.setCartId(cart.getCartId());
//	
//	return "cart";
//} }
//
