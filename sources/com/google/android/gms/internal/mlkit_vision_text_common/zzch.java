package com.google.android.gms.internal.mlkit_vision_text_common;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.AbstractMap;

final class zzch extends zzbm {
    final /* synthetic */ zzci zza;

    zzch(zzci zzci) {
        this.zza = zzci;
    }

    public final /* bridge */ /* synthetic */ Object get(int i10) {
        zzaa.zza(i10, this.zza.zzc, FirebaseAnalytics.Param.INDEX);
        zzci zzci = this.zza;
        int i11 = i10 + i10;
        Object obj = zzci.zzb[i11];
        obj.getClass();
        Object obj2 = zzci.zzb[i11 + 1];
        obj2.getClass();
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    public final int size() {
        return this.zza.zzc;
    }
}
