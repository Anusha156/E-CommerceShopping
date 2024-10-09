package com.retailerservice.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.retailerservice.entity.Customer;
import com.retailerservice.entity.Product;
import com.retailerservice.service.RetailerServiceInterface;

@RestController
@RequestMapping("/retailer")
public class RetailerController {
	Logger log = Logger.getLogger("RetailerController");
	@Autowired
	private RetailerServiceInterface adminService;

	@PostMapping("/users")
	public Integer addCustomer(@RequestBody Product product) {
		int addCustomer = adminService.addProductService(product);

		System.out.println(addCustomer);
		return addCustomer;
	}

	@PostMapping("/customerLogin")
	public Customer loginCustomer(@RequestBody Customer customer) {
		Customer c = adminService.adminLoginService(customer);

		return c;
	}

	@GetMapping("/totalcountofcartitem/{cid}")
	public int totalcartitem(@PathVariable("cid") String cid) {
		return adminService.shopingcarttotalnoofitem(Integer.parseInt(cid));
	}

}
