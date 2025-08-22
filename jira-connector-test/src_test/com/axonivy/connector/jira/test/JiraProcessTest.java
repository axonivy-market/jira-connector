package com.axonivy.connector.jira.test;

import static org.assertj.core.api.Assertions.assertThat;
import static com.axonivy.utils.e2etest.enums.E2EEnvironment.REAL_SERVER;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;

import com.axonivy.connector.jira.models.SearchProjectRequest;
import com.axonivy.connector.jira.models.WorkLog;
import com.axonivy.connector.jira.test.constant.TestEnvironmentConstants;
import com.axonivy.connector.jira.test.feature.MockCallHeaderFeature;
import com.axonivy.utils.e2etest.context.MultiEnvironmentContextProvider;
import com.axonivy.utils.e2etest.utils.E2ETestUtils;

import ch.ivyteam.ivy.bpm.engine.client.BpmClient;
import ch.ivyteam.ivy.bpm.engine.client.ExecutionResult;
import ch.ivyteam.ivy.bpm.engine.client.element.BpmElement;
import ch.ivyteam.ivy.bpm.engine.client.element.BpmProcess;
import ch.ivyteam.ivy.bpm.exec.client.IvyProcessTest;
import ch.ivyteam.ivy.environment.AppFixture;
import ch.ivyteam.ivy.rest.client.mapper.JsonFeature;

@IvyProcessTest(enableWebServer = true)
@ExtendWith(MultiEnvironmentContextProvider.class)
class JiraProcessTest {
  private boolean isRealTest;

  private interface PROCESS {
    BpmProcess CREATE_COMMENT = BpmProcess.path("Jira/CreateComment");
    BpmProcess CREATE_ISSUE = BpmProcess.path("Jira/CreateIssue");
    BpmProcess CREATE_WORK_LOG = BpmProcess.path("Jira/CreateWorkLog");
    BpmProcess DELETE_WORK_LOG = BpmProcess.path("Jira/DeleteWorkLog");
    BpmProcess GET_ISSUE = BpmProcess.path("Jira/GetIssue");
    BpmProcess GET_WORK_LOG = BpmProcess.path("Jira/GetIssueWorkLogs");
    BpmProcess GET_PROJECTS = BpmProcess.path("Jira/GetProjects");
  }

  @BeforeEach
  void setup(ExtensionContext context, AppFixture fixture) {
    isRealTest = context.getDisplayName().equals(REAL_SERVER.getDisplayName());
    E2ETestUtils.determineConfigForContext(context.getDisplayName(), runRealEnv(fixture), runMockEnv(fixture));
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
    ExecutionResult result =
        bpmClient.start().subProcess(startable).execute("SCRUM", "Task", "test ticket", "test summary");
    com.axonivy.connector.jira.Data testData = (com.axonivy.connector.jira.Data) result.data().last();
    assertThat(testData.getIssueParent().getKey()).isNotBlank();
  }

  @TestTemplate
  void test_worklog(ExtensionContext context, BpmClient bpmClient) throws InterruptedException {
    ExecutionResult result =
        bpmClient.start().subProcess(PROCESS.GET_WORK_LOG.elementName("call(String)")).execute("SCRUM-9");
    com.axonivy.connector.jira.Data testData = (com.axonivy.connector.jira.Data) result.data().last();
    List<WorkLog> workLogs = testData.getIssueWorkLogs().getWorklogs();
    assertThat(workLogs.size()).isEqualTo(1);
    assertThat(workLogs.get(0).getTimeSpentSeconds()).isEqualTo(0);
    String workLogId = workLogs.getFirst().getId();

    result = bpmClient.start().subProcess(PROCESS.DELETE_WORK_LOG.elementName("call(String,String,String,String)"))
        .execute("10008", workLogId, "AUTO", null);
    testData = (com.axonivy.connector.jira.Data) result.data().last();
    assertThat(testData.getError()).isNull();

    if (isRealTest) {
      result = bpmClient.start().subProcess(PROCESS.GET_WORK_LOG.elementName("call(String)")).execute("SCRUM-9");
      testData = (com.axonivy.connector.jira.Data) result.data().last();
      assertThat(testData.getIssueWorkLogs().getWorklogs().size()).isEqualTo(0);
    }

    var workLog = new WorkLog();
    workLog.setTimeSpentSeconds(0);
    result = bpmClient.start().subProcess(PROCESS.CREATE_WORK_LOG.elementName("call(String,WorkLog)"))
        .execute("SCRUM-9", workLog);
    testData = (com.axonivy.connector.jira.Data) result.data().last();
    workLogId = testData.getWorkLog().getId();
    assertThat(workLogId).isNotBlank();

    if (isRealTest) {
      result = bpmClient.start().subProcess(PROCESS.GET_WORK_LOG.elementName("call(String)")).execute("SCRUM-9");
      testData = (com.axonivy.connector.jira.Data) result.data().last();
      assertThat(testData.getIssueWorkLogs().getWorklogs().size()).isEqualTo(1);
    }
  }

  @TestTemplate
  void test_getIssue(BpmClient bpmClient) {
    BpmElement startable = PROCESS.GET_ISSUE.elementName("call(String)");
    ExecutionResult result = bpmClient.start().subProcess(startable).execute("SCRUM-3");
    com.axonivy.connector.jira.Data testData = (com.axonivy.connector.jira.Data) result.data().last();
    assertThat(testData.getIssueParent().getKey()).isEqualTo("SCRUM-3");
    assertThat(testData.getIssueParent().getFields().getSummary()).isEqualTo("(Sample) Optimize Site for Mobile View");
  }

  @TestTemplate
  void test_getProjects(BpmClient bpmClient) {
    BpmElement startable = PROCESS.GET_PROJECTS.elementName("call(SearchProjectRequest)");
    ExecutionResult result = bpmClient.start().subProcess(startable).execute(new SearchProjectRequest());
    com.axonivy.connector.jira.ProjectData projectData = (com.axonivy.connector.jira.ProjectData) result.data().last();
    assertThat(projectData.getSearchResponse().getValues().size()).isEqualTo(1);
    assertThat(projectData.getSearchResponse().getValues().get(0).getName()).isEqualTo("Octopus-AxonIvy");
  }

  private Runnable runRealEnv(AppFixture fixture) {
    return () -> {
      fixture.var("jiraConnector.Url", System.getProperty(TestEnvironmentConstants.URL_PROPERTY_NAME));
      fixture.var("jiraConnector.Username", System.getProperty(TestEnvironmentConstants.USERNAME_PROPERTY_NAME));
      fixture.var("jiraConnector.Password", System.getProperty(TestEnvironmentConstants.PASSWORD_PROPERTY_NAME));
    };
  }

  private Runnable runMockEnv(AppFixture fixture) {
    return () -> {
      fixture.config("RestClients.Jira.Features",
          List.of(MockCallHeaderFeature.class.getName(), JsonFeature.class.getName()));
      fixture.var("jiraConnector.Url", "{ivy.app.baseurl}/api/jiraMock");
    };
  }
}
