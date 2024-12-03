package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqa  reason: invalid package */
public final class zzqa implements zzcm {
    private static final zzqa zza = new zzqa();

    private zzqa() {
    }

    static void zzd() throws GeneralSecurityException {
        zzcq.zzh(zza);
    }

    public final Class zza() {
        return zzpx.class;
    }

    public final Class zzb() {
        return zzpx.class;
    }

    public final /* bridge */ /* synthetic */ Object zzc(zzcl zzcl) throws GeneralSecurityException {
        if (zzcl.zza() != null) {
            for (List<zzch> it : zzcl.zzd()) {
                for (zzch zzd : it) {
                    zzpx zzpx = (zzpx) zzd.zzd();
                }
            }
            return new zzpz(zzcl, (zzpy) null);
        }
        throw new GeneralSecurityException("no primary in primitive set");
    }
}
