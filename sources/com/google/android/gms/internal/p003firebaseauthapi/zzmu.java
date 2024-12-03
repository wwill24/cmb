package com.google.android.gms.internal.p003firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmu  reason: invalid package */
public final class zzmu {
    private final Map zza;
    private final Map zzb;

    /* synthetic */ zzmu(Map map, Map map2, zzmt zzmt) {
        this.zza = map;
        this.zzb = map2;
    }

    public static zzms zza() {
        return new zzms((zzmr) null);
    }

    public final Enum zzb(Object obj) throws GeneralSecurityException {
        Enum enumR = (Enum) this.zzb.get(obj);
        if (enumR != null) {
            return enumR;
        }
        throw new GeneralSecurityException("Unable to convert object enum: ".concat(String.valueOf(obj)));
    }

    public final Object zzc(Enum enumR) throws GeneralSecurityException {
        Object obj = this.zza.get(enumR);
        if (obj != null) {
            return obj;
        }
        throw new GeneralSecurityException("Unable to convert proto enum: ".concat(String.valueOf(enumR)));
    }
}
