package com.coffeemeetsbagel.models;

import java.io.Serializable;

public class FacebookAlbum implements Serializable {
    private int count;

    /* renamed from: id  reason: collision with root package name */
    private String f34706id;
    private String name;
    private String thumbId;
    private String thumbUrl;

    public FacebookAlbum(String str, String str2, String str3, String str4, int i10) {
        this.f34706id = str;
        this.name = str2;
        this.thumbId = str3;
        this.thumbUrl = str4;
        this.count = i10;
    }

    public int getCount() {
        return this.count;
    }

    public String getId() {
        return this.f34706id;
    }

    public String getName() {
        return this.name;
    }

    public String getThumbId() {
        return this.thumbId;
    }

    public String getThumbUrl() {
        return this.thumbUrl;
    }

    public void setCount(int i10) {
        this.count = i10;
    }

    public void setId(String str) {
        this.f34706id = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setThumbId(String str) {
        this.thumbId = str;
    }

    public void setThumbUrl(String str) {
        this.thumbUrl = str;
    }

    public FacebookAlbum() {
    }
}
