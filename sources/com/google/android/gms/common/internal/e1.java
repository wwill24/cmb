package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import androidx.annotation.NonNull;

public final class e1 extends t0 {

    /* renamed from: a  reason: collision with root package name */
    private d f38991a;

    /* renamed from: b  reason: collision with root package name */
    private final int f38992b;

    public e1(@NonNull d dVar, int i10) {
        this.f38991a = dVar;
        this.f38992b = i10;
    }

    public final void R(int i10, Bundle bundle) {
        Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
    }

    public final void e0(int i10, @NonNull IBinder iBinder, @NonNull zzj zzj) {
        d dVar = this.f38991a;
        p.l(dVar, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
        p.k(zzj);
        d.zzj(dVar, zzj);
        u(i10, iBinder, zzj.f39086a);
    }

    public final void u(int i10, @NonNull IBinder iBinder, Bundle bundle) {
        p.l(this.f38991a, "onPostInitComplete can be called only once per call to getRemoteService");
        this.f38991a.onPostInitHandler(i10, iBinder, bundle, this.f38992b);
        this.f38991a = null;
    }
}
