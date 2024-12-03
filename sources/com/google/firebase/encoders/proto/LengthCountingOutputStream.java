package com.google.firebase.encoders.proto;

import androidx.annotation.NonNull;
import java.io.OutputStream;

final class LengthCountingOutputStream extends OutputStream {
    private long length = 0;

    LengthCountingOutputStream() {
    }

    /* access modifiers changed from: package-private */
    public long getLength() {
        return this.length;
    }

    public void write(int i10) {
        this.length++;
    }

    public void write(byte[] bArr) {
        this.length += (long) bArr.length;
    }

    public void write(@NonNull byte[] bArr, int i10, int i11) {
        int i12;
        if (i10 < 0 || i10 > bArr.length || i11 < 0 || (i12 = i10 + i11) > bArr.length || i12 < 0) {
            throw new IndexOutOfBoundsException();
        }
        this.length += (long) i11;
    }
}
