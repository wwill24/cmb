package com.google.android.gms.internal.p003firebaseauthapi;

import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zznp  reason: invalid package */
public final class zznp {
    private static final zznp zza = new zznp();
    private static final zzno zzb = new zzno((zznn) null);
    private final AtomicReference zzc = new AtomicReference();

    public static zznp zza() {
        return zza;
    }

    public final zzrq zzb() {
        zzrq zzrq = (zzrq) this.zzc.get();
        return zzrq == null ? zzb : zzrq;
    }
}
