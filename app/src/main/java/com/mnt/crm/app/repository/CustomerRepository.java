package com.mnt.crm.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.mnt.crm.app.dto.CustomerTag;
import com.mnt.crm.app.dto.SalesAgeing;
import com.mnt.crm.app.model.Customer;

@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer,Long> {
	
	@Query("SELECT s.firstName as firstName, s.lastName as lastName, s.email as email, t.value as tag FROM Customer s JOIN s.customerTags t ")
	List<CustomerTag> groupByTags();
	
	@Query("SELECT c.createdDate as secondCreatedDate, p.createdDate as firstCreatedDate "
			+ "FROM Customer c JOIN Prospect p ON p.salesGuid = c.salesGuid ")
	List<SalesAgeing> prospectAgeing();
	
	@Query("SELECT p.createdDate as secondCreatedDate, l.createdDate as firstCreatedDate "
			+ "FROM Prospect p JOIN Lead l ON p.salesGuid = l.salesGuid ")
	List<SalesAgeing> leadAgeing();

}
