package com.google.android.gms.internal.p003firebaseauthapi;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzms  reason: invalid package */
public final class zzms {
    final Map zza = new HashMap();
    final Map zzb = new HashMap();

    private zzms() {
    }

    public final zzms zza(Enum enumR, Object obj) {
        this.zza.put(enumR, obj);
        this.zzb.put(obj, enumR);
        return this;
    }

    public final zzmu zzb() {
        return new zzmu(Collections.unmodifiableMap(this.zza), Collections.unmodifiableMap(this.zzb), (zzmt) null);
    }

    /* synthetic */ zzms(zzmr zzmr) {
    }
}
