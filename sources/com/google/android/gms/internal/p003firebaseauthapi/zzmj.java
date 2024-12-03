package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmj  reason: invalid package */
public final class zzmj {
    /* access modifiers changed from: private */
    public static final Object zza = new Object();
    /* access modifiers changed from: private */
    public static final String zzb = "zzmj";
    private final zzca zzc;
    private final zzbd zzd;
    private final zzbz zze;

    /* synthetic */ zzmj(zzmh zzmh, zzmi zzmi) {
        this.zzc = new zzmm(zzmh.zza, zzmh.zzb, zzmh.zzc);
        this.zzd = zzmh.zze;
        this.zze = zzmh.zzh;
    }

    static /* bridge */ /* synthetic */ boolean zzd() {
        return true;
    }

    public final synchronized zzby zza() throws GeneralSecurityException {
        return this.zze.zzb();
    }
}
