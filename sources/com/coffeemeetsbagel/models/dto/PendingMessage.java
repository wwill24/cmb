package com.coffeemeetsbagel.models.dto;

import com.coffeemeetsbagel.models.enums.MessageStatus;
import com.coffeemeetsbagel.models.enums.MessageType;

public interface PendingMessage {
    String getBagelId();

    Long getId();

    MessageStatus getStatus();

    String getText();

    String getTimeSent();

    MessageType getType();
}
