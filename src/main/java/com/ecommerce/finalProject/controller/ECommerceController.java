package com.ecommerce.finalProject.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ecommerce.finalProject.Services.ECommerceService;
import com.ecommerce.finalProject.Services.ProductService;
import com.ecommerce.finalProject.Entities.ECommerce;
import com.ecommerce.finalProject.Entities.Product;

@RestController
public class ECommerceController {
	public String uploadDir = "src/main/resources/static/newProduct";
	@Autowired
	private ECommerceService er;

	@PostMapping("register")
	public String registerUser(@RequestParam String name, @RequestParam String email, @RequestParam String password) {
		ECommerce e = new ECommerce();
		e.setEmail(email);
		e.setName(name);
		e.setPassword(password);
		er.save(e);
		String message = "User inserted";
		return "<script>alert('" + message + "');</script>";
	}

	@GetMapping("register")
	public ModelAndView reg() {
		return new ModelAndView("Register");
	}

	@GetMapping("index")
	public ModelAndView index() {
		return new ModelAndView("index");
	}

	@GetMapping("about")
	public ModelAndView about() {
		return new ModelAndView("about");
	}

	@GetMapping("login")
	public ModelAndView login() {
		return new ModelAndView("Login");
	}

	@PostMapping("login")
	public ModelAndView login(@RequestParam("email") String email, @RequestParam("password") String password,
			Model model) {

		ECommerce user = er.findByemail(email);

		if (user != null && user.getPassword().equals(password)) {
			// User found and password matches
//	            model.addAttribute("message", "Login successful!");
			return new ModelAndView("redirect:index"); // Redirect to success page
		} else {
			// User not found or password does not match
//	            model.addAttribute("error", "Invalid credentials");
			return new ModelAndView("redirect:login"); // Redirect back to login page
		}
	}

	@Autowired
	private ProductService ps;

	@GetMapping("Add_Items")
	public ModelAndView item(Model model) {
		model.addAttribute("Product", new Product());
		return new ModelAndView("Add_Items");
	}

	@PostMapping("product")
	public ModelAndView addproduct(@Validated @ModelAttribute("product") Product product, BindingResult bindingResult,
            @RequestParam("productImage") MultipartFile file) throws IOException {
		
		String imageUUID;
		if (!file.isEmpty()) {
			imageUUID = file.getOriginalFilename();
			Path fileNameAndPath = Paths.get(uploadDir, imageUUID);
			Files.write(fileNameAndPath, file.getBytes());
		} else {
			imageUUID = product.getImgurl();
		}
		product.setImgurl(imageUUID);
		ps.addProduct(product);
		return new ModelAndView("redirect:product");
	}

	@GetMapping("product")
	public ModelAndView product(Model model) {

		model.addAttribute("product", ps.getAllProduct());
		return new ModelAndView("product");
	}
}