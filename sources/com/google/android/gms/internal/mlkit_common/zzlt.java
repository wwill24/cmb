package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.common.internal.n;

public final class zzlt {
    private final zzlp zza;
    private final zzlr zzb = null;
    private final zzlr zzc = null;
    private final Boolean zzd = null;

    /* synthetic */ zzlt(zzlq zzlq, zzls zzls) {
        this.zza = zzlq.zza;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzlt) && n.b(this.zza, ((zzlt) obj).zza) && n.b((Object) null, (Object) null) && n.b((Object) null, (Object) null) && n.b((Object) null, (Object) null)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return n.c(this.zza, null, null, null);
    }

    @zzbo(zza = 1)
    public final zzlp zza() {
        return this.zza;
    }
}
