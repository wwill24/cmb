package com.coffeemeetsbagel.models;

import java.io.Serializable;

public class PushMessage implements Serializable {
    private long couple_id;
    private long from_id;
    private String image_url;
    private String text;
    private long to_id;
    private String type;

    private PushMessage() {
    }

    public long getCouple_id() {
        return this.couple_id;
    }

    public long getFrom_id() {
        return this.from_id;
    }

    public String getImage_url() {
        return this.image_url;
    }

    public String getText() {
        return this.text;
    }

    public long getTo_id() {
        return this.to_id;
    }

    public String getType() {
        return this.type;
    }

    public void setCouple_id(long j10) {
        this.couple_id = j10;
    }

    public void setFrom_id(long j10) {
        this.from_id = j10;
    }

    public void setImage_url(String str) {
        this.image_url = str;
    }

    public void setText(String str) {
        this.text = str;
    }

    public void setTo_id(long j10) {
        this.to_id = j10;
    }

    public void setType(String str) {
        this.type = str;
    }

    public PushMessage(long j10, long j11, long j12, String str, String str2, String str3) {
        this.couple_id = j10;
        this.from_id = j11;
        this.to_id = j12;
        this.text = str;
        this.image_url = str2;
        this.type = str3;
    }
}
