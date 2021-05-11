package com.Spring.Dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import com.Spring.Model.Product;

public interface AppDataDao {
	public void updateProduct(Product product);
	public Product getProductDetails(String productCode);
	public List<Product> getProducts(String category) throws SerialException, SQLException, IOException;

}
