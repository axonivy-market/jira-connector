package com.axonivy.connector.jira.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtensionContext;

import com.axonivy.connector.jira.models.SearchIssue;
import com.axonivy.connector.jira.models.SearchProjectRequest;
import com.axonivy.connector.jira.models.WorkLog;
import com.axonivy.connector.jira.test.constant.TestEnvironmentConstants;

import ch.ivyteam.ivy.bpm.engine.client.BpmClient;
import ch.ivyteam.ivy.bpm.engine.client.ExecutionResult;
import ch.ivyteam.ivy.bpm.engine.client.element.BpmElement;
import ch.ivyteam.ivy.bpm.engine.client.element.BpmProcess;

class JiraProcessTest extends MultiEnvironmentTestingSetup {

	private interface PROCESS {
		BpmProcess CREATE_COMMENT = BpmProcess.path("Jira/CreateComment");
		BpmProcess CREATE_ISSUE = BpmProcess.path("Jira/CreateIssue");
		BpmProcess CREATE_WORK_LOG = BpmProcess.path("Jira/CreateWorkLog");
		BpmProcess DELETE_WORK_LOG = BpmProcess.path("Jira/DeleteWorkLog");
		BpmProcess GET_ISSUE = BpmProcess.path("Jira/GetIssue");
		BpmProcess GET_WORK_LOG = BpmProcess.path("Jira/GetIssueWorkLogs");
		BpmProcess GET_PROJECTS = BpmProcess.path("Jira/GetProjects");
		BpmProcess SEARCH_ISSUE = BpmProcess.path("Jira/SearchIssueJQL");
	}

	@TestTemplate
	void test_createComment(BpmClient bpmClient) {
		BpmElement startable = PROCESS.CREATE_COMMENT.elementName("call(String,String)");
		ExecutionResult result = bpmClient.start().subProcess(startable).execute("SCRUM-3", "test");
		com.axonivy.connector.jira.Data testData = (com.axonivy.connector.jira.Data) result.data().last();
		assertThat(testData.getError()).isNull();
	}

	@TestTemplate
	void test_createIssue(BpmClient bpmClient) {
		BpmElement startable = PROCESS.CREATE_ISSUE.elementName("call(String,String,String,String)");
		ExecutionResult result = bpmClient.start().subProcess(startable).execute("SCRUM-10", "Task", "test ticket",
				"test summary");
		com.axonivy.connector.jira.Data testData = (com.axonivy.connector.jira.Data) result.data().last();
		assertThat(testData.getIssueParent().getKey()).isNotBlank();
	}

	@TestTemplate
	void test_worklog(ExtensionContext context, BpmClient bpmClient) {
		// get
		ExecutionResult result = bpmClient.start().subProcess(PROCESS.GET_WORK_LOG.elementName("call(String)"))
				.execute("SCRUM-9");
		com.axonivy.connector.jira.Data testData = (com.axonivy.connector.jira.Data) result.data().last();
		assertThat(testData.getIssueWorkLogs().getWorklogs().size()).isEqualTo(1);
		assertThat(testData.getIssueWorkLogs().getWorklogs().get(0).getTimeSpentSeconds()).isEqualTo(0);

		// delete
		result = bpmClient.start().subProcess(PROCESS.DELETE_WORK_LOG.elementName("call(String,String,String,String)"))
				.execute("10008", "10000", "10001", "712020:62df8cc7-3c71-4c50-895d-fc01c9208d3f");
		testData = (com.axonivy.connector.jira.Data) result.data().last();
		assertThat(testData.getError()).isNull();

		if (TestEnvironmentConstants.REAL_CALL_CONTEXT_DISPLAY_NAME.equals(context.getDisplayName())) {
			// get
			result = bpmClient.start().subProcess(PROCESS.GET_WORK_LOG.elementName("call(String)")).execute("SCRUM-9");
			testData = (com.axonivy.connector.jira.Data) result.data().last();
			assertThat(testData.getIssueWorkLogs().getWorklogs().size()).isEqualTo(0);
		}

		// Create
		var workLog = new WorkLog();
		workLog.setTimeSpentSeconds(0);
		result = bpmClient.start().subProcess(PROCESS.CREATE_WORK_LOG.elementName("call(String,WorkLog)"))
				.execute("SCRUM-9", workLog);
		testData = (com.axonivy.connector.jira.Data) result.data().last();
		String workLogId = testData.getWorkLog().getId();
		assertThat(workLogId).isNotBlank();

		if (TestEnvironmentConstants.REAL_CALL_CONTEXT_DISPLAY_NAME.equals(context.getDisplayName())) {
			// get
			result = bpmClient.start().subProcess(PROCESS.GET_WORK_LOG.elementName("call(String)")).execute("SCRUM-9");
			assertThat(testData.getIssueWorkLogs().getWorklogs().size()).isEqualTo(1);
		}

	}

	@TestTemplate
	void test_getIssue(BpmClient bpmClient) {
		BpmElement startable = PROCESS.GET_ISSUE.elementName("call(String)");
		ExecutionResult result = bpmClient.start().subProcess(startable).execute("SCRUM-3");
		com.axonivy.connector.jira.Data testData = (com.axonivy.connector.jira.Data) result.data().last();
		assertThat(testData.getIssueParent().getKey()).isEqualTo("SCRUM-3");
		assertThat(testData.getIssueParent().getFields().getSummary())
				.isEqualTo("(Sample) Optimize Site for Mobile View");
	}

	@TestTemplate
	void test_getProjects(BpmClient bpmClient) {
		BpmElement startable = PROCESS.GET_PROJECTS.elementName("call(SearchProjectRequest)");
		ExecutionResult result = bpmClient.start().subProcess(startable).execute(new SearchProjectRequest());
		com.axonivy.connector.jira.ProjectData projectData = (com.axonivy.connector.jira.ProjectData) result.data()
				.last();
		assertThat(projectData.getSearchResponse().getValues().size()).isEqualTo(1);
		assertThat(projectData.getSearchResponse().getValues().get(0).getName()).isEqualTo("Octopus-AxonIvy");
	}

	@TestTemplate
	void test_getSearchIssue(BpmClient bpmClient) {
		BpmElement startable = PROCESS.SEARCH_ISSUE.elementName("call(SearchIssue)");
		ExecutionResult result = bpmClient.start().subProcess(startable).execute(new SearchIssue());
		com.axonivy.connector.jira.Data testData = (com.axonivy.connector.jira.Data) result.data().last();
		assertThat(testData.getIssueParent().getKey()).isEqualTo("SCRUM-3");
		assertThat(testData.getIssueParent().getFields().getSummary())
				.isEqualTo("(Sample) Optimize Site for Mobile View");
	}
}
