package edu.cjc.springbootrestapicrudapp.app.servicei;

import java.util.List;

import edu.cjc.springbootrestapicrudapp.app.model.Product;

public interface ProductServiceI {

	 Product saveProduct(Product p);

	 List<Product> getProducts();

	 Product updateProduct(Integer productId, Product p);
	 
	void deleteProduct(Integer productId);
	
	Product getProductByName (String productName);
}
