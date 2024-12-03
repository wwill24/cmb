package com.coffeemeetsbagel.models.entities;

import com.coffeemeetsbagel.models.dto.PendingMessage;
import com.coffeemeetsbagel.models.enums.MessageStatus;
import com.coffeemeetsbagel.models.enums.MessageType;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class PendingMessageEntity implements PendingMessage {
    private final String bagelId;

    /* renamed from: id  reason: collision with root package name */
    private final Long f34723id;
    private final MessageStatus status;
    private final String text;
    private final String timeSent;
    private final MessageType type;

    public PendingMessageEntity(Long l10, String str, MessageStatus messageStatus, String str2, String str3, MessageType messageType) {
        j.g(str, "bagelId");
        j.g(messageStatus, "status");
        j.g(str2, "text");
        j.g(messageType, "type");
        this.f34723id = l10;
        this.bagelId = str;
        this.status = messageStatus;
        this.text = str2;
        this.timeSent = str3;
        this.type = messageType;
    }

    public static /* synthetic */ PendingMessageEntity copy$default(PendingMessageEntity pendingMessageEntity, Long l10, String str, MessageStatus messageStatus, String str2, String str3, MessageType messageType, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            l10 = pendingMessageEntity.getId();
        }
        if ((i10 & 2) != 0) {
            str = pendingMessageEntity.getBagelId();
        }
        String str4 = str;
        if ((i10 & 4) != 0) {
            messageStatus = pendingMessageEntity.getStatus();
        }
        MessageStatus messageStatus2 = messageStatus;
        if ((i10 & 8) != 0) {
            str2 = pendingMessageEntity.getText();
        }
        String str5 = str2;
        if ((i10 & 16) != 0) {
            str3 = pendingMessageEntity.getTimeSent();
        }
        String str6 = str3;
        if ((i10 & 32) != 0) {
            messageType = pendingMessageEntity.getType();
        }
        return pendingMessageEntity.copy(l10, str4, messageStatus2, str5, str6, messageType);
    }

    public final Long component1() {
        return getId();
    }

    public final String component2() {
        return getBagelId();
    }

    public final MessageStatus component3() {
        return getStatus();
    }

    public final String component4() {
        return getText();
    }

    public final String component5() {
        return getTimeSent();
    }

    public final MessageType component6() {
        return getType();
    }

    public final PendingMessageEntity copy(Long l10, String str, MessageStatus messageStatus, String str2, String str3, MessageType messageType) {
        j.g(str, "bagelId");
        j.g(messageStatus, "status");
        j.g(str2, "text");
        j.g(messageType, "type");
        return new PendingMessageEntity(l10, str, messageStatus, str2, str3, messageType);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PendingMessageEntity)) {
            return false;
        }
        PendingMessageEntity pendingMessageEntity = (PendingMessageEntity) obj;
        return j.b(getId(), pendingMessageEntity.getId()) && j.b(getBagelId(), pendingMessageEntity.getBagelId()) && getStatus() == pendingMessageEntity.getStatus() && j.b(getText(), pendingMessageEntity.getText()) && j.b(getTimeSent(), pendingMessageEntity.getTimeSent()) && getType() == pendingMessageEntity.getType();
    }

    public String getBagelId() {
        return this.bagelId;
    }

    public Long getId() {
        return this.f34723id;
    }

    public MessageStatus getStatus() {
        return this.status;
    }

    public String getText() {
        return this.text;
    }

    public String getTimeSent() {
        return this.timeSent;
    }

    public MessageType getType() {
        return this.type;
    }

    public int hashCode() {
        int i10 = 0;
        int hashCode = (((((((getId() == null ? 0 : getId().hashCode()) * 31) + getBagelId().hashCode()) * 31) + getStatus().hashCode()) * 31) + getText().hashCode()) * 31;
        if (getTimeSent() != null) {
            i10 = getTimeSent().hashCode();
        }
        return ((hashCode + i10) * 31) + getType().hashCode();
    }

    public String toString() {
        return "PendingMessageEntity(id=" + getId() + ", bagelId=" + getBagelId() + ", status=" + getStatus() + ", text=" + getText() + ", timeSent=" + getTimeSent() + ", type=" + getType() + PropertyUtils.MAPPED_DELIM2;
    }
}
