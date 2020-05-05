package com.mnt.crm.app.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Table(name="customer")
@Entity
@Data
public class Customer {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	
	@Column(name="first_name", length=30)
	private String firstName;
	
	@Column(name="last_name", length=30)
	private String lastName;
	
	@Column(name="email", length=50)
	private String email;
	
	@Column(name="remarks", length=255)
	private String remarks;
	
	@Column(name="sales_guid", length=33)
	private String salesGuid;
	
	@Column(name="deleted")
	private Boolean deleted;
	
	@Column(name="created_date")
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date createdDate;
	
	@Column(name="modified_date")
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date modifiedDate;
	
	/*
	 * Ideally this should be List, but assignment explicitly mentioned to have two attributes 
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
	private List<CustomerExtraAttributes> customerExtraAttributes;
	*/
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "customer")
	private CustomerExtraAttributes customerExtraAttributes1;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "customer")
	private CustomerExtraAttributes customerExtraAttributes2;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
	private List<CustomerTags> customerTags;

}
