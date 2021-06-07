package com.Spring.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Spring.Model.Cart;
import com.Spring.Model.Orders;
import com.Spring.Service.CartService;

@Repository("cartDao")
public class CartDaoImpl implements CartDao {

	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	CartService cartService;

	@SuppressWarnings("unchecked")
	@Transactional
	public void addItemToCart(String productCode,String user) {
		Session session = this.sessionFactory.getCurrentSession();

		String checkCart = "from Cart cart where cart.productCode='" + productCode + "'"+"and user='"+user+"'";
		List<Cart> results = session.createQuery(checkCart).list();

		if (results.isEmpty()) {
			String insert = "INSERT INTO Cart(productCode, name, price,base64Image)"
					+ "SELECT p.productCode, p.name, p.price, p.base64Image  FROM Product p WHERE productCode = '"
					+ productCode + "'";
			session.createQuery(insert).executeUpdate();
			String setUser="update Cart set user='"+user+"'"+" WHERE productCode = '"+ productCode +"'";
			session.createQuery(setUser).executeUpdate();

		}

	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Cart> getCartItems(String user) {
		Session session = this.sessionFactory.getCurrentSession();
		String hql = "FROM Cart cart WHERE cart.user='"+user+"'";
		List<Cart> results = session.createQuery(hql).list();
		return results;

	}

	@SuppressWarnings("unchecked")
	@Transactional
	public double cartTotal() {
		Session session = this.sessionFactory.getCurrentSession();
		String hql = "SELECT SUM(c.price) FROM Cart c ";
		List<Double> results = session.createQuery(hql).list();

		return results.get(0);
	}

	@Transactional
	public void removeItem(String productCode,String user) {
		Session session = this.sessionFactory.getCurrentSession();
		String hql = "delete from Cart cart where cart.productCode ='" + productCode + "'"+"and user='"+user+"'";
		session.createQuery(hql).executeUpdate();
	}

	@Transactional
	public void addItemToOrders(Orders order) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(order);

	}

}
