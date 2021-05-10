package com.Spring.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Spring.Model.Login;
import com.Spring.Model.User;

@Service("loginAndRegisterService")
public class LoginAndRegisterService {

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

	
}
