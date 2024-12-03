package com.google.android.gms.internal.mlkit_vision_face;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.AbstractMap;

final class zzcd extends zzbn {
    final /* synthetic */ zzce zza;

    zzcd(zzce zzce) {
        this.zza = zzce;
    }

    public final /* bridge */ /* synthetic */ Object get(int i10) {
        zzab.zza(i10, this.zza.zzc, FirebaseAnalytics.Param.INDEX);
        zzce zzce = this.zza;
        int i11 = i10 + i10;
        Object obj = zzce.zzb[i11];
        obj.getClass();
        Object obj2 = zzce.zzb[i11 + 1];
        obj2.getClass();
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    public final int size() {
        return this.zza.zzc;
    }
}
