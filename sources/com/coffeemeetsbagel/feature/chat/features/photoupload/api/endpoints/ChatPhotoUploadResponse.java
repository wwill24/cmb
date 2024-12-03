package com.coffeemeetsbagel.feature.chat.features.photoupload.api.endpoints;

public class ChatPhotoUploadResponse {
    private String error;
    private String imageUrl;
    private int statusCode;

    public String getError() {
        return this.error;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public void setError(String str) {
        this.error = str;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public void setStatusCode(int i10) {
        this.statusCode = i10;
    }
}
