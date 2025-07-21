package com.axonivy.connector.jira.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.TestTemplate;

import ch.ivyteam.ivy.bpm.engine.client.BpmClient;
import ch.ivyteam.ivy.bpm.engine.client.ExecutionResult;
import ch.ivyteam.ivy.bpm.engine.client.element.BpmElement;
import ch.ivyteam.ivy.bpm.engine.client.element.BpmProcess;

class JiraProcessTest extends MultiEnvironmentTestingSetup {

	@TestTemplate
	void test_getIssue(BpmClient bpmClient) {
		var process = BpmProcess.path("Jira/GetIssue");
		BpmElement startable = process.elementName("call(String)");
		ExecutionResult result = bpmClient.start().subProcess(startable).execute("SCRUM-3");
		com.axonivy.connector.jira.Data testData = (com.axonivy.connector.jira.Data) result.data().last();
		assertThat(testData.getIssueParent().getKey()).isEqualTo("SCRUM-3");
		assertThat(testData.getIssueParent().getFields().getSummary())
				.isEqualTo("(Sample) Optimize Site for Mobile View");
	}

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
		var process = BpmProcess.path("Jira/CreateWorklog");
		BpmElement startable = process.elementName("call(String,String,String,String)");
		ExecutionResult result = bpmClient.start().subProcess(startable).execute("SCRUM", "100003", "test ticket",
				"test summary");
		com.axonivy.connector.jira.Data testData = (com.axonivy.connector.jira.Data) result.data().last();
		assertThat(testData.getIssueParent().getKey()).isNotBlank();
	}
}
