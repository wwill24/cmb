package com.facebook.stetho.inspector.network;

import java.io.IOException;

public class DefaultResponseHandler implements ResponseHandler {
    private int mBytesRead = 0;
    private int mDecodedBytesRead = -1;
    private final NetworkEventReporter mEventReporter;
    private final String mRequestId;

    public DefaultResponseHandler(NetworkEventReporter networkEventReporter, String str) {
        this.mEventReporter = networkEventReporter;
        this.mRequestId = str;
    }

    private void reportDataReceived() {
        NetworkEventReporter networkEventReporter = this.mEventReporter;
        String str = this.mRequestId;
        int i10 = this.mBytesRead;
        int i11 = this.mDecodedBytesRead;
        if (i11 < 0) {
            i11 = i10;
        }
        networkEventReporter.dataReceived(str, i10, i11);
    }

    public void onEOF() {
        reportDataReceived();
        this.mEventReporter.responseReadFinished(this.mRequestId);
    }

    public void onError(IOException iOException) {
        reportDataReceived();
        this.mEventReporter.responseReadFailed(this.mRequestId, iOException.toString());
    }

    public void onRead(int i10) {
        this.mBytesRead += i10;
    }

    public void onReadDecoded(int i10) {
        if (this.mDecodedBytesRead == -1) {
            this.mDecodedBytesRead = 0;
        }
        this.mDecodedBytesRead += i10;
    }
}
