package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzcz  reason: invalid package */
final class zzcz implements zzbd {
    private final zzcl zza;
    private final zzrp zzb;
    private final zzrp zzc;

    /* synthetic */ zzcz(zzcl zzcl, zzcy zzcy) {
        zzrp zzrp;
        this.zza = zzcl;
        if (zzcl.zzf()) {
            zzrq zzb2 = zznp.zza().zzb();
            zzrv zza2 = zznm.zza(zzcl);
            this.zzb = zzb2.zza(zza2, "aead", "encrypt");
            zzrp = zzb2.zza(zza2, "aead", "decrypt");
        } else {
            zzrp = zznm.zza;
            this.zzb = zzrp;
        }
        this.zzc = zzrp;
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        if (length > 5) {
            byte[] copyOf = Arrays.copyOf(bArr, 5);
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 5, length);
            for (zzch zzch : this.zza.zze(copyOf)) {
                try {
                    byte[] zza2 = ((zzbd) zzch.zze()).zza(copyOfRange, bArr2);
                    zzch.zza();
                    int length2 = copyOfRange.length;
                    return zza2;
                } catch (GeneralSecurityException unused) {
                }
            }
        }
        for (zzch zzch2 : this.zza.zze(zzbi.zza)) {
            try {
                byte[] zza3 = ((zzbd) zzch2.zze()).zza(bArr, bArr2);
                zzch2.zza();
                return zza3;
            } catch (GeneralSecurityException unused2) {
            }
        }
        throw new GeneralSecurityException("decryption failed");
    }

    public final byte[] zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        throw null;
    }
}
