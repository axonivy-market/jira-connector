package com.axonivy.connector.jira.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class SearchIssue {

	@JsonProperty("expand")
	@JsonInclude(Include.NON_NULL)
	private List<String> expand;

	@JsonProperty("fields")
	@JsonInclude(Include.NON_NULL)
	private List<String> fields;

	@JsonProperty("fieldsByKeys")
	private boolean fieldsByKeys;

	@JsonProperty("jql")
	@JsonInclude(Include.NON_NULL)
	private String jql;

	@JsonProperty("maxResults")
	private int maxResults;

	@JsonProperty("startAt")
	@JsonInclude(Include.NON_NULL)
	private Integer startAt;

	@JsonProperty("validateQuery")
	@JsonInclude(Include.NON_NULL)
	private String validateQuery;

	public List<String> getExpand() {
		return expand;
	}

	public void setExpand(List<String> expand) {
		this.expand = expand;
	}

	public List<String> getFields() {
		return fields;
	}

	public void setFields(List<String> fields) {
		this.fields = fields;
	}

	public boolean isFieldsByKeys() {
		return fieldsByKeys;
	}

	public void setFieldsByKeys(boolean fieldsByKeys) {
		this.fieldsByKeys = fieldsByKeys;
	}

	public String getJql() {
		return jql;
	}

	public void setJql(String jql) {
		this.jql = jql;
	}

	public int getMaxResults() {
		return maxResults;
	}

	public void setMaxResults(int maxResults) {
		this.maxResults = maxResults;
	}

	public Integer getStartAt() {
		return startAt;
	}

	public void setStartAt(Integer startAt) {
		this.startAt = startAt;
	}

	public String getValidateQuery() {
		return validateQuery;
	}

	public void setValidateQuery(String validateQuery) {
		this.validateQuery = validateQuery;
	}

}