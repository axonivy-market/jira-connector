package com.axonivy.connector.jira.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ch.ivyteam.ivy.bpm.engine.client.BpmClient;
import ch.ivyteam.ivy.bpm.engine.client.ExecutionResult;
import ch.ivyteam.ivy.bpm.engine.client.element.BpmElement;
import ch.ivyteam.ivy.bpm.engine.client.element.BpmProcess;
import ch.ivyteam.ivy.bpm.exec.client.IvyProcessTest;
import ch.ivyteam.ivy.environment.AppFixture;

@IvyProcessTest(enableWebServer = true)
class JiraProcessTest {
 
  @BeforeEach
  void beforeEach(AppFixture fixture) { 
    fixture.var("jira-connector.Url", "{ivy.app.baseurl}/api/jira");
  }
	
  @Test
  void getIssue(BpmClient bpmClient){
	var getIssueProcess = BpmProcess.path("Jira/GetIssue");
	BpmElement startable = getIssueProcess.elementName("call(String)");
    ExecutionResult result = bpmClient.start().subProcess(startable).execute("JIRA-123");
    com.axonivy.connector.jira.Data testData = (com.axonivy.connector.jira.Data) result.data().last();
    assertThat(testData.getIssueParent().getKey()).isEqualTo("JIRA-123");
    assertThat(testData.getIssueParent().getFields().getSummary()).isEqualTo("Summary of JIRA-123");
  }
}
