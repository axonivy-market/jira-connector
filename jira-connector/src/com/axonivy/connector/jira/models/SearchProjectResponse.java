package com.axonivy.connector.jira.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class SearchProjectResponse {

	@JsonProperty("maxResults")
	private int maxResults;

	@JsonProperty("startAt")
	private Long startAt;

	@JsonProperty("total")
	private Long total;

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

	public Long getStartAt() {
		return startAt;
	}

	public void setStartAt(Long startAt) {
		this.startAt = startAt;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
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