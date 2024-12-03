package com.leanplum.internal;

import androidx.annotation.NonNull;
import java.util.List;
import java.util.Map;

public class RequestBatch {
    String jsonEncoded;
    List<Map<String, Object>> requests;
    List<Map<String, Object>> requestsToSend;

    public RequestBatch(@NonNull List<Map<String, Object>> list, @NonNull List<Map<String, Object>> list2, @NonNull String str) {
        this.requests = list;
        this.requestsToSend = list2;
        this.jsonEncoded = str;
    }

    public int getEventsCount() {
        return this.requests.size();
    }

    public String getJson() {
        return this.jsonEncoded;
    }

    public boolean isEmpty() {
        return this.requestsToSend.isEmpty();
    }

    public boolean isFull() {
        return getEventsCount() == RequestBatchFactory.MAX_EVENTS_PER_API_CALL;
    }
}
