package com.google.android.gms.internal.play_billing;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.AbstractMap;

final class zzab extends zzu {
    final /* synthetic */ zzac zza;

    zzab(zzac zzac) {
        this.zza = zzac;
    }

    public final /* bridge */ /* synthetic */ Object get(int i10) {
        zzm.zza(i10, this.zza.zzc, FirebaseAnalytics.Param.INDEX);
        zzac zzac = this.zza;
        int i11 = i10 + i10;
        Object obj = zzac.zzb[i11];
        obj.getClass();
        Object obj2 = zzac.zzb[i11 + 1];
        obj2.getClass();
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    public final int size() {
        return this.zza.zzc;
    }

    public final boolean zzf() {
        return true;
    }
}
