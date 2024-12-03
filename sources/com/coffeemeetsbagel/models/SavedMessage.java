package com.coffeemeetsbagel.models;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.coffeemeetsbagel.models.util.DateUtils;
import java.io.Serializable;
import java.util.Date;
import lg.c;

public class SavedMessage implements Serializable, Model, Comparable<SavedMessage> {
    private String category;
    @c("displayed_message_id")
    private String displayedMessageId;
    private String message;
    @c("message_id")
    private String messageId;
    @c("profile_id")
    private String profileId;
    private String timestamp;
    @c("to_me")
    private boolean toMe;
    private String url;

    public SavedMessage() {
    }

    public boolean equals(Object obj) {
        String str;
        if (!(obj instanceof SavedMessage) || (str = this.timestamp) == null || !str.equals(((SavedMessage) obj).getTimestamp())) {
            return false;
        }
        return true;
    }

    public String getCategory() {
        return this.category;
    }

    public String getDisplayedMessageId() {
        return this.displayedMessageId;
    }

    public String getMessage() {
        return this.message;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public String getProfileId() {
        return this.profileId;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public Date getTimestampDate() {
        return DateUtils.getDateFromMongooseTimestamp(getTimestamp());
    }

    public String getUrl() {
        return this.url;
    }

    public boolean hasContent() {
        return !TextUtils.isEmpty(this.message) || !TextUtils.isEmpty(this.url);
    }

    public boolean isDisplayedMessage() {
        return !TextUtils.isEmpty(this.displayedMessageId);
    }

    public boolean isToMe() {
        return this.toMe;
    }

    public void setCategory(String str) {
        this.category = str;
    }

    public void setDisplayedMessageId(String str) {
        this.displayedMessageId = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setMessageId(String str) {
        this.messageId = str;
    }

    public void setProfileId(String str) {
        this.profileId = str;
    }

    public void setTimestamp(String str) {
        this.timestamp = str;
    }

    public void setToMe(boolean z10) {
        this.toMe = z10;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public SavedMessage(String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z10) {
        this.profileId = str;
        this.message = str2;
        this.timestamp = str3;
        this.messageId = str4;
        this.category = str5;
        this.url = str6;
        this.displayedMessageId = str7;
        this.toMe = z10;
    }

    public int compareTo(@NonNull SavedMessage savedMessage) {
        return this.timestamp.compareTo(savedMessage.getTimestamp());
    }
}
