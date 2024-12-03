package com.coffeemeetsbagel.feature.chat.features.photoupload.api.models;

import com.coffeemeetsbagel.models.MessageBase;
import com.coffeemeetsbagel.models.enums.MessageType;

public class ImageToSend extends MessageBase {
    private String coupleId;
    private String imageUrl;
    private long senderID;
    private String toId;
    private String type;

    public ImageToSend(String str, String str2, long j10, String str3, boolean z10) {
        this.imageUrl = str;
        this.coupleId = str2;
        this.senderID = j10;
        this.toId = str3;
        if (z10) {
            this.type = MessageType.STICKER.getTypeName();
        } else {
            this.type = MessageType.IMAGE.getTypeName();
        }
    }

    public String getCoupleId() {
        return this.coupleId;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public long getSenderID() {
        return this.senderID;
    }

    public String getToId() {
        return this.toId;
    }

    public String getType() {
        return this.type;
    }

    public void setCoupleId(String str) {
        this.coupleId = str;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public void setSenderID(long j10) {
        this.senderID = j10;
    }

    public void setToId(String str) {
        this.toId = str;
    }
}
