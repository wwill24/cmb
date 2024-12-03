package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzci;
import we.t;

final class x9 implements t {

    /* renamed from: a  reason: collision with root package name */
    public final zzci f40416a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ AppMeasurementDynamiteService f40417b;

    x9(AppMeasurementDynamiteService appMeasurementDynamiteService, zzci zzci) {
        this.f40417b = appMeasurementDynamiteService;
        this.f40416a = zzci;
    }

    public final void onEvent(String str, String str2, Bundle bundle, long j10) {
        try {
            this.f40416a.zze(str, str2, bundle, j10);
        } catch (RemoteException e10) {
            u4 u4Var = this.f40417b.f39623a;
            if (u4Var != null) {
                u4Var.d().w().b("Event listener threw exception", e10);
            }
        }
    }
}
