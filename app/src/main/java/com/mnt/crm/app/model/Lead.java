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

@Table(name="lead")
@Entity
@Data
public class Lead {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	
	@Column(name="title", length=15)
	private String title;
	
	@Column(name="lead_source", length=15)
	private String leadSource;
	
	@Column(name="lead_type", length=15)
	private String leadType;
	
	@Column(name="remarks", length=255)
	private String remarks;
	
	@Column(name="sales_guid", length=33)
	private String salesGuid;
	
	@Column(name="status", length=10)
	private String status;
	
	@Column(name="created_date")
	@Temporal(value=TemporalType.TIMESTAMP)
	private Date createdDate;



}
