package com.google.android.gms.internal.p003firebaseauthapi;

import java.io.IOException;
import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzcs  reason: invalid package */
public final class zzcs {
    public static zzce zza(byte[] bArr) throws GeneralSecurityException {
        try {
            zzwn zzd = zzwn.zzd(bArr, zzajx.zza());
            zznt zzc = zznt.zzc();
            zzop zza = zzop.zza(zzd);
            if (!zzc.zzi(zza)) {
                return new zznj(zza);
            }
            return zzc.zzb(zza);
        } catch (IOException e10) {
            throw new GeneralSecurityException("Failed to parse proto", e10);
        }
    }

    public static byte[] zzb(zzce zzce) throws GeneralSecurityException {
        if (zzce instanceof zznj) {
            return ((zznj) zzce).zzb().zzc().zzq();
        }
        return ((zzop) zznt.zzc().zzd(zzce, zzop.class)).zzc().zzq();
    }
}
