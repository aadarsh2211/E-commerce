package com.ecommerce.finalProject.Services;

import org.springframework.data.repository.CrudRepository;

import com.ecommerce.finalProject.Entities.ECommerce;


public interface ECommerceService extends CrudRepository<ECommerce, Long> {
	   ECommerce findByemail(String email);
}



