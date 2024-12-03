package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqv  reason: invalid package */
final class zzqv implements zzcd {
    private final zzcl zza;
    private final zzrp zzb;
    private final zzrp zzc;

    /* synthetic */ zzqv(zzcl zzcl, zzqu zzqu) {
        zzrp zzrp;
        this.zza = zzcl;
        if (zzcl.zzf()) {
            zzrq zzb2 = zznp.zza().zzb();
            zzrv zza2 = zznm.zza(zzcl);
            this.zzb = zzb2.zza(zza2, "mac", "compute");
            zzrp = zzb2.zza(zza2, "mac", "verify");
        } else {
            zzrp = zznm.zza;
            this.zzb = zzrp;
        }
        this.zzc = zzrp;
    }

    public final void zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length > 5) {
            for (zzch zzch : this.zza.zze(Arrays.copyOf(bArr, 5))) {
                try {
                    ((zzcd) zzch.zzd()).zza(bArr, bArr2);
                    zzch.zza();
                    return;
                } catch (GeneralSecurityException unused) {
                }
            }
            for (zzch zzch2 : this.zza.zze(zzbi.zza)) {
                try {
                    ((zzcd) zzch2.zzd()).zza(bArr, bArr2);
                    zzch2.zza();
                    return;
                } catch (GeneralSecurityException unused2) {
                }
            }
            throw new GeneralSecurityException("invalid MAC");
        }
        throw new GeneralSecurityException("tag too short");
    }
}
