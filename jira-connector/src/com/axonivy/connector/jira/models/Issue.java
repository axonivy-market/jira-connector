package com.axonivy.connector.jira.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Issue {
	
	@JsonProperty("id")
	@JsonInclude(Include.NON_NULL)
	private String id;
	
	@JsonProperty("project")
	private Project project = new Project();
	
	@JsonProperty("summary")
	private String summary;
	
	@JsonProperty("description")
	private String description;
	
	@JsonProperty("issuetype")
	@JsonInclude(Include.NON_NULL)
	private Issuetype issuetype = new Issuetype();
	
	@JsonProperty("key")
	@JsonInclude(Include.NON_NULL)
	private String key;
	
	@JsonProperty("status")
	@JsonInclude(Include.NON_NULL)
	private Status status;
	
	@JsonProperty("reporter")
	@JsonInclude(Include.NON_NULL)
	private Reporter reporter;
	
	@JsonProperty("comment")
	@JsonInclude(Include.NON_NULL)
	private CommentList commentList;

	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	
	public String getSummary() {
		return summary;
	}
	
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Issuetype getIssuetype() {
		return issuetype;
	}
	public void setIssuetype(Issuetype issuetype) {
		this.issuetype = issuetype;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
	public Reporter getReporter() {
		return reporter;
	}
	
	public void setReporter(Reporter reporter) {
		this.reporter = reporter;
	}
	
	public CommentList getCommentList() {
		return commentList;
	}
	public void setCommentList(CommentList commentList) {
		this.commentList = commentList;
	}


}