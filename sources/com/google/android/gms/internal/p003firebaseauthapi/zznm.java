package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zznm  reason: invalid package */
public final class zznm {
    public static final zzrp zza = new zznl((zznk) null);

    public static zzrv zza(zzcl zzcl) {
        zzbu zzbu;
        zzrr zzrr = new zzrr();
        zzrr.zzb(zzcl.zzb());
        for (List it : zzcl.zzd()) {
            Iterator it2 = it.iterator();
            while (true) {
                if (it2.hasNext()) {
                    zzch zzch = (zzch) it2.next();
                    int zzh = zzch.zzh() - 2;
                    if (zzh == 1) {
                        zzbu = zzbu.zza;
                    } else if (zzh == 2) {
                        zzbu = zzbu.zzb;
                    } else if (zzh == 3) {
                        zzbu = zzbu.zzc;
                    } else {
                        throw new IllegalStateException("Unknown key status");
                    }
                    int zza2 = zzch.zza();
                    String zzf = zzch.zzf();
                    if (zzf.startsWith("type.googleapis.com/google.crypto.")) {
                        zzf = zzf.substring(34);
                    }
                    zzrr.zza(zzbu, zza2, zzf, zzch.zzc().name());
                }
            }
        }
        if (zzcl.zza() != null) {
            zzrr.zzc(zzcl.zza().zza());
        }
        try {
            return zzrr.zzd();
        } catch (GeneralSecurityException e10) {
            throw new IllegalStateException(e10);
        }
    }
}
