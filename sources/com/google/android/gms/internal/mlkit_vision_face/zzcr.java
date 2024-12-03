package com.google.android.gms.internal.mlkit_vision_face;

import androidx.annotation.NonNull;
import java.io.OutputStream;

final class zzcr extends OutputStream {
    private long zza = 0;

    zzcr() {
    }

    public final void write(int i10) {
        this.zza++;
    }

    public final void write(byte[] bArr) {
        this.zza += (long) bArr.length;
    }

    /* access modifiers changed from: package-private */
    public final long zza() {
        return this.zza;
    }

    public final void write(@NonNull byte[] bArr, int i10, int i11) {
        int length;
        int i12;
        if (i10 < 0 || i10 > (length = bArr.length) || i11 < 0 || (i12 = i10 + i11) > length || i12 < 0) {
            throw new IndexOutOfBoundsException();
        }
        this.zza += (long) i11;
    }
}
