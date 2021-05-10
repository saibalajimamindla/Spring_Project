package com.Spring.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service("appDataService")
public class AppDataService {

	public ModelAndView checkLoginSatatus(HttpServletRequest request,ModelAndView mav) {
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

}
