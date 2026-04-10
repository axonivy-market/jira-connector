package com.axonivy.connector.jira.demo;

import java.util.HashMap;
import java.util.Map;

public class DemoUtils {

	public static Map<String, Object> buildIssueField(String fieldId, String value) {
		Map<String, Object> field = new HashMap<>();
		field.put(fieldId, autoParse(value));
		return field;
	}

	public static Object autoParse(String value) {
		if (value == null || value.isBlank()) {
			return null;
		}

		try {
			return Double.parseDouble(value);
		} catch (NumberFormatException e) {
			return value;
		}
	}
}
