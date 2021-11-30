package com.axonivy.connector.jira.models;

import java.util.List;

import org.apache.commons.lang3.ObjectUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CommentList {

	@JsonProperty("comments")
	private List<Comment> comments;

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	};

	@JsonIgnore
	public Comment getLatestComment() {
		if(ObjectUtils.isNotEmpty(comments)) {
			return comments.get(comments.size() - 1);
		}
		return null;
	}
}
