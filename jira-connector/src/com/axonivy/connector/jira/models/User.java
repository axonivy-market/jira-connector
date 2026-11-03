package com.axonivy.connector.jira.models;

public class User {
  
  private String displayName;
  private String accountId;
  
  public String getDisplayName() {
    return displayName;
  }
  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }
  public String getAccountId() {
    return accountId;
  }
  public void setAccountId(String userId) {
    this.accountId = userId;
  }
  
}
