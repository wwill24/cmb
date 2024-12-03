package com.coffeemeetsbagel.models.enums;

import android.text.TextUtils;
import com.coffeemeetsbagel.models.ModelDeeplinkData;
import com.coffeemeetsbagel.models.util.ComparisonUtils;
import org.jivesoftware.smackx.blocking.element.BlockContactsIQ;

public enum MessageType {
    NUDGE("nudge"),
    CHAT(ModelDeeplinkData.VALUE_PAGE_CHAT),
    CONVERSATION_CLOSED("closed"),
    ICEBREAKER("icebreaker"),
    NUDGE_BOTH_NO_RESPONSE("nudge_both_no_response"),
    NUDGE_ONE_RESPONDED("nudge_one_responded"),
    EXPIRATION("expiration"),
    BLOCK(BlockContactsIQ.ELEMENT),
    ATTENDANCE_BONUS("attendance_bonus"),
    FRIEND_JOINED_BONUS("friend_joined_bonus"),
    ONE_OF_PROFILES_BANNED("one_of_profiles_banned"),
    BONUS_BAGEL_REMINDER("bonus_bagel_reminder"),
    REOPEN_PROMPT("reopen_prompt"),
    REOPEN_SUCCESS("reopen_success"),
    IMAGE("image"),
    STICKER("sticker"),
    BANNED("banned"),
    UNBANNED("unbanned"),
    READY_TO_MEET("ready_to_meet"),
    READY_TO_MEET_NUDGE("ready_to_meet_nudge"),
    NONE(""),
    UNRECOGNIZED((String) null);
    
    private String mType;

    private MessageType(String str) {
        this.mType = str;
    }

    public static MessageType getMessageType(String str) {
        for (MessageType messageType : values()) {
            if (TextUtils.isEmpty(str)) {
                return NONE;
            }
            if (ComparisonUtils.equalsWithNullCheck(messageType.getTypeName(), str)) {
                return messageType;
            }
        }
        return UNRECOGNIZED;
    }

    public String getTypeName() {
        return this.mType;
    }
}
