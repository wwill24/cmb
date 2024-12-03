package com.coffeemeetsbagel.models.entities;

import kotlin.jvm.internal.j;

public final class ConnectionDetailsEntity {
    private final String lastMessageDate;
    private final String lastMessageReadTimestamp;
    private final String lastMessageText;
    private final String lastSenderProfileId;
    private final String pairReadReceiptDate;
    private final String profileId;
    private final int unreadMessageCount;

    public ConnectionDetailsEntity(String str, int i10, String str2, String str3, String str4, String str5, String str6) {
        j.g(str, "profileId");
        this.profileId = str;
        this.unreadMessageCount = i10;
        this.lastMessageText = str2;
        this.lastMessageDate = str3;
        this.pairReadReceiptDate = str4;
        this.lastSenderProfileId = str5;
        this.lastMessageReadTimestamp = str6;
    }

    public final String getLastMessageDate() {
        return this.lastMessageDate;
    }

    public final String getLastMessageReadTimestamp() {
        return this.lastMessageReadTimestamp;
    }

    public final String getLastMessageText() {
        return this.lastMessageText;
    }

    public final String getLastSenderProfileId() {
        return this.lastSenderProfileId;
    }

    public final String getPairReadReceiptDate() {
        return this.pairReadReceiptDate;
    }

    public final String getProfileId() {
        return this.profileId;
    }

    public final int getUnreadMessageCount() {
        return this.unreadMessageCount;
    }
}
