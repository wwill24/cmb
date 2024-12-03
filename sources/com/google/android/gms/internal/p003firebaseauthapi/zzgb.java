package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzgb  reason: invalid package */
public final /* synthetic */ class zzgb implements zznz {
    public static final /* synthetic */ zzgb zza = new zzgb();

    private /* synthetic */ zzgb() {
    }

    public final zzot zza(zzce zzce) {
        zzxo zzxo;
        int i10 = zzgf.zza;
        zzwm zza2 = zzwn.zza();
        zza2.zzb("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key");
        zza2.zzc(zzub.zzb().zzo());
        zzfz zzb = ((zzga) zzce).zzb();
        if (zzfz.zza.equals(zzb)) {
            zzxo = zzxo.TINK;
        } else if (zzfz.zzb.equals(zzb)) {
            zzxo = zzxo.CRUNCHY;
        } else if (zzfz.zzc.equals(zzb)) {
            zzxo = zzxo.RAW;
        } else {
            throw new GeneralSecurityException("Unable to serialize variant: ".concat(zzb.toString()));
        }
        zza2.zza(zzxo);
        return zzop.zzb((zzwn) zza2.zzi());
    }
}
