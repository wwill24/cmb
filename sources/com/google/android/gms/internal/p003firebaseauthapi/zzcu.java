package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzcu  reason: invalid package */
public final class zzcu {
    public static final String zza = "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey";
    public static final String zzb = "type.googleapis.com/google.crypto.tink.AesGcmKey";
    @Deprecated
    static final zzxr zzc;
    @Deprecated
    static final zzxr zzd;
    @Deprecated
    static final zzxr zze;

    static {
        new zzdh();
        new zzet();
        new zzfk();
        new zzec();
        new zzgi();
        new zzgm();
        new zzfy();
        new zzhp();
        zzxr zzb2 = zzxr.zzb();
        zzc = zzb2;
        zzd = zzb2;
        zze = zzb2;
        try {
            zza();
        } catch (GeneralSecurityException e10) {
            throw new ExceptionInInitializerError(e10);
        }
    }

    public static void zza() throws GeneralSecurityException {
        zzda.zzd();
        zzqq.zza();
        zzcq.zzg(new zzdh(), true);
        int i10 = zzds.zza;
        zzds.zzc(zznt.zzc());
        zzcq.zzg(new zzet(), true);
        int i11 = zzfd.zza;
        zzfd.zzc(zznt.zzc());
        if (!zzik.zzb()) {
            zzcq.zzg(new zzec(), true);
            int i12 = zzem.zza;
            zzem.zzc(zznt.zzc());
            zzfk.zzg(true);
            zzcq.zzg(new zzfy(), true);
            int i13 = zzgf.zza;
            zzgf.zzc(zznt.zzc());
            zzcq.zzg(new zzgi(), true);
            int i14 = zzgt.zza;
            zzgt.zza(zznt.zzc());
            zzcq.zzg(new zzgm(), true);
            int i15 = zzhe.zza;
            zzhe.zzc(zznt.zzc());
            zzcq.zzg(new zzhp(), true);
            int i16 = zzhw.zza;
            zzhw.zzc(zznt.zzc());
        }
    }
}
