package io.sentry;

import org.jetbrains.annotations.ApiStatus;
import org.jivesoftware.smack.packet.Session;

@ApiStatus.Internal
public enum DataCategory {
    All("__all__"),
    Default("default"),
    Error("error"),
    Session(Session.ELEMENT),
    Attachment("attachment"),
    Transaction("transaction"),
    Security("security"),
    UserReport("user_report"),
    Unknown("unknown");
    
    private final String category;

    private DataCategory(String str) {
        this.category = str;
    }

    public String getCategory() {
        return this.category;
    }
}
