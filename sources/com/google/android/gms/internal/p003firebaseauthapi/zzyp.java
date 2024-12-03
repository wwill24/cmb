package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.Provider;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyp  reason: invalid package */
final class zzyp implements zzyu {
    private final zzzd zza;

    /* synthetic */ zzyp(zzzd zzzd, zzyo zzyo) {
        this.zza = zzzd;
    }

    public final Object zza(String str) throws GeneralSecurityException {
        for (Provider zza2 : zzyv.zzb("GmsCore_OpenSSL", "AndroidOpenSSL")) {
            try {
                return this.zza.zza(str, zza2);
            } catch (Exception unused) {
            }
        }
        return this.zza.zza(str, (Provider) null);
    }
}
