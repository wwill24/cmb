package com.google.android.gms.internal.mlkit_common;

import com.google.firebase.analytics.FirebaseAnalytics;

final class zzbb extends zzar {
    private final transient Object[] zza;
    private final transient int zzb;
    private final transient int zzc;

    zzbb(Object[] objArr, int i10, int i11) {
        this.zza = objArr;
        this.zzb = i10;
        this.zzc = i11;
    }

    public final Object get(int i10) {
        zzaf.zza(i10, this.zzc, FirebaseAnalytics.Param.INDEX);
        Object obj = this.zza[i10 + i10 + this.zzb];
        obj.getClass();
        return obj;
    }

    public final int size() {
        return this.zzc;
    }
}
