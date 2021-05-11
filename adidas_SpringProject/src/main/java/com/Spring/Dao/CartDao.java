package com.Spring.Dao;

import java.util.List;

import com.Spring.Model.Cart;
import com.Spring.Model.Orders;
import com.Spring.Model.Product;

public interface CartDao {
	public void removeItem(String productCode);
	public void addItemToOrders(Orders order);
	public double cartTotal();
	public List<Cart> getCartItems();
	public Product addItemToCart(String productCode);

}
