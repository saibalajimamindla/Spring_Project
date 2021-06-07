package com.Spring.Dao;

import java.util.List;

import com.Spring.Model.Cart;
import com.Spring.Model.Orders;

public interface CartDao {
	public void removeItem(String productCode,String user);
	public void addItemToOrders(Orders order);
	public double cartTotal();
	public List<Cart> getCartItems(String user);
	public void addItemToCart(String productCode,String user);
	public List<String> getCategories();

}
