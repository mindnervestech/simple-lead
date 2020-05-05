package com.mnt.crm.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mnt.crm.app.dto.CustomerTag;
import com.mnt.crm.app.dto.SalesAgeing;
import com.mnt.crm.app.model.Customer;
import com.mnt.crm.app.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	
	
	public List<Customer> getAllCustomer(Integer pageNo, Integer pageSize, String sortBy)
    {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
 
        Page<Customer> pagedResult = customerRepository.findAll(paging);
         
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Customer>();
        }
    }
	
	public Map<String,List<CustomerTag>> getCustomerGroupByTag(){
		return customerRepository.groupByTags().stream().collect(Collectors.groupingBy(CustomerTag::getTag));
	}
	
	public float calculateProspectSalesAgeing() {
		
		List<SalesAgeing> listOfAging = customerRepository.prospectAgeing();
		return calculateTimeDiff(listOfAging);
	}
	
	public float calculateLeadSalesAgeing() {
		List<SalesAgeing> listOfAging = customerRepository.leadAgeing();
		return calculateTimeDiff(listOfAging);
	}

	private float calculateTimeDiff(List<SalesAgeing> listOfAging) {
		long totalTimeDiff = 0;
		if(listOfAging != null && listOfAging.size() > 0) {
			for(SalesAgeing w : listOfAging) {
				totalTimeDiff += (w.getSecondCreatedDate().getTime() - w.getFirstCreatedDate().getTime());
			};
			return  ((float)(totalTimeDiff/listOfAging.size()))/(3600000*24);
		}
		return 0;
	}
	
	
	
	
}
