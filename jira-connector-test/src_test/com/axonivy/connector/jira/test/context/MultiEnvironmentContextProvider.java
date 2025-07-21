package com.axonivy.connector.jira.test.context;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.extension.Extension;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;
import org.junit.jupiter.api.extension.TestTemplateInvocationContext;
import org.junit.jupiter.api.extension.TestTemplateInvocationContextProvider;

import com.axonivy.connector.jira.test.constant.TestEnvironmentConstants;

public class MultiEnvironmentContextProvider implements TestTemplateInvocationContextProvider {
	@Override
	public boolean supportsTestTemplate(ExtensionContext context) {
		return true;
	}

	@Override
	public Stream<TestTemplateInvocationContext> provideTestTemplateInvocationContexts(ExtensionContext context) {
		return Stream.of(
//				new TestEnironmentInvocationContext(TestEnvironmentConstants.REAL_CALL_CONTEXT_DISPLAY_NAME),
				new TestEnironmentInvocationContext(TestEnvironmentConstants.MOCK_SERVER_CONTEXT_DISPLAY_NAME));
	}

	private class TestEnironmentInvocationContext implements TestTemplateInvocationContext {
		private String contextDisplayName;

		private TestEnironmentInvocationContext(String contextDisplayName) {
			this.contextDisplayName = contextDisplayName;
		}

		@Override
		public String getDisplayName(int invocationIndex) {
			return contextDisplayName;
		}

		@Override
		public List<Extension> getAdditionalExtensions() {
			return Collections.singletonList(new ParameterResolver() {

				@Override
				public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
						throws ParameterResolutionException {
					return extensionContext;
				}

				@Override
				public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
						throws ParameterResolutionException {
					return ExtensionContext.class == parameterContext.getParameter().getType();
				}
			});
		}
	}
}
