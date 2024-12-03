package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzgt  reason: invalid package */
final class zzgt {
    public static final /* synthetic */ int zza = 0;
    private static final zzzo zzb;
    private static final zzob zzc;
    private static final zznx zzd;
    private static final zzne zze;
    private static final zzna zzf;

    static {
        Class<zzoo> cls = zzoo.class;
        Class<zzop> cls2 = zzop.class;
        zzzo zzb2 = zzpd.zzb("type.googleapis.com/google.crypto.tink.KmsAeadKey");
        zzb = zzb2;
        zzc = zzob.zzb(zzgp.zza, zzgo.class, cls2);
        zzd = zznx.zzb(zzgq.zza, zzb2, cls2);
        zze = zzne.zza(zzgr.zza, zzgn.class, cls);
        zzf = zzna.zzb(zzgs.zza, zzb2, cls);
    }

    public static void zza(zznt zznt) throws GeneralSecurityException {
        zznt.zzh(zzc);
        zznt.zzg(zzd);
        zznt.zzf(zze);
        zznt.zze(zzf);
    }
}
