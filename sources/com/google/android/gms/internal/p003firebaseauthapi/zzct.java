package com.google.android.gms.internal.p003firebaseauthapi;

import java.nio.charset.Charset;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzct  reason: invalid package */
final class zzct {
    public static final Charset zza = Charset.forName("UTF-8");

    public static zzxa zza(zzwv zzwv) {
        zzwx zza2 = zzxa.zza();
        zza2.zzb(zzwv.zzb());
        for (zzwu zzwu : zzwv.zzh()) {
            zzwy zzb = zzwz.zzb();
            zzb.zzc(zzwu.zzb().zzf());
            zzb.zzd(zzwu.zzk());
            zzb.zzb(zzwu.zze());
            zzb.zza(zzwu.zza());
            zza2.zza((zzwz) zzb.zzi());
        }
        return (zzxa) zza2.zzi();
    }
}
