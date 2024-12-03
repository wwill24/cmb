package com.google.android.gms.internal.gtm;

import android.annotation.SuppressLint;
import com.facebook.internal.security.CertificateUtil;
import rd.c;

@Deprecated
public final class zzfa {
    private static volatile c zza = new zzcu();

    public static c zza() {
        return zza;
    }

    @SuppressLint({"LogTagMismatch"})
    public static void zzb(String str, Object obj) {
        zzfb zza2 = zzfb.zza();
        if (zza2 != null) {
            zza2.zzK(str, obj);
        } else if (zzf(3)) {
            if (obj != null) {
                String str2 = (String) obj;
                StringBuilder sb2 = new StringBuilder(str.length() + 1 + str2.length());
                sb2.append(str);
                sb2.append(CertificateUtil.DELIMITER);
                sb2.append(str2);
            }
            String zzb = zzeu.zzc.zzb();
        }
        c cVar = zza;
        if (cVar != null) {
            cVar.error(str);
        }
    }

    public static void zzc(c cVar) {
        zza = cVar;
    }

    @SuppressLint({"LogTagMismatch"})
    public static void zzd(String str) {
        zzfb zza2 = zzfb.zza();
        if (zza2 != null) {
            zza2.zzO(str);
        } else if (zzf(0)) {
            String zzb = zzeu.zzc.zzb();
        }
        c cVar = zza;
        if (cVar != null) {
            cVar.verbose(str);
        }
    }

    @SuppressLint({"LogTagMismatch"})
    public static void zze(String str) {
        zzfb zza2 = zzfb.zza();
        if (zza2 != null) {
            zza2.zzR(str);
        } else if (zzf(2)) {
            String zzb = zzeu.zzc.zzb();
        }
        c cVar = zza;
        if (cVar != null) {
            cVar.warn(str);
        }
    }

    public static boolean zzf(int i10) {
        return zza != null && zza.getLogLevel() <= i10;
    }
}
