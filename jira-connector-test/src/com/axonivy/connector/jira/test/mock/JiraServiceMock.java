package com.axonivy.connector.jira.test.mock;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.annotation.security.PermitAll;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.swagger.v3.oas.annotations.Hidden;

@Path("jiraMock")
@PermitAll
@Hidden
public class JiraServiceMock {

	@GET
	@Path("issue/{issueKey}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response readIssue(@PathParam("issueKey") String issueKey) {
		return Response.status(200).entity(load("issue.json")).build();
	}

	@POST
	@Path("issue/{key}/comment")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createComment(@PathParam(value = "key") String issueKey) {
		return Response.status(201).entity(load("createComment.json")).build();
	}
	
	
	@POST
	@Path("issue")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createComment() {
		return Response.status(201).entity(load("createIssue.json")).build();
	}
	
	
	@POST
	@Path("issue/{key}/worklog")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createWorklog(@PathParam(value = "key") String issueKey) {
		return Response.status(201).entity(load("createWorklog.json")).build();
	}

	private static String load(String path) {
		try (var is = JiraServiceMock.class.getResourceAsStream(path)) {
			return new String(is.readAllBytes(), StandardCharsets.UTF_8);
		} catch (IOException ex) {
			throw new RuntimeException("Failed to read resource: " + path);
		}
	}
}
