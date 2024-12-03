package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzlb  reason: invalid package */
final class zzlb implements zzbk {
    private final zzcl zza;
    private final zzrp zzb;

    public zzlb(zzcl zzcl) {
        zzrp zzrp;
        this.zza = zzcl;
        if (zzcl.zzf()) {
            zzrp = zznp.zza().zzb().zza(zznm.zza(zzcl), "hybrid_decrypt", "decrypt");
        } else {
            zzrp = zznm.zza;
        }
        this.zzb = zzrp;
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        if (length > 5) {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, 5);
            byte[] copyOfRange2 = Arrays.copyOfRange(bArr, 5, length);
            for (zzch zzch : this.zza.zze(copyOfRange)) {
                try {
                    byte[] zza2 = ((zzbk) zzch.zze()).zza(copyOfRange2, (byte[]) null);
                    zzch.zza();
                    int length2 = copyOfRange2.length;
                    return zza2;
                } catch (GeneralSecurityException unused) {
                }
            }
        }
        for (zzch zzch2 : this.zza.zze(zzbi.zza)) {
            try {
                byte[] zza3 = ((zzbk) zzch2.zze()).zza(bArr, (byte[]) null);
                zzch2.zza();
                return zza3;
            } catch (GeneralSecurityException unused2) {
            }
        }
        throw new GeneralSecurityException("decryption failed");
    }
}
