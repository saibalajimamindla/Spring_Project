package com.Spring.Dao;

import com.Spring.Model.Login;
import com.Spring.Model.User;

public interface LoginAndRegisterDao {

	public User validateUser(Login login);
	public int addUser(User user);
}
