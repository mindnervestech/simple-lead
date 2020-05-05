package com.mnt.crm.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Table(name="customer_tags")
@Entity
@Data
public class CustomerTags {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
		
	@Column(name="tags", length=50)
	private String value;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	@JsonIgnore
	private Customer customer;
}
