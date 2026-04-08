package com.axonivy.connector.jira.utils;

import java.util.HashMap;
import java.util.Map;

public class IssueUtils {

	public static String prepareIssueFields(Map<String, Object> updateFields) {
		Map<String, Object> fields = new HashMap<>();
		fields.put("fields", updateFields);
		return JsonUtils.convertMapToJsonString(fields);
	}
}
