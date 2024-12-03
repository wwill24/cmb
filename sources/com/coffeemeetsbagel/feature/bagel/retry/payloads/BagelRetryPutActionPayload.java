package com.coffeemeetsbagel.feature.bagel.retry.payloads;

public class BagelRetryPutActionPayload {
    private int action;
    private String commentOnLike;

    /* renamed from: id  reason: collision with root package name */
    private String f12729id;
    private String likeProfilePart;
    private String likeProfileUrl;

    public BagelRetryPutActionPayload(String str, int i10) {
        this.f12729id = str;
        this.action = i10;
    }

    public int getAction() {
        return this.action;
    }

    public String getCommentOnLike() {
        return this.commentOnLike;
    }

    public String getId() {
        return this.f12729id;
    }

    public String getLikeProfilePart() {
        return this.likeProfilePart;
    }

    public String getLikeProfileUrl() {
        return this.likeProfileUrl;
    }

    public void setAction(int i10) {
        this.action = i10;
    }

    public void setCommentOnLike(String str) {
        this.commentOnLike = str;
    }

    public void setId(String str) {
        this.f12729id = str;
    }

    public void setLikeProfilePart(String str) {
        this.likeProfilePart = str;
    }

    public void setLikeProfileUrl(String str) {
        this.likeProfileUrl = str;
    }
}
