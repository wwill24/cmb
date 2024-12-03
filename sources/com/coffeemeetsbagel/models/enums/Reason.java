package com.coffeemeetsbagel.models.enums;

public enum Reason {
    IN_A_MATCH("10"),
    BUSY("1000"),
    OTHER("10000"),
    NOT_HEARING_BACK("100000"),
    MATCHED_ELSEWHERE("1000000"),
    DISLIKES_MATCHES("10000000"),
    PREFER_OTHER_SERVICES("100000000"),
    PREFER_OFFLINE_DATING("1000000000"),
    NO_RESPONSE("100");
    
    private String mBinaryString;

    private Reason(String str) {
        this.mBinaryString = str;
    }

    public int getIntValue() {
        return Integer.parseInt(this.mBinaryString, 2);
    }
}
