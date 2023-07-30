package com.ecommerce.finalProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.finalProject.Entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
