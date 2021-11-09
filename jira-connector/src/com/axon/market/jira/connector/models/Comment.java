package com.axon.market.jira.connector.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Comment {

	@JsonProperty("body")
	private String body;

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	
}