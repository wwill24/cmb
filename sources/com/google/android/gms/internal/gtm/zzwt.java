package com.google.android.gms.internal.gtm;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class zzwt {
    private static final zzwt zza = new zzwt();
    private final zzwy zzb = new zzwc();
    private final ConcurrentMap<Class<?>, zzwx<?>> zzc = new ConcurrentHashMap();

    private zzwt() {
    }

    public static zzwt zza() {
        return zza;
    }

    public final <T> zzwx<T> zzb(Class<T> cls) {
        zzvi.zzf(cls, "messageType");
        zzwx<T> zzwx = this.zzc.get(cls);
        if (zzwx == null) {
            zzwx = this.zzb.zza(cls);
            zzvi.zzf(cls, "messageType");
            zzvi.zzf(zzwx, "schema");
            zzwx<T> putIfAbsent = this.zzc.putIfAbsent(cls, zzwx);
            if (putIfAbsent == null) {
                return zzwx;
            }
            return putIfAbsent;
        }
        return zzwx;
    }
}
