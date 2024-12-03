package com.coffeemeetsbagel.feature.analyticstracking.models;

public class AnalyticsNetworkLatencyBody {
    private String method;
    private long milliseconds;
    private String path;
    private int statusCode;

    public AnalyticsNetworkLatencyBody(String str, long j10, String str2, int i10) {
        this.path = str;
        this.milliseconds = j10;
        this.method = str2;
        this.statusCode = i10;
    }
}
