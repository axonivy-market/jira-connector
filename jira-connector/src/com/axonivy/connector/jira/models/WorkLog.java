package com.axonivy.connector.jira.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkLog {

	@JsonProperty("id")
	@JsonInclude(Include.NON_NULL)
	private String id;

	@JsonProperty("created")
	@JsonInclude(Include.NON_NULL)
	private String created;

	@JsonProperty("timeSpentSeconds")
	@JsonInclude(Include.NON_NULL)
	private int timeSpentSeconds;

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public int getTimeSpentSeconds() {
		return timeSpentSeconds;
	}

	public void setTimeSpentSeconds(int timeSpentSeconds) {
		this.timeSpentSeconds = timeSpentSeconds;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}