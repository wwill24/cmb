package com.google.android.gms.internal.measurement;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;

final class zziz extends zzja {
    final transient int zza;
    final transient int zzb;
    final /* synthetic */ zzja zzc;

    zziz(zzja zzja, int i10, int i11) {
        this.zzc = zzja;
        this.zza = i10;
        this.zzb = i11;
    }

    public final Object get(int i10) {
        zzij.zza(i10, this.zzb, FirebaseAnalytics.Param.INDEX);
        return this.zzc.get(i10 + this.zza);
    }

    public final int size() {
        return this.zzb;
    }

    public final /* bridge */ /* synthetic */ List subList(int i10, int i11) {
        return subList(i10, i11);
    }

    /* access modifiers changed from: package-private */
    public final int zzb() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }

    /* access modifiers changed from: package-private */
    public final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    /* access modifiers changed from: package-private */
    public final Object[] zze() {
        return this.zzc.zze();
    }

    public final zzja zzf(int i10, int i11) {
        zzij.zzc(i10, i11, this.zzb);
        zzja zzja = this.zzc;
        int i12 = this.zza;
        return zzja.subList(i10 + i12, i11 + i12);
    }
}
