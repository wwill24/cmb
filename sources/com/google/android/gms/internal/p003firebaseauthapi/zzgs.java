package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzgs  reason: invalid package */
public final /* synthetic */ class zzgs implements zzmy {
    public static final /* synthetic */ zzgs zza = new zzgs();

    private /* synthetic */ zzgs() {
    }

    public final zzbn zza(zzot zzot, zzcr zzcr) {
        int i10 = zzgt.zza;
        zzoo zzoo = (zzoo) zzot;
        if (!zzoo.zzg().equals("type.googleapis.com/google.crypto.tink.KmsAeadKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsAeadProtoSerialization.parseKey");
        } else if (zzoo.zzc() == zzxo.RAW) {
            try {
                zzxd zzd = zzxd.zzd(((zzoo) zzot).zze(), zzajx.zza());
                if (zzd.zza() == 0) {
                    return zzgn.zza(zzgo.zzb(zzd.zze().zze()));
                }
                String valueOf = String.valueOf(zzd);
                throw new GeneralSecurityException("KmsAeadKey are only accepted with version 0, got " + valueOf);
            } catch (zzaks e10) {
                throw new GeneralSecurityException("Parsing KmsAeadKey failed: ", e10);
            }
        } else {
            throw new GeneralSecurityException("KmsAeadKey are only accepted with RAW, got ".concat(String.valueOf(zzoo.zzc())));
        }
    }
}
