package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbv  reason: invalid package */
public final class zzbv {
    private final zzce zza;

    private zzbv(zzce zzce) {
        this.zza = zzce;
    }

    public static zzbv zza(zzce zzce) throws GeneralSecurityException {
        return new zzbv(zzce);
    }

    /* access modifiers changed from: package-private */
    public final zzwn zzb() throws GeneralSecurityException {
        zzce zzce = this.zza;
        if (zzce instanceof zznj) {
            return ((zznj) zzce).zzb().zzc();
        }
        return ((zzop) zznt.zzc().zzd(zzce, zzop.class)).zzc();
    }
}
