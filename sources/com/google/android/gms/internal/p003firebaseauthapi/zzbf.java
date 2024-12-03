package com.google.android.gms.internal.p003firebaseauthapi;

import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbf  reason: invalid package */
public final class zzbf implements zzca {
    private final OutputStream zza;

    private zzbf(OutputStream outputStream) {
        this.zza = outputStream;
    }

    public static zzca zza(OutputStream outputStream) {
        return new zzbf(outputStream);
    }

    public final void zzb(zzva zzva) throws IOException {
        throw null;
    }

    public final void zzc(zzwv zzwv) throws IOException {
        try {
            zzwv.zzp(this.zza);
        } finally {
            this.zza.close();
        }
    }
}
