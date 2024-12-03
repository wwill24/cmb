package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzps  reason: invalid package */
public final /* synthetic */ class zzps implements zznz {
    public static final /* synthetic */ zzps zza = new zzps();

    private /* synthetic */ zzps() {
    }

    public final zzot zza(zzce zzce) {
        zzxo zzxo;
        zzpr zzpr = (zzpr) zzce;
        int i10 = zzpw.zza;
        zzwm zza2 = zzwn.zza();
        zza2.zzb("type.googleapis.com/google.crypto.tink.AesCmacKey");
        zzsb zzb = zzsc.zzb();
        zzse zzb2 = zzsf.zzb();
        zzb2.zza(zzpr.zzb());
        zzb.zzb((zzsf) zzb2.zzi());
        zzb.zza(zzpr.zzc());
        zza2.zzc(((zzsc) zzb.zzi()).zzo());
        zzpp zze = zzpr.zze();
        if (zzpp.zza.equals(zze)) {
            zzxo = zzxo.TINK;
        } else if (zzpp.zzb.equals(zze)) {
            zzxo = zzxo.CRUNCHY;
        } else if (zzpp.zzd.equals(zze)) {
            zzxo = zzxo.RAW;
        } else if (zzpp.zzc.equals(zze)) {
            zzxo = zzxo.LEGACY;
        } else {
            throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(zze)));
        }
        zza2.zza(zzxo);
        return zzop.zzb((zzwn) zza2.zzi());
    }
}
