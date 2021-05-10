package com.Spring.Dao;

import java.io.ByteArrayOutputStream;
/*import java.io.File;
import java.io.FileInputStream;*/
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
/*import org.springframework.orm.hibernate5.HibernateTemplate;*/
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Spring.Model.Product;

@Repository("appDataDao")
public class AppDataDaoImpl {

	@Autowired
	private SessionFactory sessionFactory;

	/*
	 * HibernateTemplate template;
	 * 
	 * public void setTemplate(HibernateTemplate template) { this.template =
	 * template;
	 * 
	 * }
	 * 
	 * @Transactional public void addItem() { File file = new
	 * File("C:\\Users\\saiba\\OneDrive\\Desktop\\adidas\\sports\\s08.jpg"); byte[]
	 * bFile = new byte[(int) file.length()];
	 * 
	 * try { FileInputStream fileInputStream = new FileInputStream(file); // convert
	 * file into array of bytes fileInputStream.read(bFile);
	 * fileInputStream.close(); } catch (Exception e) { e.printStackTrace(); }
	 * 
	 * Product product = new Product();
	 * product.setName("ADIDAS ORIGINALS PHARRELL WILLIAMS SUPERSTAR SHOES");
	 * product.setCategory("sports"); product.
	 * setDescription("For the last half-century, the adidas Superstar shoes have had an undeniable and continuing impact on our cultural landscape. Pharrell Williams once again teams up with adidas to evolve that legacy, revamping the icon with updated materials."
	 * ); product.setPrice(14999.99); product.setQuantity(25);
	 * product.setImage(bFile);
	 * 
	 * template.save(product); System.out.println("product saved");
	 * 
	 * }
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Product> getProducts(String category) throws SerialException, SQLException, IOException {

		Session session = this.sessionFactory.getCurrentSession();
		String hql = "from Product product where product.category ='" + category + "'";
		List<Product> productList = session.createQuery(hql).list();
		System.out.println("query executed");
		for (Product product : productList) {
			
			if(product.getBase64Image()==null)
			{
				byte[] image = product.getImage();
				Blob blob = new SerialBlob(image);

				InputStream inputStream = blob.getBinaryStream();
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				byte[] buffer = new byte[4096];
				int bytesRead = -1;

				while ((bytesRead = inputStream.read(buffer)) != -1) {
					outputStream.write(buffer, 0, bytesRead);
				}

				byte[] imageBytes = outputStream.toByteArray();
				String base64Image = Base64.getEncoder().encodeToString(imageBytes);

				inputStream.close();
				outputStream.close();

				System.out.println("query executed1");
				product.setBase64Image(base64Image);
				System.out.println("query executed2");
			}
			
		}
		return productList;

	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public Product getProductDetails(String productCode)
	{
		System.out.println("detail dao is called");
		Session session = this.sessionFactory.getCurrentSession();
		System.out.println("session is created");
		String hql = "from Product product where product.productCode ='" +productCode+"'" ;
		List<Product> productData = session.createQuery(hql).list();
		Product product = productData. get(0);
		
		return product;
		
	}
	
	@Transactional
	public void updateProduct(Product product)
	{
		Session session = this.sessionFactory.getCurrentSession();
		session.update(product);
		
	}

}
