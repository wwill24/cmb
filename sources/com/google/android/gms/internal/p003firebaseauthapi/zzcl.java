package com.google.android.gms.internal.p003firebaseauthapi;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentMap;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzcl  reason: invalid package */
public final class zzcl {
    private final ConcurrentMap zza;
    private final List zzb;
    private final zzch zzc;
    private final Class zzd;
    private final zzro zze;

    /* synthetic */ zzcl(ConcurrentMap concurrentMap, List list, zzch zzch, zzro zzro, Class cls, zzck zzck) {
        this.zza = concurrentMap;
        this.zzb = list;
        this.zzc = zzch;
        this.zzd = cls;
        this.zze = zzro;
    }

    public final zzch zza() {
        return this.zzc;
    }

    public final zzro zzb() {
        return this.zze;
    }

    public final Class zzc() {
        return this.zzd;
    }

    public final Collection zzd() {
        return this.zza.values();
    }

    public final List zze(byte[] bArr) {
        List list = (List) this.zza.get(new zzcj(bArr, (zzci) null));
        if (list != null) {
            return list;
        }
        return Collections.emptyList();
    }

    public final boolean zzf() {
        return !this.zze.zza().isEmpty();
    }
}
