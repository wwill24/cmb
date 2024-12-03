package com.google.android.gms.measurement;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.measurement.internal.u4;
import com.google.android.gms.measurement.internal.u6;
import java.util.List;
import java.util.Map;

final class a extends d {

    /* renamed from: a  reason: collision with root package name */
    private final u4 f39620a;

    /* renamed from: b  reason: collision with root package name */
    private final u6 f39621b;

    public a(@NonNull u4 u4Var) {
        super((c) null);
        p.k(u4Var);
        this.f39620a = u4Var;
        this.f39621b = u4Var.I();
    }

    public final int zza(String str) {
        this.f39621b.Q(str);
        return 25;
    }

    public final long zzb() {
        return this.f39620a.N().t0();
    }

    public final String zzh() {
        return this.f39621b.V();
    }

    public final String zzi() {
        return this.f39621b.W();
    }

    public final String zzj() {
        return this.f39621b.X();
    }

    public final String zzk() {
        return this.f39621b.V();
    }

    public final List zzm(String str, String str2) {
        return this.f39621b.Z(str, str2);
    }

    public final Map zzo(String str, String str2, boolean z10) {
        return this.f39621b.a0(str, str2, z10);
    }

    public final void zzp(String str) {
        this.f39620a.y().l(str, this.f39620a.a().b());
    }

    public final void zzq(String str, String str2, Bundle bundle) {
        this.f39620a.I().o(str, str2, bundle);
    }

    public final void zzr(String str) {
        this.f39620a.y().m(str, this.f39620a.a().b());
    }

    public final void zzs(String str, String str2, Bundle bundle) {
        this.f39621b.r(str, str2, bundle);
    }

    public final void zzv(Bundle bundle) {
        this.f39621b.D(bundle);
    }
}
