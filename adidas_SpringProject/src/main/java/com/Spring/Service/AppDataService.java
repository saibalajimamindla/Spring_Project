package com.Spring.Service;

import javax.servlet.http.HttpServletRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service("appDataService")
public class AppDataService {


	public ModelAndView checkLoginSatatus(HttpServletRequest request, ModelAndView mav) {
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