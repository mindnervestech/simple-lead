package com.mnt.crm.app.model;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
    private Long id;
	
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
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
	private List<CustomerExtraAttributes> customerExtraAttributes;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
	private List<CustomerTags> customerTags;
	
	public Map<String, String> toMap() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("firstName", this.firstName);
		map.put("lastName", this.lastName);
		map.put("email", this.email);
		this.customerExtraAttributes.stream().forEach(w -> {
			map.put(w.getCode(), w.getValue());
		});
		return map;
	}

}
