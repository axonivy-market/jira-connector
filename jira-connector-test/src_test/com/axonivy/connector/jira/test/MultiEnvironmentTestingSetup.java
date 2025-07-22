package com.axonivy.connector.jira.test;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;

import com.axonivy.connector.jira.test.constant.TestEnvironmentConstants;
import com.axonivy.connector.jira.test.context.MultiEnvironmentContextProvider;
import com.axonivy.connector.jira.test.feature.MockCallHeaderFeature;

import ch.ivyteam.ivy.application.IApplication;
import ch.ivyteam.ivy.bpm.exec.client.IvyProcessTest;
import ch.ivyteam.ivy.environment.AppFixture;
import ch.ivyteam.ivy.rest.client.mapper.JsonFeature;

@IvyProcessTest(enableWebServer = true)
@ExtendWith(MultiEnvironmentContextProvider.class)
public class MultiEnvironmentTestingSetup {

  @BeforeEach
  void setUpConfigForContext(ExtensionContext context, AppFixture fixture, IApplication app) {
    switch (context.getDisplayName()) {
    case TestEnvironmentConstants.REAL_CALL_CONTEXT_DISPLAY_NAME:
      setUpConfigForApiTest(fixture);
      break;
    case TestEnvironmentConstants.MOCK_SERVER_CONTEXT_DISPLAY_NAME:
      setUpConfigForMockServer(fixture, app);
      break;
    default:
      break;
    }
  }

  public static void setUpConfigForApiTest(AppFixture fixture) {
    fixture.var("jiraConnector.Url", System.getProperty(TestEnvironmentConstants.URL_PROPERTY_NAME));
    fixture.var("jiraConnector.Username", System.getProperty(TestEnvironmentConstants.USERNAME_PROPERTY_NAME));
    fixture.var("jiraConnector.Password", System.getProperty(TestEnvironmentConstants.PASSWORD_PROPERTY_NAME));

  }

  public static void setUpConfigForMockServer(AppFixture fixture, IApplication app) {
    fixture.config("RestClients.Jira.Features",
        List.of(MockCallHeaderFeature.class.getName(), JsonFeature.class.getName()));
    fixture.var("jiraConnector.Url", "{ivy.app.baseurl}/api/jiraMock");
  }
}
