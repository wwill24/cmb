package com.google.android.gms.internal.p003firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzld  reason: invalid package */
final class zzld implements zzbl {
    final zzcl zza;
    private final zzrp zzb;

    public zzld(zzcl zzcl) {
        zzrp zzrp;
        this.zza = zzcl;
        if (zzcl.zzf()) {
            zzrp = zznp.zza().zzb().zza(zznm.zza(zzcl), "hybrid_encrypt", "encrypt");
        } else {
            zzrp = zznm.zza;
        }
        this.zzb = zzrp;
    }
}
