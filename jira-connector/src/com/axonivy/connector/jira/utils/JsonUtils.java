package com.axonivy.connector.jira.utils;

import java.util.Map;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ch.ivyteam.ivy.environment.Ivy;

public class JsonUtils {

	public static String convertMapToJsonString(Map<String, Object> map) {
		ObjectMapper mapper = new ObjectMapper();
		String jsonBody = null;
		try {
			jsonBody = mapper.writeValueAsString(map);
		} catch (JsonProcessingException e) {
			Ivy.log().error(e);
		}
		return jsonBody;
	}
}
