package com.coffeemeetsbagel.models;

import com.coffeemeetsbagel.models.enums.MessageStatus;
import fa.a;

public class MessageNudge extends MessageBase {
    private String recipientGuid;
    private long recipientID;
    private String text;

    public MessageNudge() {
    }

    public String getRecipientGuid() {
        return this.recipientGuid;
    }

    public long getRecipientID() {
        return this.recipientID;
    }

    public MessageStatus getStatus() {
        return this.mStatus;
    }

    public String getText() {
        return this.text;
    }

    public void setRecipientGuid(String str) {
        this.recipientGuid = str;
    }

    public MessageNudge(String str, String str2) {
        long j10;
        this.text = str;
        try {
            j10 = Long.valueOf(str2).longValue();
        } catch (NumberFormatException unused) {
            a.i(new IllegalArgumentException("Could not convert id to numeric in message nudge"));
            j10 = -1;
        }
        this.recipientID = j10;
        this.recipientGuid = str2;
    }
}
