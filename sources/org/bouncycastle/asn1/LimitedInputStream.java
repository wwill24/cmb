package org.bouncycastle.asn1;

import java.io.InputStream;

abstract class LimitedInputStream extends InputStream {
    protected final InputStream _in;
    private int _limit;

    LimitedInputStream(InputStream inputStream, int i10) {
        this._in = inputStream;
        this._limit = i10;
    }

    /* access modifiers changed from: package-private */
    public int getLimit() {
        return this._limit;
    }

    /* access modifiers changed from: protected */
    public void setParentEofDetect(boolean z10) {
        InputStream inputStream = this._in;
        if (inputStream instanceof IndefiniteLengthInputStream) {
            ((IndefiniteLengthInputStream) inputStream).setEofOn00(z10);
        }
    }
}
