package com.coffeemeetsbagel.models;

import com.coffeemeetsbagel.models.enums.MessageStatus;
import fa.a;

public class MessageToSend extends MessageBase {
    private Long pendingMessageId;
    private String senderGuid;
    private long senderID;
    private String text;

    public MessageToSend() {
    }

    public Long getPendingMessageId() {
        return this.pendingMessageId;
    }

    public String getSenderGuid() {
        return this.senderGuid;
    }

    public long getSenderID() {
        return this.senderID;
    }

    public MessageStatus getStatus() {
        return this.mStatus;
    }

    public String getText() {
        return this.text;
    }

    public MessageToSend(String str, String str2, Long l10) {
        this.text = str;
        this.senderGuid = str2;
        try {
            this.senderID = Long.valueOf(str2).longValue();
        } catch (NumberFormatException e10) {
            a.i(e10);
            this.senderID = -1;
        }
        this.pendingMessageId = l10;
    }
}
