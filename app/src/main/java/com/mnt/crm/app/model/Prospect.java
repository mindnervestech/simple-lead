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

@Table(name="prospect")
@Entity
@Data
public class Prospect {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	
	@Column(name="name", length=15)
	private String name;
	
	@Column(name="sales_stage", length=15)
	private String salesStage;
	
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
	
	@Column(name="amount")
	private Float amount;
	
	@Column(name="conversion_probaility")
	private Float probabilityPercent;



}
