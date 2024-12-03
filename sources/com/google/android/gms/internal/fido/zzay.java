package com.google.android.gms.internal.fido;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;

final class zzay extends zzaz {
    final transient int zza;
    final transient int zzb;
    final /* synthetic */ zzaz zzc;

    zzay(zzaz zzaz, int i10, int i11) {
        this.zzc = zzaz;
        this.zza = i10;
        this.zzb = i11;
    }

    public final Object get(int i10) {
        zzas.zza(i10, this.zzb, FirebaseAnalytics.Param.INDEX);
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

    public final zzaz zzf(int i10, int i11) {
        zzas.zze(i10, i11, this.zzb);
        zzaz zzaz = this.zzc;
        int i12 = this.zza;
        return zzaz.subList(i10 + i12, i11 + i12);
    }
}
