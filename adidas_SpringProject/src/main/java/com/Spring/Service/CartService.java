package com.Spring.Service;

import java.time.LocalDateTime;
import java.util.List;


import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.Spring.Dao.AppDataDao;

import com.Spring.Dao.CartDao;
import com.Spring.Model.Cart;
import com.Spring.Model.Orders;
import com.Spring.Model.Product;

@Service("cartService")
public class CartService {

	@Autowired
	CartDao cartDao;

	@Autowired
	AppDataDao appDataDao;

	public Product getProduct(List<Product> products) {
		Product product = products.get(0);
		return product;
	}

	

	public String currentUser(HttpServletRequest request) {

		String username;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		} else {
			username = principal.toString();
		}

		if (username.equals("anonymousUser")) {

			return null;
		} else {
			return username;
		}
	}

	

	public void removeCartItem(String productCode, HttpServletRequest request) {
		cartDao.removeItem(productCode, currentUser(request));
	}

	public void addTocart(String productCode, String user) {
		cartDao.addItemToCart(productCode, user);

	}

	public ModelAndView cartTotal(ModelAndView mav) {
		double cartTotalPrice = cartDao.cartTotal();

		mav.addObject("carttotal", cartTotalPrice);

		return mav;

	}

	public void checkout(HttpServletRequest request) {

		List<Cart> cartItems = cartDao.getCartItems(currentUser(request));

		for (Cart item : cartItems) {
			String username;
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			if (principal instanceof UserDetails) {
				username = ((UserDetails) principal).getUsername();
			} else {
				username = principal.toString();
			}
			Orders order = new Orders();
			order.setProductCode(item.getProductCode());
			order.setName(item.getName());
			order.setPrice(item.getPrice());
			order.setUser(username);
			order.setDateAndTime(LocalDateTime.now());

			cartDao.addItemToOrders(order);
			cartDao.removeItem(item.getProductCode(), currentUser(request));
			Product product = appDataDao.getProductDetails(item.getProductCode());
			product.setQuantity((product.getQuantity() - 1));
			appDataDao.updateProduct(product);

		}

	}
	
public ModelAndView addHeaderButtons( ModelAndView mav){
		
		mav.addObject("categoryList",appDataDao.getCategories());
		
		String username;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		} else {
			username = principal.toString();
		}

		if (username.equals("anonymousUser")) {

			mav.addObject("button1", "Login");
			mav.addObject("button1adress","loginform");
			mav.addObject("button2", "Sign-Up");
			mav.addObject("button2adress", "signupform");
			mav.addObject("button3", "Cart");
			mav.addObject("button3adress", "cart");
		} else {

			mav.addObject("button2", username);
			mav.addObject("button2adress", "#");
			mav.addObject("button1", "Logout");
			mav.addObject("button1adress", "logout");
			mav.addObject("button3", "Cart");
			mav.addObject("button3adress", "cart");
		}
		return mav;
		
	}

}
