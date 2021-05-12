package com.Spring.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Spring.Dao.CartDao;

import com.Spring.Model.Cart;
import com.Spring.Service.CartService;

@Controller
public class CartController {

	@Autowired
	CartDao cartDao;

	@Autowired
	CartService cartService;

	@RequestMapping("/addtocart/{productCode}")
	public String addItem(HttpServletRequest request, HttpServletResponse response,
			@PathVariable String productCode) {
		cartService.addTocart(productCode);
		

		return "redirect:/cart";
	}

	@RequestMapping("/cart")
	public ModelAndView viewCart(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mav = new ModelAndView("cartpage");
		List<Cart> cartItems = cartDao.getCartItems();
		if(!cartItems.isEmpty())
		{
			mav.addObject("items", cartItems);
			mav =cartService.cartTotal(mav);
		}else
		{
			mav.addObject("message", "Cart is Empty");
		}
		
		
		mav = cartService.checkLoginSatatus(request, mav);
		
		
		return mav;
		
	}
	
	@RequestMapping("remove/{productCode}")
	public String removeFromCart(HttpServletRequest request, HttpServletResponse response,@PathVariable String productCode)
	{
		
		cartService.removeCartItem(productCode);
		
		return "redirect:/cart";
		
	}
	
	@RequestMapping("/checkout")
	public ModelAndView requestCheckout(HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView mav = new ModelAndView("checkout");
		mav = cartService.checkLoginSatatus(request, mav);
		cartService.checkout(request);
		return mav;
	}

}
