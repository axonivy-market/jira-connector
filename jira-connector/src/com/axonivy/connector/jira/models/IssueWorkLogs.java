package com.axonivy.connector.jira.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IssueWorkLogs {

	@JsonProperty("startAt")
	private int startAt;

	@JsonProperty("maxResults")
	private int maxResults;

	@JsonProperty("total")
	private int total;

	@JsonProperty("worklogs")
	private List<WorkLog> worklogs;

	public int getStartAt() {
		return startAt;
	}

	public void setStartAt(int startAt) {
		this.startAt = startAt;
	}

	public int getMaxResults() {
		return maxResults;
	}

	public void setMaxResults(int maxResults) {
		this.maxResults = maxResults;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<WorkLog> getWorklogs() {
		return worklogs;
	}

	public void setWorklogs(List<WorkLog> worklogs) {
		this.worklogs = worklogs;
	}

}
