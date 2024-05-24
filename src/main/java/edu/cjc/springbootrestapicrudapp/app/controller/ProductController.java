package edu.cjc.springbootrestapicrudapp.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.logger.controller.EmployeeController;

import edu.cjc.springbootrestapicrudapp.app.model.Product;
import edu.cjc.springbootrestapicrudapp.app.servicei.ProductServiceI;
import jakarta.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductServiceI psi;
	
	Logger log=LoggerFactory.getLogger(ProductController.class);
	
	@PostMapping("/Product")
	public ResponseEntity<Product> saveProduct(@Valid @RequestBody Product p)
	{
		Product product=psi.saveProduct(p);
		
		log.info("Data saved Successfully......!");
		return new ResponseEntity<Product> (product,HttpStatus.CREATED);
	}
	
	@GetMapping(value="/Products",produces= {"application/json"})
	public ResponseEntity<List<Product>>  getProducts()
	{
		List<Product> plist=psi.getProducts();
		log.info("Get All Data...!");
		return new ResponseEntity<List<Product>>(plist,HttpStatus.OK);
	}
	
	@PutMapping("/Product/{productId}")
	public ResponseEntity<Product> updateProduct(@PathVariable Integer productId,@RequestBody Product p)
	{
		Product product=psi.updateProduct(productId,p);
		System.out.println("Data updated successfully....!");
		return new ResponseEntity<Product> (product,HttpStatus.OK);
	}
	
	@DeleteMapping("/Product/{productId}")
	public ResponseEntity deleteProduct(@PathVariable Integer productId)
	{
		psi.deleteProduct(productId);
		log.info("Data Deleted.....!");
		return new ResponseEntity(HttpStatus.NO_CONTENT);
		
	}
	
	@GetMapping("/searchproduct/{productName}")
	public ResponseEntity<Product> getProductByName(@PathVariable String productName)
	{
		try {
		Product product=psi.getProductByName(productName);
		log.info("Found product by Name.....!");
		return new ResponseEntity<Product>(product,HttpStatus.OK);
		}
		catch(Exception e)
		{
			
			log.error("Data not found.....!");
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	// this extra method is only for refferncing a bad internal server error 500
	// and how can we handdle the error by using try catch 
//	
//	@PostMapping("product/handdlestatuscode")
//	public ResponseEntity<Product> saveProduct(@RequestBody Product product)
//	{
//		try {
//				psi.saveProduct(product);
//				return new ResponseEntity(product,HttpStatus.OK);
//		}
//		catch(Exception e)
//		{
//				System.out.println("Internal server error");
//				return new ResponseEntity(product,HttpStatus.INTERNAL_SERVER_ERROR);
//		}
		
		
	}
	


	

