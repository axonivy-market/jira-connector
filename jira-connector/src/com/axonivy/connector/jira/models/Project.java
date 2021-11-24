package com.axonivy.connector.jira.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Project {
	

	@JsonProperty(value = "key")
	private String projKey;
	


	public String getProjKey() {
		return projKey;
	}

	public void setProjKey(String projKey) {
		this.projKey = projKey;
	}
	
	

}



