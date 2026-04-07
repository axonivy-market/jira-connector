package com.axonivy.connector.jira.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TimeTracking {
	
	@JsonProperty("originalEstimate")
    private String originalEstimate;

    @JsonProperty("remainingEstimate")
    private String remainingEstimate;

    @JsonProperty("timeSpent")
    private String timeSpent;

    @JsonProperty("originalEstimateSeconds")
    private int originalEstimateSeconds;

    @JsonProperty("remainingEstimateSeconds")
    private int remainingEstimateSeconds;

    @JsonProperty("timeSpentSeconds")
    private int timeSpentSeconds;

    // Getters & Setters
    public String getOriginalEstimate() {
        return originalEstimate;
    }

    public void setOriginalEstimate(String originalEstimate) {
        this.originalEstimate = originalEstimate;
    }

    public String getRemainingEstimate() {
        return remainingEstimate;
    }

    public void setRemainingEstimate(String remainingEstimate) {
        this.remainingEstimate = remainingEstimate;
    }

    public String getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(String timeSpent) {
        this.timeSpent = timeSpent;
    }

    public int getOriginalEstimateSeconds() {
        return originalEstimateSeconds;
    }

    public void setOriginalEstimateSeconds(int originalEstimateSeconds) {
        this.originalEstimateSeconds = originalEstimateSeconds;
    }

    public int getRemainingEstimateSeconds() {
        return remainingEstimateSeconds;
    }

    public void setRemainingEstimateSeconds(int remainingEstimateSeconds) {
        this.remainingEstimateSeconds = remainingEstimateSeconds;
    }

    public int getTimeSpentSeconds() {
        return timeSpentSeconds;
    }

    public void setTimeSpentSeconds(int timeSpentSeconds) {
        this.timeSpentSeconds = timeSpentSeconds;
    }
}
