package com.axonivy.connector.jira.test.mock;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.annotation.security.PermitAll;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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

  private static String load(String path) {
    try (var is = JiraServiceMock.class.getResourceAsStream(path)) {
      return new String(is.readAllBytes(), StandardCharsets.UTF_8);
    } catch (IOException ex) {
      throw new RuntimeException("Failed to read resource: " + path);
    }
  }
}
