package com.Spring.Service;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
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

	public ModelAndView checkLoginSatatus(HttpServletRequest request, ModelAndView mav) {
		Cookie ck[] = request.getCookies();
		String cookieName = "user";
		String value = null;

		if (ck != null) {

			for (int i = 0; i < ck.length; i++) {
				Cookie cookie = ck[i];
				if (cookieName.equals(cookie.getName())) {
					value = cookie.getValue();
				}
			}

		} else {

			value = null;
		}

		if (value == null || value == "") {

			mav.addObject("button1", "Login");
			mav.addObject("button1adress", "loginform");
			mav.addObject("button2", "Sign-Up");
			mav.addObject("button2adress", "signupform");
		} else {

			mav.addObject("button2", value);
			mav.addObject("button2adress", "#");
			mav.addObject("button1", "Logout");
			mav.addObject("button1adress", "logout");
			mav.addObject("button3", "Cart");
			mav.addObject("button3adress", "cart");
		}

		return mav;

	}

	public void removeCartItem(String productCode) {
		cartDao.removeItem(productCode);
	}

	public void addTocart(String productCode) {
		cartDao.addItemToCart(productCode);

	}

	public ModelAndView cartTotal(ModelAndView mav) {
		double cartTotalPrice = cartDao.cartTotal();

		mav.addObject("carttotal", cartTotalPrice);

		return mav;

	}

	public void checkout(HttpServletRequest request) {

		List<Cart> cartItems = cartDao.getCartItems();

		for (Cart item : cartItems) {
			Cookie ck[] = request.getCookies();
			String cookieName = "user";
			String value = null;

			if (ck != null) {

				for (int i = 0; i < ck.length; i++) {
					Cookie cookie = ck[i];
					if (cookieName.equals(cookie.getName())) {
						value = cookie.getValue();
					}
				}

			} else {

				value = null;
			}
			Orders order = new Orders();

			order.setProductCode(item.getProductCode());
			order.setName(item.getName());
			order.setPrice(item.getPrice());
			order.setUser(value);
			order.setDateAndTime(LocalDateTime.now());

			cartDao.addItemToOrders(order);
			cartDao.removeItem(item.getProductCode());
			Product product = appDataDao.getProductDetails(item.getProductCode());
			product.setQuantity((product.getQuantity()-1));
			appDataDao.updateProduct(product);
			
		}

	}

}
