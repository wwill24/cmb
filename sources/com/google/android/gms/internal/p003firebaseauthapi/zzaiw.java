package com.google.android.gms.internal.p003firebaseauthapi;

import java.util.NoSuchElementException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaiw  reason: invalid package */
final class zzaiw extends zzaiy {
    final /* synthetic */ zzajf zza;
    private int zzb = 0;
    private final int zzc;

    zzaiw(zzajf zzajf) {
        this.zza = zzajf;
        this.zzc = zzajf.zzd();
    }

    public final boolean hasNext() {
        return this.zzb < this.zzc;
    }

    public final byte zza() {
        int i10 = this.zzb;
        if (i10 < this.zzc) {
            this.zzb = i10 + 1;
            return this.zza.zzb(i10);
        }
        throw new NoSuchElementException();
    }
}
