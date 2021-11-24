package com.axonivy.connector.jira.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Reporter {
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("key")
	private String key;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

}
