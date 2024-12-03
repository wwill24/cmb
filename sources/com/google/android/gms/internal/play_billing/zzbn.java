package com.google.android.gms.internal.play_billing;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class zzbn {
    static final zzbn zza = new zzbn(true);
    public static final /* synthetic */ int zzb = 0;
    private static volatile boolean zzc = false;
    private static volatile zzbn zzd;
    private final Map zze;

    zzbn() {
        this.zze = new HashMap();
    }

    public static zzbn zza() {
        Class<zzbn> cls = zzbn.class;
        zzbn zzbn = zzd;
        if (zzbn != null) {
            return zzbn;
        }
        synchronized (cls) {
            zzbn zzbn2 = zzd;
            if (zzbn2 != null) {
                return zzbn2;
            }
            zzbn zzb2 = zzbv.zzb(cls);
            zzd = zzb2;
            return zzb2;
        }
    }

    public final zzbz zzb(zzdf zzdf, int i10) {
        return (zzbz) this.zze.get(new zzbm(zzdf, i10));
    }

    zzbn(boolean z10) {
        this.zze = Collections.emptyMap();
    }
}
