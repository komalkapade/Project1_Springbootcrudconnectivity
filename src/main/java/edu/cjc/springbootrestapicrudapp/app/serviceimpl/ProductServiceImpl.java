package edu.cjc.springbootrestapicrudapp.app.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import edu.cjc.springbootrestapicrudapp.app.model.Product;
import edu.cjc.springbootrestapicrudapp.app.repository.ProductRepository;
import edu.cjc.springbootrestapicrudapp.app.servicei.ProductServiceI;

@Service
public class ProductServiceImpl implements ProductServiceI{

	@Autowired
	ProductRepository pr;
	
	@Override
	public Product saveProduct(Product p) {
		return pr.save(p);
	}

	@Override
	public List<Product> getProducts() {
		return pr.findAll();
	}

	@Override
	public Product updateProduct(@PathVariable Integer productId ,@RequestBody Product p) {
		
		Optional<Product> op		=pr.findById(productId);
		 if(op.isPresent()) {
			 Product product=op.get();
			 if(p.getProductName()!=null) {
				 product.setProductName(p.getProductName());
			 if(p.getProductType()!=null) {
				product.setProductType(p.getProductType());	 
				 }
			 if(p.getProductPrice()!=null) {
				 product.setProductPrice(p.getProductPrice());
			 }
			
			 }
			 return pr.save(product); 
		 }else {
			 return null; 
		 }
	}

	@Override
	public void deleteProduct(Integer productId) {
		
		pr.deleteById(productId);
	}

	
}
