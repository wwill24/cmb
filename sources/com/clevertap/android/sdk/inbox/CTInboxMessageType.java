package com.clevertap.android.sdk.inbox;

import androidx.annotation.NonNull;

enum CTInboxMessageType {
    SimpleMessage("simple"),
    IconMessage("message-icon"),
    CarouselMessage("carousel"),
    CarouselImageMessage("carousel-image");
    
    private final String inboxMessageType;

    private CTInboxMessageType(String str) {
        this.inboxMessageType = str;
    }

    static CTInboxMessageType a(String str) {
        str.hashCode();
        char c10 = 65535;
        switch (str.hashCode()) {
            case -1799711058:
                if (str.equals("carousel-image")) {
                    c10 = 0;
                    break;
                }
                break;
            case -1332589953:
                if (str.equals("message-icon")) {
                    c10 = 1;
                    break;
                }
                break;
            case -902286926:
                if (str.equals("simple")) {
                    c10 = 2;
                    break;
                }
                break;
            case 2908512:
                if (str.equals("carousel")) {
                    c10 = 3;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                return CarouselImageMessage;
            case 1:
                return IconMessage;
            case 2:
                return SimpleMessage;
            case 3:
                return CarouselMessage;
            default:
                return null;
        }
    }

    @NonNull
    public String toString() {
        return this.inboxMessageType;
    }
}
