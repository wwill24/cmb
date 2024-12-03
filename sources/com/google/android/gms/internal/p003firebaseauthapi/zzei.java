package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzei  reason: invalid package */
public final /* synthetic */ class zzei implements zznz {
    public static final /* synthetic */ zzei zza = new zzei();

    private /* synthetic */ zzei() {
    }

    public final zzot zza(zzce zzce) {
        zzxo zzxo;
        zzeh zzeh = (zzeh) zzce;
        int i10 = zzem.zza;
        zzwm zza2 = zzwn.zza();
        zza2.zzb("type.googleapis.com/google.crypto.tink.AesEaxKey");
        zzsz zzb = zzta.zzb();
        zztc zzb2 = zztd.zzb();
        zzb2.zza(zzeh.zzb());
        zzb.zzb((zztd) zzb2.zzi());
        zzb.zza(zzeh.zzc());
        zza2.zzc(((zzta) zzb.zzi()).zzo());
        zzef zzd = zzeh.zzd();
        if (zzef.zza.equals(zzd)) {
            zzxo = zzxo.TINK;
        } else if (zzef.zzb.equals(zzd)) {
            zzxo = zzxo.CRUNCHY;
        } else if (zzef.zzc.equals(zzd)) {
            zzxo = zzxo.RAW;
        } else {
            throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(zzd)));
        }
        zza2.zza(zzxo);
        return zzop.zzb((zzwn) zza2.zzi());
    }
}
