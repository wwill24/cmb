package com.coffeemeetsbagel.match.models;

import lg.c;

public class MarkChatDeletedBody {
    @c("chat_removed")
    private Boolean chat_removed;

    public MarkChatDeletedBody(Boolean bool) {
        this.chat_removed = bool;
    }
}
