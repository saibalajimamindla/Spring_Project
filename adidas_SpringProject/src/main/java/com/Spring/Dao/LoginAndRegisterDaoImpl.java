package com.Spring.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
/*import org.springframework.orm.hibernate5.HibernateTemplate;*/
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Spring.Model.Login;
import com.Spring.Model.User;
import com.Spring.Service.LoginAndRegisterService;

@Repository("loginAndRegisterDao")
public class LoginAndRegisterDaoImpl   {

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

			return (int) session.save(user);

		} else {

			return 0;

		}

	}

	@SuppressWarnings("unchecked")
	@Transactional
	public User validateUser(Login login) {
		Session session = this.sessionFactory.getCurrentSession();
		String hql = "from User user where user.username ='" + login.getUsername() + "'";
		List<User> results = session.createQuery(hql).list();

		return loginAndRegisterService.checkUser(results, login);

	}

}
