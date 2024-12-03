package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzhs  reason: invalid package */
public final /* synthetic */ class zzhs implements zznz {
    public static final /* synthetic */ zzhs zza = new zzhs();

    private /* synthetic */ zzhs() {
    }

    public final zzot zza(zzce zzce) {
        zzxo zzxo;
        int i10 = zzhw.zza;
        zzwm zza2 = zzwn.zza();
        zza2.zzb("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key");
        zza2.zzc(zzxx.zzc().zzo());
        zzhq zzb = ((zzhr) zzce).zzb();
        if (zzhq.zza.equals(zzb)) {
            zzxo = zzxo.TINK;
        } else if (zzhq.zzb.equals(zzb)) {
            zzxo = zzxo.CRUNCHY;
        } else if (zzhq.zzc.equals(zzb)) {
            zzxo = zzxo.RAW;
        } else {
            throw new GeneralSecurityException("Unable to serialize variant: ".concat(zzb.toString()));
        }
        zza2.zza(zzxo);
        return zzop.zzb((zzwn) zza2.zzi());
    }
}
