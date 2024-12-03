package com.coffeemeetsbagel.models;

import androidx.annotation.NonNull;
import com.coffeemeetsbagel.models.util.ComparisonUtils;
import com.coffeemeetsbagel.models.util.DateUtils;
import java.io.Serializable;
import java.util.Date;
import java.util.Locale;

public class ConnectionDetails implements Serializable, Model, Comparable<ConnectionDetails> {
    private String lastMessageDate;
    private String lastMessageReadTimestamp;
    private String lastMessageText;
    private String lastSenderProfileId;
    private boolean pairIsTyping;
    private String pairReadReceiptDate;
    private String profileId;
    private int unreadMessageCount;
    private boolean viewed;

    public ConnectionDetails() {
    }

    public String getLastMessageDate() {
        return this.lastMessageDate;
    }

    public Date getLastMessageDateDate() {
        return DateUtils.getDateWithPattern(getLastMessageDate(), DateUtils.DATE_WITH_TIME_PATTERN);
    }

    public String getLastMessageReadTimestamp() {
        return this.lastMessageReadTimestamp;
    }

    public String getLastMessageText() {
        return this.lastMessageText;
    }

    public String getLastSenderProfileId() {
        return this.lastSenderProfileId;
    }

    public String getPairReadReceiptDate() {
        return this.pairReadReceiptDate;
    }

    public Date getPairReadReceiptDateDate() {
        return DateUtils.getDateWithPattern(this.pairReadReceiptDate, DateUtils.DATE_WITH_TIME_PATTERN_MS);
    }

    public String getProfileId() {
        return this.profileId;
    }

    public int getUnreadMessageCount() {
        return this.unreadMessageCount;
    }

    public void incrementUnreadMessageCount() {
        this.unreadMessageCount++;
    }

    public boolean isViewed() {
        return this.viewed;
    }

    public void resetUnreadMessageCount() {
        this.unreadMessageCount = 0;
        this.viewed = true;
    }

    public void setIsViewed(boolean z10) {
        this.viewed = z10;
    }

    public void setLastMessageDate(String str) {
        this.lastMessageDate = str;
    }

    public void setLastMessageReadTimestamp(String str) {
        this.lastMessageReadTimestamp = str;
    }

    public void setLastMessageText(String str) {
        this.lastMessageText = str;
    }

    public void setLastSenderProfileId(String str) {
        this.lastSenderProfileId = str;
    }

    public void setPairIsTyping(boolean z10) {
        this.pairIsTyping = z10;
    }

    public void setPairReadReceiptDate(String str) {
        this.pairReadReceiptDate = str;
    }

    public void setProfileId(String str) {
        this.profileId = str;
    }

    public void setUnreadMessageCount(int i10) {
        this.unreadMessageCount = i10;
    }

    public String toString() {
        return String.format(Locale.getDefault(), "profileId: %s msg: %s msgDate: %s unread: %d receipt: %s pairIsTyping: %b", new Object[]{this.profileId, this.lastMessageText, this.lastMessageDate, Integer.valueOf(this.unreadMessageCount), this.pairReadReceiptDate, Boolean.valueOf(this.pairIsTyping)});
    }

    public ConnectionDetails(String str, int i10, String str2, String str3, String str4, String str5, boolean z10) {
        this.unreadMessageCount = i10;
        this.lastMessageText = str2;
        this.lastMessageDate = str3;
        this.profileId = str;
        this.pairReadReceiptDate = str4;
        this.lastSenderProfileId = str5;
        this.pairIsTyping = z10;
    }

    public int compareTo(@NonNull ConnectionDetails connectionDetails) {
        int compareWithNullCheck = ComparisonUtils.compareWithNullCheck(this.lastMessageDate, connectionDetails.lastMessageDate);
        if (compareWithNullCheck != 0) {
            return compareWithNullCheck;
        }
        int compareWithNullCheck2 = ComparisonUtils.compareWithNullCheck(Integer.valueOf(connectionDetails.unreadMessageCount), Integer.valueOf(this.unreadMessageCount));
        if (compareWithNullCheck2 != 0) {
            return compareWithNullCheck2;
        }
        int compareWithNullCheck3 = ComparisonUtils.compareWithNullCheck(this.pairReadReceiptDate, connectionDetails.pairReadReceiptDate);
        if (compareWithNullCheck3 != 0) {
            return compareWithNullCheck3;
        }
        return 0;
    }

    public void resetUnreadMessageCount(String str) {
        this.lastMessageReadTimestamp = str;
        resetUnreadMessageCount();
    }
}
