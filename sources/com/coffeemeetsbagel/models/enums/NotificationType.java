package com.coffeemeetsbagel.models.enums;

import com.coffeemeetsbagel.models.ModelDeeplinkData;
import com.coffeemeetsbagel.models.constants.Extra;

public enum NotificationType {
    GENERAL(8000, "general"),
    CHAT(8004, ModelDeeplinkData.VALUE_PAGE_CHAT),
    EXPIRATION(8004, "expiration"),
    ATTENDANCE_BONUS(8006, "attendance_bonus"),
    FRIEND_JOINED_BONUS(8007, "friend_joined_bonus"),
    REOPEN_SUCCESS(8008, "reopen_success"),
    IMAGE(8004, "image"),
    STICKER(8004, "sticker"),
    VIDEO_FEED(8005, Extra.VIDEO_FEED),
    EXPEDITED_BATCH(8006, "expedited_batch"),
    ICE_BREAKER(8004, "icebreaker");
    
    private final int mNotificationId;
    private final String mType;

    private NotificationType(int i10, String str) {
        this.mNotificationId = i10;
        this.mType = str;
    }

    public static NotificationType getNotificationType(String str) {
        for (NotificationType notificationType : values()) {
            if (notificationType.getType().equals(str)) {
                return notificationType;
            }
        }
        return GENERAL;
    }

    public int getNotificationId() {
        return this.mNotificationId;
    }

    public String getType() {
        return this.mType;
    }
}
