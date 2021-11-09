package com.axon.market.jira.connector.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IssueParent extends Writeable {
	
	@JsonProperty("key")
	private String key;
	
	@JsonProperty("fields")
	private Issue fields = new Issue();

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Issue getFields() {
		return fields;
	}

	public void setFields(Issue fields) {
		this.fields = fields;
	}

}
