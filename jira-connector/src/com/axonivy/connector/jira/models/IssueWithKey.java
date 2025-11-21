package com.axonivy.connector.jira.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IssueWithKey {
	public IssueWithKey() {
	}

	public IssueWithKey(String key) {
		this.key = key;
	}

	@JsonProperty("key")
	private String key;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
}
