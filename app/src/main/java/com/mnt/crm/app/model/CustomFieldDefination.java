package com.mnt.crm.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Table(name="custom_field_defination")
@Entity
@Data
public class CustomFieldDefination {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	
	@Column(name="code", length=25)
	private String code;
	
	@Column(name="label", length=50)
	private String label;
	
	@Column(name="type", length=15)
	private String type;
	
	@Column(name="valid_value", length=255)
	private String validValue;
	
	@Column(name="deleted")
	private Boolean deleted;
	
	@Column(name="created_date")
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date createdDate;
	
	@Column(name="modified_date")
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date modifiedDate;
	
	



}
