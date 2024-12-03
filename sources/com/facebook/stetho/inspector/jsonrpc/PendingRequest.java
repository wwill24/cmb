package com.facebook.stetho.inspector.jsonrpc;

public class PendingRequest {
    public final PendingRequestCallback callback;
    public final long requestId;

    public PendingRequest(long j10, PendingRequestCallback pendingRequestCallback) {
        this.requestId = j10;
        this.callback = pendingRequestCallback;
    }
}
