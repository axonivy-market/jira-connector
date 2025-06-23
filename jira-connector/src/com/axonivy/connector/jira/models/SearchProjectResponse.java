package com.axonivy.connector.jira.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class SearchProjectResponse {

	@JsonProperty("maxResults")
	private int maxResults;

	@JsonProperty("startAt")
	private int startAt;

	@JsonProperty("total")
	private int total;

	@JsonProperty("isLast")
	private boolean isLast;

	@JsonProperty("values")
	private List<Project> values;

	public int getMaxResults() {
		return maxResults;
	}

	public void setMaxResults(int maxResults) {
		this.maxResults = maxResults;
	}

	public int getStartAt() {
		return startAt;
	}

	public void setStartAt(int startAt) {
		this.startAt = startAt;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public boolean isLast() {
		return isLast;
	}

	public void setLast(boolean last) {
		isLast = last;
	}

	public List<Project> getValues() {
		return values;
	}

	public void setValues(List<Project> values) {
		this.values = values;
	}
}