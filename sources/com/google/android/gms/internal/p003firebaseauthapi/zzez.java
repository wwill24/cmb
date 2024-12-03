package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzez  reason: invalid package */
public final /* synthetic */ class zzez implements zznz {
    public static final /* synthetic */ zzez zza = new zzez();

    private /* synthetic */ zzez() {
    }

    public final zzot zza(zzce zzce) {
        zzxo zzxo;
        zzey zzey = (zzey) zzce;
        int i10 = zzfd.zza;
        zzwm zza2 = zzwn.zza();
        zza2.zzb("type.googleapis.com/google.crypto.tink.AesGcmKey");
        zzti zzc = zztj.zzc();
        zzc.zza(zzey.zzb());
        zza2.zzc(((zztj) zzc.zzi()).zzo());
        zzew zzd = zzey.zzd();
        if (zzew.zza.equals(zzd)) {
            zzxo = zzxo.TINK;
        } else if (zzew.zzb.equals(zzd)) {
            zzxo = zzxo.CRUNCHY;
        } else if (zzew.zzc.equals(zzd)) {
            zzxo = zzxo.RAW;
        } else {
            throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(zzd)));
        }
        zza2.zza(zzxo);
        return zzop.zzb((zzwn) zza2.zzi());
    }
}
