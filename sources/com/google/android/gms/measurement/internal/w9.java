package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzci;
import we.s;

final class w9 implements s {

    /* renamed from: a  reason: collision with root package name */
    public final zzci f40396a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ AppMeasurementDynamiteService f40397b;

    w9(AppMeasurementDynamiteService appMeasurementDynamiteService, zzci zzci) {
        this.f40397b = appMeasurementDynamiteService;
        this.f40396a = zzci;
    }

    public final void a(String str, String str2, Bundle bundle, long j10) {
        try {
            this.f40396a.zze(str, str2, bundle, j10);
        } catch (RemoteException e10) {
            u4 u4Var = this.f40397b.f39623a;
            if (u4Var != null) {
                u4Var.d().w().b("Event interceptor threw exception", e10);
            }
        }
    }
}
