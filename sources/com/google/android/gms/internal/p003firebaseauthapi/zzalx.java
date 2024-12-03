package com.google.android.gms.internal.p003firebaseauthapi;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzalx  reason: invalid package */
final class zzalx {
    private static final zzalx zza = new zzalx();
    private final zzamc zzb = new zzalh();
    private final ConcurrentMap zzc = new ConcurrentHashMap();

    private zzalx() {
    }

    public static zzalx zza() {
        return zza;
    }

    public final zzamb zzb(Class cls) {
        zzakq.zzc(cls, "messageType");
        zzamb zzamb = (zzamb) this.zzc.get(cls);
        if (zzamb == null) {
            zzamb = this.zzb.zza(cls);
            zzakq.zzc(cls, "messageType");
            zzamb zzamb2 = (zzamb) this.zzc.putIfAbsent(cls, zzamb);
            if (zzamb2 == null) {
                return zzamb;
            }
            return zzamb2;
        }
        return zzamb;
    }
}
