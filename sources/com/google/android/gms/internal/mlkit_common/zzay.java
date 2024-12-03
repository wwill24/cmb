package com.google.android.gms.internal.mlkit_common;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.AbstractMap;

final class zzay extends zzar {
    final /* synthetic */ zzaz zza;

    zzay(zzaz zzaz) {
        this.zza = zzaz;
    }

    public final /* bridge */ /* synthetic */ Object get(int i10) {
        zzaf.zza(i10, this.zza.zzc, FirebaseAnalytics.Param.INDEX);
        zzaz zzaz = this.zza;
        int i11 = i10 + i10;
        Object obj = zzaz.zzb[i11];
        obj.getClass();
        Object obj2 = zzaz.zzb[i11 + 1];
        obj2.getClass();
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    public final int size() {
        return this.zza.zzc;
    }
}
