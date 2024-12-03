package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjc  reason: invalid package */
public final class zzjc {
    public static final String zza = "type.googleapis.com/google.crypto.tink.AesSivKey";
    @Deprecated
    static final zzxr zzb = zzxr.zzb();
    @Deprecated
    static final zzxr zzc = zzxr.zzb();

    static {
        new zzir();
        try {
            zza();
        } catch (GeneralSecurityException e10) {
            throw new ExceptionInInitializerError(e10);
        }
    }

    public static void zza() throws GeneralSecurityException {
        zzjg.zzd();
        if (!zzik.zzb()) {
            zzcq.zzg(new zzir(), true);
            int i10 = zzjb.zza;
            zzjb.zzd(zznt.zzc());
        }
    }
}
