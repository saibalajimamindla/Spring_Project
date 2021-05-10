package com.Spring.Controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.Spring.Dao.LoginAndRegisterDaoImpl;
import com.Spring.Model.Login;
import com.Spring.Model.User;

@Controller
public class LoginAndRegisterController {

	@Autowired
	LoginAndRegisterDaoImpl loginAndRegisterDao;

	
	@RequestMapping("/signupform")
	public ModelAndView signUpForm(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("signupform");
		mav.addObject("user", new User());
		return mav;

	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ModelAndView signup(@ModelAttribute("user") User user) {
		ModelAndView mav = null;
		int status = loginAndRegisterDao.addUser(user);
		if (status != 0) {
			mav = new ModelAndView("signupcomplete");
		} else {
			mav = new ModelAndView("signupform");
			mav.addObject("message", "User Already Exists");
		}
		return mav;

	}

	@RequestMapping("/loginform")
	public ModelAndView loginForm(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("loginform");
		mav.addObject("login", new Login());
		return mav;

	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("login") Login login, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		System.out.println("controller is called");
		ModelAndView mav = null;

		User user = loginAndRegisterDao.validateUser(login);

		if (user != null) {
			System.out.println("if in controller");
			mav = new ModelAndView("logincomplete");

			mav.addObject("button2", user.getUsername());
			mav.addObject("button2adress", "#");
			mav.addObject("button1", "Logout");
			mav.addObject("button1adress", "logout");
			mav.addObject("button3", "Cart");
			mav.addObject("button3adress", "cart");

			Cookie ck = new Cookie("user", login.getUsername());
			response.addCookie(ck);
			System.out.println("printing cookie");
			System.out.println(ck);
			return mav;
		} else {
			System.out.println("else in controller");
			mav = new ModelAndView("loginform");
			mav.addObject("message", "Username or Password is wrong!!");
		}

		return mav;

	}
	
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response)
	{
		ModelAndView mav = new ModelAndView("Homepage");
		Cookie ck = new Cookie("user", "");  
        ck.setMaxAge(0);  
        response.addCookie(ck);
        
    	mav.addObject("button1", "Login");
		mav.addObject("button1adress", "loginform");
		mav.addObject("button2", "Sign-Up");
		mav.addObject("button2adress", "signupform");
		
		return mav;
		
		
	}
	


}