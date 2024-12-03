package com.coffeemeetsbagel.feature.analyticstracking.models;

public class AnalyticsTrackingResponse {
    private String error;
    private int statusCode;
    private String success;

    public String getError() {
        return this.error;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public String getSuccess() {
        return this.success;
    }

    public void setError(String str) {
        this.error = str;
    }

    public void setStatusCode(int i10) {
        this.statusCode = i10;
    }

    public void setSuccess(String str) {
        this.success = str;
    }
}
