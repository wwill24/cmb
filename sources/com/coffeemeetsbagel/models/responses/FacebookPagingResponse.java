package com.coffeemeetsbagel.models.responses;

public class FacebookPagingResponse {
    private FacebookCursorResponse cursors;
    private String next;

    public FacebookCursorResponse getCursors() {
        return this.cursors;
    }

    public String getNext() {
        return this.next;
    }
}
