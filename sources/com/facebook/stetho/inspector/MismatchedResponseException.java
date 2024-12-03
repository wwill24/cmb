package com.facebook.stetho.inspector;

public class MismatchedResponseException extends MessageHandlingException {
    public long mRequestId;

    public MismatchedResponseException(long j10) {
        super("Response for request id " + j10 + ", but no such request is pending");
        this.mRequestId = j10;
    }

    public long getRequestId() {
        return this.mRequestId;
    }
}
