package com.coffeemeetsbagel.models.enums;

public enum Icon {
    BEAN(""),
    HEART_IN_CIRCLE(""),
    HEART(""),
    INVITE_FRIEND(""),
    LOCATION(""),
    RING(""),
    STAR(""),
    AVATAR(""),
    FEMALE(""),
    MALE(""),
    DONE(""),
    PROFILE_PLACEHOLDER(""),
    FORWARD(""),
    PLUS(""),
    PLUS_WITH_RING(""),
    CLEAR(""),
    FLOWER(""),
    MINUS(""),
    FACE_SMILEY(""),
    FACE_FROWNY(""),
    FLAG("");
    
    private final String mUtfCode;

    private Icon(String str) {
        this.mUtfCode = str;
    }

    public String getUtfCode() {
        return this.mUtfCode;
    }
}
