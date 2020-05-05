package com.mnt.crm.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mnt.crm.app.dto.CustomerTag;
import com.mnt.crm.app.model.Customer;
import com.mnt.crm.app.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping(value="/customers")
	public ResponseEntity<List<Customer>> getAllCustomer(
			 @RequestParam(defaultValue = "0") Integer pageNo, 
             @RequestParam(defaultValue = "10") Integer pageSize,
             @RequestParam(defaultValue = "firstName") String sortBy) {
		
		List<Customer> list = customerService.getAllCustomer(pageNo, pageSize, sortBy);
		 
        return new ResponseEntity<List<Customer>>(list, new HttpHeaders(), HttpStatus.OK); 
		
	}
	
	@GetMapping(value="/customers/tag/group")
	public ResponseEntity<Map<String,List<CustomerTag>>> getCustomerGroupByTag() {
		
		Map<String,List<CustomerTag>> list = customerService.getCustomerGroupByTag();
		 
        return new ResponseEntity<Map<String,List<CustomerTag>>>(list, new HttpHeaders(), HttpStatus.OK); 
		
	}
	
	@GetMapping(value="/customers/sales/ageing")
	public ResponseEntity<Map<String,Float>> salesAgeging() {
		
		Map<String,Float> ret = new HashMap<String,Float>();
		
		ret.put("Average Ageing of Prospect", customerService.calculateProspectSalesAgeing());
		ret.put("Average Ageing of Lead", customerService.calculateLeadSalesAgeing());
		
		return new ResponseEntity<Map<String,Float>>(ret, new HttpHeaders(), HttpStatus.OK);
	}

}
