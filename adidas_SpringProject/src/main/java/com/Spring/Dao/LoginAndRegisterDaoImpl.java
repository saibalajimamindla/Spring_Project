package com.Spring.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.Spring.Model.User;
import com.Spring.Service.LoginAndRegisterService;

@Repository("loginAndRegisterDao")
public class LoginAndRegisterDaoImpl implements LoginAndRegisterDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	LoginAndRegisterService loginAndRegisterService;

	@SuppressWarnings("unchecked")
	@Transactional
	public int addUser(User user) {
		Session session = this.sessionFactory.getCurrentSession();
		String hql = "select user.password from User user where user.username ='" + user.getUsername() + "'";
		List<User> results = session.createQuery(hql).list();

		if (results.isEmpty()) {
			session.save(user);
			return 1;

		} else {

			return 0;

		}

	}

}
