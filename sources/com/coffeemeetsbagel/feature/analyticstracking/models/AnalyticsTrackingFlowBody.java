package com.coffeemeetsbagel.feature.analyticstracking.models;

public class AnalyticsTrackingFlowBody {
    private String flow;
    private long milliseconds;
    private String result;

    public AnalyticsTrackingFlowBody(String str, long j10, String str2) {
        this.flow = str;
        this.milliseconds = j10;
        this.result = str2;
    }
}
