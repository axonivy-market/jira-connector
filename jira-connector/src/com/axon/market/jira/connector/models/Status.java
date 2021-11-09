package com.axon.market.jira.connector.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Status {

	@JsonProperty("name")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
