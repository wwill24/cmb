package com.google.android.gms.internal.p003firebaseauthapi;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzal  reason: invalid package */
final class zzal extends zzam {
    final transient int zza;
    final transient int zzb;
    final /* synthetic */ zzam zzc;

    zzal(zzam zzam, int i10, int i11) {
        this.zzc = zzam;
        this.zza = i10;
        this.zzb = i11;
    }

    public final Object get(int i10) {
        zzu.zza(i10, this.zzb, FirebaseAnalytics.Param.INDEX);
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

    public final zzam zzf(int i10, int i11) {
        zzu.zzc(i10, i11, this.zzb);
        int i12 = this.zza;
        return this.zzc.subList(i10 + i12, i11 + i12);
    }
}
