package com.google.android.gms.internal.mlkit_vision_text_common;

import com.google.firebase.analytics.FirebaseAnalytics;

final class zzcg extends zzbm {
    static final zzbm zza = new zzcg(new Object[0], 0);
    final transient Object[] zzb;
    private final transient int zzc;

    zzcg(Object[] objArr, int i10) {
        this.zzb = objArr;
        this.zzc = i10;
    }

    public final Object get(int i10) {
        zzaa.zza(i10, this.zzc, FirebaseAnalytics.Param.INDEX);
        Object obj = this.zzb[i10];
        obj.getClass();
        return obj;
    }

    public final int size() {
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final int zza(Object[] objArr, int i10) {
        System.arraycopy(this.zzb, 0, objArr, 0, this.zzc);
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final int zzb() {
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final int zzc() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final Object[] zze() {
        return this.zzb;
    }
}
