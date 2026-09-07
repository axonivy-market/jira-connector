package com.axonivy.connector.jira.test.mock;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import jakarta.annotation.security.PermitAll;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import io.swagger.v3.oas.annotations.Hidden;

@Path("jiraMock")
@PermitAll
@Hidden
public class JiraServiceMock {

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
  public Response createIssue() {
    return Response.status(201).entity(load("createIssue.json")).build();
  }

  @GET
  @Path("issue/{issueKey}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response readIssue(@PathParam("issueKey") String issueKey) {
    return Response.status(200).entity(load("issue.json")).build();
  }

  @POST
  @Path("issue/{key}/worklog")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response createWorklog(@PathParam(value = "key") String issueKey) {
    return Response.status(201).entity(load("createWorklog.json")).build();
  }

  @DELETE
  @Path("issue/{key}/worklog/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response createWorklog(@PathParam(value = "key") String issueKey, @PathParam(value = "id") String workLogId) {
    return Response.noContent().build();
  }

  @GET
  @Path("/issue/{key}/worklog")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getIssueWorkLog(@PathParam(value = "key") String issueKey,
      @PathParam(value = "id") String workLogId) {
    return Response.status(200).entity(load("getWorklog.json")).build();
  }

  @GET
  @Path("project/search")
  @Produces(MediaType.APPLICATION_JSON)
  public Response projectSearch() {
    return Response.status(200).entity(load("project.json")).build();
  }
  
  @PUT
  @Path("issue/{key}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response putIssueFields(@PathParam(value = "key") String issueKey) {
	  return Response.noContent().build();
  }

  private static String load(String path) {
    try (var is = JiraServiceMock.class.getResourceAsStream(path)) {
      return new String(is.readAllBytes(), StandardCharsets.UTF_8);
    } catch (IOException ex) {
      throw new RuntimeException("Failed to read resource: " + path);
    }
  }
}
