package com.coffeemeetsbagel.models.responses;

public class ResponsePhoto extends ResponseGeneric {
    private String photoId;
    private String photoUrl;

    public String getPhotoId() {
        return this.photoId;
    }

    public String getPhotoUrl() {
        return this.photoUrl;
    }
}
