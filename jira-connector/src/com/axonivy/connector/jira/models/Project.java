package com.axonivy.connector.jira.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Project {

	@JsonProperty("id")
	private String id;

	@JsonProperty("key")
	private String projKey;

	@JsonProperty("name")
	private String name;

	@JsonProperty("projectTypeKey")
	private String projectTypeKey;

	@JsonProperty("simplified")
	private Boolean simplified;

	@JsonProperty("style")
	private String style;

	@JsonProperty("isPrivate")
	private Boolean isPrivate;

	@JsonProperty("uuid")
	private String uuid;

	@JsonProperty("archived")
	private Boolean archived;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProjKey() {
		return projKey;
	}

	public void setProjKey(String projKey) {
		this.projKey = projKey;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProjectTypeKey() {
		return projectTypeKey;
	}

	public void setProjectTypeKey(String projectTypeKey) {
		this.projectTypeKey = projectTypeKey;
	}

	public Boolean getSimplified() {
		return simplified;
	}

	public void setSimplified(Boolean simplified) {
		this.simplified = simplified;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public Boolean getIsPrivate() {
		return isPrivate;
	}

	public void setIsPrivate(Boolean isPrivate) {
		this.isPrivate = isPrivate;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Boolean getArchived() {
		return archived;
	}

	public void setArchived(Boolean archived) {
		this.archived = archived;
	}

}