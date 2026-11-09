package com.axonivy.connector.jira.utils;

import java.util.Map;

import ch.ivyteam.ivy.environment.Ivy;
import tools.jackson.databind.ObjectMapper;

public class JsonUtils {

	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

	public static String convertMapToJsonString(Map<String, Object> map) {
		String jsonBody = null;
		try {
			jsonBody = OBJECT_MAPPER.writeValueAsString(map);
		} catch (Exception e) {
			Ivy.log().error("Failed to serialize map to JSON string", e);
		}
		return jsonBody;
	}
}
