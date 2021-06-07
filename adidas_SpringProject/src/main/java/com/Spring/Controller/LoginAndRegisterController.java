package com.Spring.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.Spring.Dao.LoginAndRegisterDao;
import com.Spring.Model.User;
import com.Spring.Service.LoginAndRegisterService;

@Controller
public class LoginAndRegisterController {

	@Autowired
	LoginAndRegisterDao loginAndRegisterDao;

	@Autowired
	LoginAndRegisterService loginAndRegisterService;

	@RequestMapping("/signupform")
	public ModelAndView signUpForm(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("signupform");
		mav.addObject("user", new User());
		return mav;

	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ModelAndView signup(@ModelAttribute("user") User user) {
		ModelAndView mav = null;
		int status = loginAndRegisterService.adduser(user);
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
		return mav;

	}

}
