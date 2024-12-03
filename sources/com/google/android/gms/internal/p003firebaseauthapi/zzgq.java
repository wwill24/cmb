package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzgq  reason: invalid package */
public final /* synthetic */ class zzgq implements zznv {
    public static final /* synthetic */ zzgq zza = new zzgq();

    private /* synthetic */ zzgq() {
    }

    public final zzce zza(zzot zzot) {
        int i10 = zzgt.zza;
        zzop zzop = (zzop) zzot;
        if (zzop.zzc().zzg().equals("type.googleapis.com/google.crypto.tink.KmsAeadKey")) {
            try {
                zzxg zzd = zzxg.zzd(((zzop) zzot).zzc().zzf(), zzajx.zza());
                if (zzop.zzc().zze() == zzxo.RAW) {
                    return zzgo.zzb(zzd.zze());
                }
                String valueOf = String.valueOf(zzop.zzc().zze());
                String valueOf2 = String.valueOf(zzd);
                throw new GeneralSecurityException("Only key templates with RAW are accepted, but got " + valueOf + " with format " + valueOf2);
            } catch (zzaks e10) {
                throw new GeneralSecurityException("Parsing KmsAeadKeyFormat failed: ", e10);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsAeadProtoSerialization.parseParameters: ".concat(String.valueOf(zzop.zzc().zzg())));
        }
    }
}
