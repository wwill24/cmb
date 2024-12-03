package com.coffeemeetsbagel.models;

public class FacebookPhoto {
    private String mId;
    private String mSourceUrl;
    private String mThumb;

    public FacebookPhoto() {
    }

    public String getId() {
        return this.mId;
    }

    public String getSourceUrl() {
        return this.mSourceUrl;
    }

    public String getThumb() {
        return this.mThumb;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public void setSourceUrl(String str) {
        this.mSourceUrl = str;
    }

    public void setThumb(String str) {
        this.mThumb = str;
    }

    public FacebookPhoto(String str, String str2, String str3) {
        this.mThumb = str;
        this.mId = str2;
        this.mSourceUrl = str3;
    }
}
