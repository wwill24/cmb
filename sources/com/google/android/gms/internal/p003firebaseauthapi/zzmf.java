package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmf  reason: invalid package */
final class zzmf implements zzlu {
    private final zzzo zza;
    private final zzzo zzb;

    private zzmf(byte[] bArr, byte[] bArr2) {
        this.zza = zzzo.zzb(bArr);
        this.zzb = zzzo.zzb(bArr2);
    }

    static zzmf zzc(byte[] bArr) throws GeneralSecurityException {
        return new zzmf(bArr, zzzm.zzb(bArr));
    }

    public final zzzo zza() {
        return this.zza;
    }

    public final zzzo zzb() {
        return this.zzb;
    }
}
