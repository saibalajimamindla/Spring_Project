package com.Spring.Controller;

import java.io.IOException;
import java.sql.SQLException;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Spring.Dao.AppDataDao;
import com.Spring.Model.Product;
import com.Spring.Service.AppDataService;

@Controller
public class AppDataController {

	@Autowired
	AppDataDao appDataDao;

	@Autowired
	AppDataService appDataService;

	@RequestMapping("/homepage")
	public ModelAndView homePage(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("Homepage");
		mav=appDataService.addHeaderButtons(mav);
		
		return mav;
	}

	@RequestMapping(value = "/requestplp/{category}")
	public ModelAndView productList(HttpServletRequest request, HttpServletResponse response,
			@PathVariable String category) throws SerialException, SQLException, IOException {
		List<Product> products = appDataDao.getProducts(category);
		ModelAndView mav = new ModelAndView("listpage");
		mav.addObject("listProducts", products);
		/* mav = appDataService.checkLoginSatatus(request, mav); */
		mav=appDataService.addHeaderButtons(mav);
	
		return mav;

	}

	@RequestMapping("/detailpage/{productCode}")
	public ModelAndView productDetail(HttpServletRequest request, HttpServletResponse response,
			@PathVariable String productCode) {
		System.out.println("detail controller is called");
		Product product = appDataDao.getProductDetails(productCode);
		ModelAndView mav = new ModelAndView("detailpage");
		mav.addObject("productDetails", product);
		/* mav = appDataService.checkLoginSatatus(request, mav); */
		mav=appDataService.addHeaderButtons(mav);

		return mav;

	}

}
