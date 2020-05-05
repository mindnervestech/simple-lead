package com.mnt.crm.app.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public interface CustomerTag {
	
	String getFirstName();
	String getLastName();
	String getEmail();
	@JsonIgnore
	String getTag();

}
