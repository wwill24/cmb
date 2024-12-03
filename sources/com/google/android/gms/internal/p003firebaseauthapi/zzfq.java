package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfq  reason: invalid package */
public final /* synthetic */ class zzfq implements zznz {
    public static final /* synthetic */ zzfq zza = new zzfq();

    private /* synthetic */ zzfq() {
    }

    public final zzot zza(zzce zzce) {
        zzxo zzxo;
        zzfp zzfp = (zzfp) zzce;
        int i10 = zzfu.zza;
        zzwm zza2 = zzwn.zza();
        zza2.zzb("type.googleapis.com/google.crypto.tink.AesGcmSivKey");
        zzto zzc = zztp.zzc();
        zzc.zza(zzfp.zzb());
        zza2.zzc(((zztp) zzc.zzi()).zzo());
        zzfn zzc2 = zzfp.zzc();
        if (zzfn.zza.equals(zzc2)) {
            zzxo = zzxo.TINK;
        } else if (zzfn.zzb.equals(zzc2)) {
            zzxo = zzxo.CRUNCHY;
        } else if (zzfn.zzc.equals(zzc2)) {
            zzxo = zzxo.RAW;
        } else {
            throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(zzc2)));
        }
        zza2.zza(zzxo);
        return zzop.zzb((zzwn) zza2.zzi());
    }
}
