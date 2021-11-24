package com.axonivy.connector.jira.models;

/*
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
*/

public abstract class Writeable {

	/**
	 * Writes this object to a json string. If the root tag name is not a 
	 * empty string, the whole object is appended to a new root tag with 
	 * the name given in the parameter.
	 * @return
	 */ /*
	public String toJSONString(String rootTag) {
		ObjectMapper mapper = new ObjectMapper();
		String result = "";
        try {
        	result = mapper.writeValueAsString(this);
        	result = this.appendToRootTag(result, rootTag);
        } catch (Exception e) {
            e.printStackTrace();
        }
		return result;
	} */
	
	/**
	 * Writes this object to a XML string. If the root tag name is not a 
	 * empty string, the whole object is appended to a new root tag with 
	 * the name given in the parameter.
	 * @return
	 */ /*
	public String toXMLString(String rootTag) {
		String jsonString = this.toJSONString(rootTag);
		try {
		     JSONObject jsonObject = new JSONObject(jsonString);
		     return XML.toString(jsonObject);
		}catch (JSONException err){
		     Ivy.log().error("Error", err.toString());
		}
		return null;
	}
	
	private String appendToRootTag(String jsonString, String rootTag) {
		if(rootTag.equals("")) {
			return jsonString;
		}
		return "{" + rootTag + ":" + jsonString + "}";
	}
*/
}

