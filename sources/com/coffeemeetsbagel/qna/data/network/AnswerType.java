package com.coffeemeetsbagel.qna.data.network;

public enum AnswerType {
    LOCATION("location");
    
    private final String apiString;

    private AnswerType(String str) {
        this.apiString = str;
    }

    public final String getApiString() {
        return this.apiString;
    }
}
