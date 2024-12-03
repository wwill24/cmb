package com.google.android.gms.internal.p003firebaseauthapi;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbe  reason: invalid package */
public final class zzbe {
    private final InputStream zza;

    private zzbe(InputStream inputStream) {
        this.zza = inputStream;
    }

    public static zzbe zzc(byte[] bArr) {
        return new zzbe(new ByteArrayInputStream(bArr));
    }

    public final zzva zza() throws IOException {
        try {
            return zzva.zzc(this.zza, zzajx.zza());
        } finally {
            this.zza.close();
        }
    }

    public final zzwv zzb() throws IOException {
        try {
            return zzwv.zzf(this.zza, zzajx.zza());
        } finally {
            this.zza.close();
        }
    }
}
