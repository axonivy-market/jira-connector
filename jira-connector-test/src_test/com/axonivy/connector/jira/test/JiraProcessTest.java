package com.axonivy.connector.jira.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import ch.ivyteam.ivy.bpm.engine.client.BpmClient;
import ch.ivyteam.ivy.bpm.engine.client.ExecutionResult;
import ch.ivyteam.ivy.bpm.engine.client.element.BpmElement;
import ch.ivyteam.ivy.bpm.engine.client.element.BpmProcess;
import ch.ivyteam.ivy.bpm.exec.client.IvyProcessTest;
import ch.ivyteam.ivy.scripting.objects.CompositeObject;

@IvyProcessTest
class JiraProcessTest {
  
  private static final BpmProcess createIssueTestProcess = BpmProcess.path("Test Processes/TestCreateIssue");
  
  @Test
  @Disabled
  void callProcess(BpmClient bpmClient){
    BpmElement startable = createIssueTestProcess.elementName("startCreateIssue.ivp");
    ExecutionResult result = bpmClient.start().process(startable).execute();
    CompositeObject data = result.data().last();
    com.axonivy.connector.jira.test.Data testData = (com.axonivy.connector.jira.test.Data) data;
    String createdIssueKey = testData.getIssueParent().getKey();
    assertThat(createdIssueKey).isNotEmpty();
  }

  @Test
  void test() {
    assertThat(true).isTrue();
  }
}
