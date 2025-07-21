package com.axonivy.connector.jira.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.TestTemplate;

import com.axonivy.connector.jira.models.SearchIssue;
import com.axonivy.connector.jira.models.SearchProjectRequest;

import ch.ivyteam.ivy.bpm.engine.client.BpmClient;
import ch.ivyteam.ivy.bpm.engine.client.ExecutionResult;
import ch.ivyteam.ivy.bpm.engine.client.element.BpmElement;
import ch.ivyteam.ivy.bpm.engine.client.element.BpmProcess;

class JiraProcessTest extends MultiEnvironmentTestingSetup {

  @TestTemplate
  void test_createComment(BpmClient bpmClient) {
    var process = BpmProcess.path("Jira/CreateComment");
    BpmElement startable = process.elementName("call(String,String)");
    ExecutionResult result = bpmClient.start().subProcess(startable).execute("SCRUM-3", "test");
    com.axonivy.connector.jira.Data testData = (com.axonivy.connector.jira.Data) result.data().last();
    assertThat(testData.getError()).isNull();
  }

  @TestTemplate
  void test_createIssue(BpmClient bpmClient) {
    var process = BpmProcess.path("Jira/CreateIssue");
    BpmElement startable = process.elementName("call(String,String,String,String)");
    ExecutionResult result = bpmClient.start().subProcess(startable).execute("SCRUM", "100003", "test ticket",
        "test summary");
    com.axonivy.connector.jira.Data testData = (com.axonivy.connector.jira.Data) result.data().last();
    assertThat(testData.getIssueParent().getKey()).isNotBlank();
  }

  @TestTemplate
  void test_createWorklog(BpmClient bpmClient) {
    var process = BpmProcess.path("Jira/CreateWorkLog");
    BpmElement startable = process.elementName("call(String,String,String,String)");
    ExecutionResult result = bpmClient.start().subProcess(startable).execute("SCRUM", "100003", "test ticket",
        "test summary");
    com.axonivy.connector.jira.Data testData = (com.axonivy.connector.jira.Data) result.data().last();
    assertThat(testData.getIssueParent().getKey()).isNotBlank();
  }

  @TestTemplate
  void test_deleteWorklog(BpmClient bpmClient) {
    var process = BpmProcess.path("Jira/DeleteWorkLog");
    BpmElement startable = process.elementName("call(String,String,String,String)");
    ExecutionResult result = bpmClient.start().subProcess(startable).execute("10008", "10000", "10001",
        "712020:62df8cc7-3c71-4c50-895d-fc01c9208d3f");
    com.axonivy.connector.jira.Data testData = (com.axonivy.connector.jira.Data) result.data().last();
    assertThat(testData.getError()).isNull();
  }

  @TestTemplate
  void test_getIssue(BpmClient bpmClient) {
    var process = BpmProcess.path("Jira/GetIssue");
    BpmElement startable = process.elementName("call(String)");
    ExecutionResult result = bpmClient.start().subProcess(startable).execute("SCRUM-3");
    com.axonivy.connector.jira.Data testData = (com.axonivy.connector.jira.Data) result.data().last();
    assertThat(testData.getIssueParent().getKey()).isEqualTo("SCRUM-3");
    assertThat(testData.getIssueParent().getFields().getSummary()).isEqualTo("(Sample) Optimize Site for Mobile View");
  }

  @TestTemplate
  void test_getIssueWorkLog(BpmClient bpmClient) {
    var process = BpmProcess.path("Jira/GetIssueWorkLogs");
    BpmElement startable = process.elementName("call(String)");
    ExecutionResult result = bpmClient.start().subProcess(startable).execute("SCRUM-9");
    com.axonivy.connector.jira.Data testData = (com.axonivy.connector.jira.Data) result.data().last();
    assertThat(testData.getIssueWorkLogs().getWorklogs().size()).isEqualTo(1);
    assertThat(testData.getIssueWorkLogs().getWorklogs().get(0).getTimeSpentSeconds()).isEqualTo(0);
  }

  @TestTemplate
  void test_getProjects(BpmClient bpmClient) {
    var process = BpmProcess.path("Jira/GetProjects");
    BpmElement startable = process.elementName("call(SearchProjectRequest)");
    ExecutionResult result = bpmClient.start().subProcess(startable).execute(new SearchProjectRequest());
    com.axonivy.connector.jira.ProjectData projectData = (com.axonivy.connector.jira.ProjectData) result.data().last();
    assertThat(projectData.getSearchResponse().getValues().size()).isEqualTo(1);
    assertThat(projectData.getSearchResponse().getValues().get(0).getName()).isEqualTo("Octopus-AxonIvy");
  }

  @TestTemplate
  void test_getSearchIssue(BpmClient bpmClient) {
    var process = BpmProcess.path("Jira/SearchIssueJQL");
    BpmElement startable = process.elementName("call(SearchIssue)");
    ExecutionResult result = bpmClient.start().subProcess(startable).execute(new SearchIssue());
    com.axonivy.connector.jira.Data testData = (com.axonivy.connector.jira.Data) result.data().last();
    assertThat(testData.getIssueParent().getKey()).isEqualTo("SCRUM-3");
    assertThat(testData.getIssueParent().getFields().getSummary()).isEqualTo("(Sample) Optimize Site for Mobile View");
  }
}
