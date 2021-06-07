package com.Spring.Service;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Spring.Dao.LoginAndRegisterDao;
import com.Spring.Model.Login;
import com.Spring.Model.User;

@Service("loginAndRegisterService")
public class LoginAndRegisterService {
	
	@Autowired
	LoginAndRegisterDao loginAndRegisterDao;

	public User checkUser(List<User> results, Login login) {
		User user = null;

		try {
			user = results.get(0);
		} catch (Exception e) {
			user = null;
		}
		if (user != null) {

			System.out.println(user);
			String password = user.getPassword();

			if (password.equals(login.getPassword())) {

				return user;

			} else {

				return null;

			}
		} else {
			return null;

		}

	}

	public void addCookie(Login login, HttpServletResponse response) {

		Cookie ck = new Cookie("user", login.getUsername());
		response.addCookie(ck);
	}

	/*
	 * public void removeCookie(HttpServletResponse response) { Cookie ck = new
	 * Cookie("user", ""); ck.setMaxAge(0); response.addCookie(ck);
	 * 
	 * }
	 */
	
	public int adduser(User user)
	{
		user.setRoles("USER");
		user.setEnabled(1);
		return loginAndRegisterDao.addUser(user);
		
	}
	


}
