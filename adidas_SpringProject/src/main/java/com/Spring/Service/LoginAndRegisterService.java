package com.Spring.Service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Spring.Dao.LoginAndRegisterDao;
import com.Spring.Model.User;

@Service("loginAndRegisterService")
public class LoginAndRegisterService {
	
	@Autowired
	LoginAndRegisterDao loginAndRegisterDao;

	public int adduser(User user)
	{
		user.setRoles("USER");
		user.setEnabled(1);
		return loginAndRegisterDao.addUser(user);
		
	}
	


}
