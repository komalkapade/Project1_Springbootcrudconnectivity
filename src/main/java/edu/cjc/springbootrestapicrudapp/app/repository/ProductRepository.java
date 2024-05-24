package edu.cjc.springbootrestapicrudapp.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.cjc.springbootrestapicrudapp.app.model.Product;

@Repository
public interface ProductRepository  extends JpaRepository<Product,Integer>
{

	public Product findByProductName(String productName);

	
}