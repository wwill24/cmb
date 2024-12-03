package com.google.android.gms.internal.mlkit_vision_common;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.AbstractMap;

final class zzv extends zzp {
    final /* synthetic */ zzw zza;

    zzv(zzw zzw) {
        this.zza = zzw;
    }

    public final /* bridge */ /* synthetic */ Object get(int i10) {
        zzf.zza(i10, this.zza.zzc, FirebaseAnalytics.Param.INDEX);
        zzw zzw = this.zza;
        int i11 = i10 + i10;
        Object obj = zzw.zzb[i11];
        obj.getClass();
        Object obj2 = zzw.zzb[i11 + 1];
        obj2.getClass();
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    public final int size() {
        return this.zza.zzc;
    }
}
