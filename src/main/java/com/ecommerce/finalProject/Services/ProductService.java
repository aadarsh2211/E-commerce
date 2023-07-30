package com.ecommerce.finalProject.Services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.finalProject.Entities.Product;
import com.ecommerce.finalProject.Repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;
	
	public List<Product> getAllProduct() {
		return productRepository.findAll();
	}
	public void addProduct(Product product) {
		productRepository.save(product);
	}
}
