package com.google.android.gms.internal.mlkit_vision_common;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;

final class zzo extends zzp {
    final transient int zza;
    final transient int zzb;
    final /* synthetic */ zzp zzc;

    zzo(zzp zzp, int i10, int i11) {
        this.zzc = zzp;
        this.zza = i10;
        this.zzb = i11;
    }

    public final Object get(int i10) {
        zzf.zza(i10, this.zzb, FirebaseAnalytics.Param.INDEX);
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

    public final zzp zzf(int i10, int i11) {
        zzf.zzc(i10, i11, this.zzb);
        zzp zzp = this.zzc;
        int i12 = this.zza;
        return zzp.subList(i10 + i12, i11 + i12);
    }
}
