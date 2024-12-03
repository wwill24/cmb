package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.AbstractMap;

final class zzct extends zzcd {
    final /* synthetic */ zzcu zza;

    zzct(zzcu zzcu) {
        this.zza = zzcu;
    }

    public final /* bridge */ /* synthetic */ Object get(int i10) {
        zzaq.zza(i10, this.zza.zzc, FirebaseAnalytics.Param.INDEX);
        zzcu zzcu = this.zza;
        int i11 = i10 + i10;
        Object obj = zzcu.zzb[i11];
        obj.getClass();
        Object obj2 = zzcu.zzb[i11 + 1];
        obj2.getClass();
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    public final int size() {
        return this.zza.zzc;
    }
}
