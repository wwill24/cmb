package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzha  reason: invalid package */
public final /* synthetic */ class zzha implements zznz {
    public static final /* synthetic */ zzha zza = new zzha();

    private /* synthetic */ zzha() {
    }

    public final zzot zza(zzce zzce) {
        zzgz zzgz = (zzgz) zzce;
        int i10 = zzhe.zza;
        zzwm zza2 = zzwn.zza();
        zza2.zzb("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey");
        try {
            zzwn zzd = zzwn.zzd(zzcs.zzb(zzgz.zzb()), zzajx.zza());
            zzxl zzb = zzxm.zzb();
            zzb.zzb(zzgz.zzc());
            zzb.zza(zzd);
            zza2.zzc(((zzxm) zzb.zzi()).zzo());
            zza2.zza(zzxo.RAW);
            return zzop.zzb((zzwn) zza2.zzi());
        } catch (zzaks e10) {
            throw new GeneralSecurityException("Parsing KmsEnvelopeAeadKeyFormat failed: ", e10);
        }
    }
}
