package com.coffeemeetsbagel.models.enums;

import com.coffeemeetsbagel.models.constants.ProfileConstants;

public enum ResourceType {
    HIDE_TYPE_CONNECTED("hide_type_connected"),
    HIDE_TYPE_NOT_CONNECTED("hide_type_not_connected"),
    BLOCK_TYPE_NOT_CONNECTED("block_type_not_connected"),
    BLOCK_TYPE_CONNECTED("block_type_connected"),
    DEGREES("degrees"),
    UNSUPPORTED_CHAT_MESSAGE_PLACEHOLDERS("unsupported_chat_message_placeholders"),
    DISCOVER_DEGREES("discover_degrees"),
    PROFILE_QUESTIONS("profile_questions"),
    PROFILE_QUESTION_HINTS("profile_question_hints"),
    ETHNICITY("ethnicity"),
    RELIGION(ProfileConstants.Field.RELIGION);
    
    private String mApiKey;
    private EventType mEventType;

    private ResourceType(String str) {
        this.mApiKey = str;
    }

    public EventType getEventType() {
        return this.mEventType;
    }

    public String getListName() {
        return this.mApiKey;
    }
}
