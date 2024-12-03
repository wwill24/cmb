package com.coffeemeetsbagel.models.enums;

import android.text.TextUtils;
import com.coffeemeetsbagel.models.util.ComparisonUtils;

public enum MessageStatus {
    SENDING("sending"),
    SENT("sent"),
    NOT_SENT("not_sent"),
    UNRECOGNIZED((String) null);
    
    private String messageStatusName;

    private MessageStatus(String str) {
        this.messageStatusName = str;
    }

    public static MessageStatus getMessageStatus(String str) {
        for (MessageStatus messageStatus : values()) {
            if (TextUtils.isEmpty(str)) {
                return UNRECOGNIZED;
            }
            if (ComparisonUtils.equalsWithNullCheck(messageStatus.getMessageStatusName(), str)) {
                return messageStatus;
            }
        }
        return UNRECOGNIZED;
    }

    public String getMessageStatusName() {
        return this.messageStatusName;
    }
}
