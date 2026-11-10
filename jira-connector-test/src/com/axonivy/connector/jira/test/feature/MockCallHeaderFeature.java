package com.axonivy.connector.jira.test.feature;

import java.io.IOException;

import jakarta.ws.rs.client.ClientRequestContext;
import jakarta.ws.rs.client.ClientRequestFilter;
import jakarta.ws.rs.core.Feature;
import jakarta.ws.rs.core.FeatureContext;

public class MockCallHeaderFeature implements Feature {
	private static final String REQUESTED_BY = "X-Requested-By";
	private static final String IVY = "ivy";

	@Override
	public boolean configure(FeatureContext context) {
		context.register(RequestFilter.class);
		return true;
	}

	private static class RequestFilter implements ClientRequestFilter {
		@Override
		public void filter(ClientRequestContext context) throws IOException {
			context.getHeaders().add(REQUESTED_BY, IVY);
		}
	}
}
