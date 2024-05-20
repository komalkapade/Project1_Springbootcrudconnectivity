package edu.cjc.springbootrestapicrudapp.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.cjc.springbootrestapicrudapp.app.model.Product;
import edu.cjc.springbootrestapicrudapp.app.servicei.ProductServiceI;

@CrossOrigin
@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductServiceI psi;
	
	@PostMapping("/Product")
	public Product saveProduct(@RequestBody Product p)
	{
		Product product=psi.saveProduct(p);
		return product;
	}
	
	@GetMapping("/Products")
	public List<Product> getProducts()
	{
		List<Product> plist=psi.getProducts();
		return plist;
	}
	
	@PutMapping("/Product/{productId}")
	public Product updateProduct(@PathVariable Integer productId,@RequestBody Product p)
	{
		Product product=psi.updateProduct(productId,p);
		return product;
	}
	
	@DeleteMapping("/Product/{productId}")
	public void deleteProduct(@PathVariable Integer productId)
	{
		psi.deleteProduct(productId);
		}
}
