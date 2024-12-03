package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqw  reason: invalid package */
final class zzqw implements zzcm {
    private static final zzqw zza = new zzqw();
    private static final zzof zzb = zzof.zzb(zzqt.zza, zzni.class, zzcd.class);

    zzqw() {
    }

    public static void zzd() throws GeneralSecurityException {
        zzcq.zzh(zza);
        zznq.zza().zze(zzb);
    }

    public final Class zza() {
        return zzcd.class;
    }

    public final Class zzb() {
        return zzcd.class;
    }

    public final /* bridge */ /* synthetic */ Object zzc(zzcl zzcl) throws GeneralSecurityException {
        for (List it : zzcl.zzd()) {
            Iterator it2 = it.iterator();
            while (true) {
                if (it2.hasNext()) {
                    zzch zzch = (zzch) it2.next();
                    if (zzch.zzb() instanceof zzqr) {
                        zzqr zzqr = (zzqr) zzch.zzb();
                        zzzo zzb2 = zzzo.zzb(zzch.zzg());
                        if (!zzb2.equals(zzqr.zzc())) {
                            String valueOf = String.valueOf(zzqr.zzb());
                            String obj = zzqr.zzc().toString();
                            String obj2 = zzb2.toString();
                            throw new GeneralSecurityException("Mac Key with parameters " + valueOf + " has wrong output prefix (" + obj + ") instead of (" + obj2 + ")");
                        }
                    }
                }
            }
        }
        return new zzqv(zzcl, (zzqu) null);
    }
}
