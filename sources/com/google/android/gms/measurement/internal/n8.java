package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.internal.measurement.zzcl;
import we.x;

public final class n8 {

    /* renamed from: a  reason: collision with root package name */
    private final Context f40064a;

    public n8(Context context) {
        p.k(context);
        this.f40064a = context;
    }

    private final q3 k() {
        return u4.H(this.f40064a, (zzcl) null, (Long) null).d();
    }

    public final int a(Intent intent, int i10, int i11) {
        u4 H = u4.H(this.f40064a, (zzcl) null, (Long) null);
        q3 d10 = H.d();
        if (intent == null) {
            d10.w().a("AppMeasurementService started with null intent");
            return 2;
        }
        String action = intent.getAction();
        H.b();
        d10.v().c("Local AppMeasurementService called. startId, action", Integer.valueOf(i11), action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            h(new l8(this, i11, d10, intent));
        }
        return 2;
    }

    public final IBinder b(Intent intent) {
        if (intent == null) {
            k().r().a("onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new m5(n9.f0(this.f40064a), (String) null);
        }
        k().w().b("onBind received unknown action", action);
        return null;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void c(int i10, q3 q3Var, Intent intent) {
        if (((x) this.f40064a).a(i10)) {
            q3Var.v().b("Local AppMeasurementService processed last upload request. StartId", Integer.valueOf(i10));
            k().v().a("Completed wakeful intent.");
            ((x) this.f40064a).b(intent);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void d(q3 q3Var, JobParameters jobParameters) {
        q3Var.v().a("AppMeasurementJobService processed last upload request.");
        ((x) this.f40064a).c(jobParameters, false);
    }

    public final void e() {
        u4 H = u4.H(this.f40064a, (zzcl) null, (Long) null);
        q3 d10 = H.d();
        H.b();
        d10.v().a("Local AppMeasurementService is starting up");
    }

    public final void f() {
        u4 H = u4.H(this.f40064a, (zzcl) null, (Long) null);
        q3 d10 = H.d();
        H.b();
        d10.v().a("Local AppMeasurementService is shutting down");
    }

    public final void g(Intent intent) {
        if (intent == null) {
            k().r().a("onRebind called with null intent");
            return;
        }
        k().v().b("onRebind called. action", intent.getAction());
    }

    public final void h(Runnable runnable) {
        n9 f02 = n9.f0(this.f40064a);
        f02.f().z(new m8(this, f02, runnable));
    }

    @TargetApi(24)
    public final boolean i(JobParameters jobParameters) {
        u4 H = u4.H(this.f40064a, (zzcl) null, (Long) null);
        q3 d10 = H.d();
        String string = jobParameters.getExtras().getString("action");
        H.b();
        d10.v().b("Local AppMeasurementJobService called. action", string);
        if (!"com.google.android.gms.measurement.UPLOAD".equals(string)) {
            return true;
        }
        h(new k8(this, d10, jobParameters));
        return true;
    }

    public final boolean j(Intent intent) {
        if (intent == null) {
            k().r().a("onUnbind called with null intent");
            return true;
        }
        k().v().b("onUnbind called for intent. action", intent.getAction());
        return true;
    }
}
