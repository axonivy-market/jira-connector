package com.axonivy.connector.jira.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Parent {

  @JsonProperty("key")
  private String key;

  public String getKey() {
   return key;
  }

  public void setKey(String key) {
   this.key = key;
  }
}
