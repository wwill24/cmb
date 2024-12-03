package com.coffeemeetsbagel.models;

import com.coffeemeetsbagel.models.enums.MessageStatus;
import com.coffeemeetsbagel.models.enums.MessageType;
import com.coffeemeetsbagel.models.util.DateUtils;
import java.util.Date;

public abstract class MessageBase {
    String dateSent;
    MessageStatus mStatus;

    public MessageBase() {
        this.dateSent = DateUtils.getFormattedUtcDate(new Date(), DateUtils.DATE_WITH_TIME_PATTERN);
    }

    public String getDateSent() {
        return this.dateSent;
    }

    public MessageStatus getStatus() {
        return this.mStatus;
    }

    public String getType() {
        return MessageType.CHAT.getTypeName();
    }

    public void setDateSent(String str) {
        this.dateSent = str;
    }

    public void setStatus(MessageStatus messageStatus) {
        this.mStatus = messageStatus;
    }

    public MessageBase(MessageStatus messageStatus) {
        this();
        this.mStatus = messageStatus;
    }
}
