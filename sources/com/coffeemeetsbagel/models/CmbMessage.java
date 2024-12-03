package com.coffeemeetsbagel.models;

import android.text.TextUtils;
import com.coffeemeetsbagel.models.dto.PendingMessage;
import com.coffeemeetsbagel.models.enums.MessageStatus;
import com.coffeemeetsbagel.models.enums.MessageType;
import com.coffeemeetsbagel.models.util.ComparisonUtils;
import com.coffeemeetsbagel.models.util.DateUtils;
import com.coffeemeetsbagel.models.util.ModelUtils;
import com.coffeemeetsbagel.models.util.StringUtils;
import fa.a;
import java.util.Date;

public class CmbMessage extends MessageBase {
    private String decouplingDate;
    private String imageUrl;
    private boolean mIsPrivate;
    private MessageType mMessageType;
    private Long pendingMessageId;
    private String profile1Guid;
    private long profile1ID;
    private String profile2Guid;
    private long profile2ID;
    private String recipientGuid;
    private long recipientID;
    private String senderGuid;
    private long senderID;
    private String text;
    private String type;

    public CmbMessage() {
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof CmbMessage)) {
            return super.equals(obj);
        }
        CmbMessage cmbMessage = (CmbMessage) obj;
        if (!cmbMessage.getDateSent().equals(this.dateSent) || !StringUtils.compareWithNullAsEqual(cmbMessage.getText(), this.text) || !StringUtils.compareWithNullAsEqual(cmbMessage.getImageUrl(), this.imageUrl) || cmbMessage.getSenderID() != this.senderID || cmbMessage.getRecipientID() != this.recipientID) {
            return false;
        }
        return true;
    }

    public String getDecouplingDate() {
        return this.decouplingDate;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public MessageType getMessageType() {
        return this.mMessageType;
    }

    public Long getPendingMessageId() {
        return this.pendingMessageId;
    }

    public String getProfile1Guid() {
        return ModelUtils.getIdentifier(this.profile1Guid, this.profile1ID);
    }

    public long getProfile1ID() {
        return this.profile1ID;
    }

    public long getProfile2ID() {
        return this.profile2ID;
    }

    public String getRecipientGuid() {
        return ModelUtils.getIdentifier(this.recipientGuid, this.recipientID);
    }

    public long getRecipientID() {
        return this.recipientID;
    }

    public String getSenderGuid() {
        return ModelUtils.getIdentifier(this.senderGuid, this.senderID);
    }

    public long getSenderID() {
        return this.senderID;
    }

    public String getText() {
        return this.text;
    }

    public String getTypeName() {
        return this.type;
    }

    public boolean isFromMe(String str) {
        return ComparisonUtils.equalsWithNullCheck(String.valueOf(this.senderID), str);
    }

    public boolean isFromOther(String str) {
        return ComparisonUtils.equalsWithNullCheck(String.valueOf(this.senderID), str);
    }

    public boolean isPrivate() {
        return this.mIsPrivate;
    }

    public void setDecouplingDate(String str) {
        this.decouplingDate = str;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public void setIsPrivate(boolean z10) {
        this.mIsPrivate = z10;
    }

    public void setMessageType(MessageType messageType) {
        this.mMessageType = messageType;
    }

    public void setProfile1ID(long j10) {
        this.profile1ID = j10;
    }

    public void setProfile2ID(long j10) {
        this.profile2ID = j10;
    }

    public void setRecipientID(long j10) {
        this.recipientID = j10;
    }

    public void setSenderID(long j10) {
        this.senderID = j10;
    }

    public void setText(String str) {
        this.text = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public CmbMessage(String str, String str2, MessageType messageType, MessageStatus messageStatus, String str3, String str4) {
        super(messageStatus);
        this.text = str;
        this.mMessageType = messageType;
        this.type = messageType.getTypeName();
        try {
            this.senderID = Long.valueOf(str2).longValue();
        } catch (NumberFormatException e10) {
            a.i(e10);
            this.senderID = -1;
        }
        try {
            this.profile1ID = Long.valueOf(str3).longValue();
        } catch (NumberFormatException e11) {
            a.i(e11);
            this.profile1ID = -1;
        }
        try {
            this.profile2ID = Long.valueOf(str4).longValue();
        } catch (NumberFormatException e12) {
            a.i(e12);
            this.profile2ID = -1;
        }
    }

    private CmbMessage(String str, MessageType messageType, MessageStatus messageStatus, Long l10) {
        this.text = str;
        this.mMessageType = messageType;
        this.mStatus = messageStatus;
        this.pendingMessageId = l10;
    }

    public CmbMessage(MessageToSend messageToSend) {
        this(messageToSend.getText(), MessageType.CHAT, messageToSend.getStatus(), messageToSend.getPendingMessageId());
    }

    public CmbMessage(PendingMessage pendingMessage) {
        this(pendingMessage.getText(), pendingMessage.getType(), pendingMessage.getStatus(), pendingMessage.getId());
    }

    public CmbMessage(SavedMessage savedMessage, String str) {
        this.text = savedMessage.getMessage();
        this.mMessageType = MessageType.getMessageType(savedMessage.getCategory());
        this.type = savedMessage.getCategory();
        this.mStatus = MessageStatus.SENT;
        Date dateFromMongooseTimestamp = DateUtils.getDateFromMongooseTimestamp(savedMessage.getTimestamp());
        if (dateFromMongooseTimestamp != null) {
            this.dateSent = DateUtils.getFormattedDate(dateFromMongooseTimestamp, DateUtils.DATE_WITH_TIME_PATTERN);
        }
        if (!TextUtils.isEmpty(savedMessage.getUrl())) {
            this.imageUrl = savedMessage.getUrl();
        }
        if (savedMessage.isToMe()) {
            try {
                this.senderID = Long.valueOf(savedMessage.getProfileId()).longValue();
            } catch (NumberFormatException e10) {
                a.i(e10);
                this.senderID = -1;
            }
        } else {
            try {
                this.senderID = Long.valueOf(str).longValue();
            } catch (NumberFormatException e11) {
                a.i(e11);
                this.senderID = -1;
            }
        }
    }
}
