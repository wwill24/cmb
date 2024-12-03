package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.p;
import me.f;

final class zzfo {
    private final f zza;
    private long zzb;

    public zzfo(f fVar) {
        p.k(fVar);
        this.zza = fVar;
    }

    public final void zza() {
        this.zzb = 0;
    }

    public final void zzb() {
        this.zzb = this.zza.b();
    }

    public final boolean zzc(long j10) {
        return this.zzb == 0 || this.zza.b() - this.zzb > j10;
    }

    public zzfo(f fVar, long j10) {
        p.k(fVar);
        this.zza = fVar;
        this.zzb = j10;
    }
}
