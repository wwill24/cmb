package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PersistableBundle;
import com.google.android.gms.internal.measurement.zzbs;
import com.google.android.gms.internal.measurement.zzbt;

public final class z8 extends b9 {

    /* renamed from: d  reason: collision with root package name */
    private final AlarmManager f40475d = ((AlarmManager) this.f40059a.c().getSystemService("alarm"));

    /* renamed from: e  reason: collision with root package name */
    private n f40476e;

    /* renamed from: f  reason: collision with root package name */
    private Integer f40477f;

    protected z8(n9 n9Var) {
        super(n9Var);
    }

    private final int o() {
        if (this.f40477f == null) {
            this.f40477f = Integer.valueOf("measurement".concat(String.valueOf(this.f40059a.c().getPackageName())).hashCode());
        }
        return this.f40477f.intValue();
    }

    private final PendingIntent p() {
        Context c10 = this.f40059a.c();
        return PendingIntent.getBroadcast(c10, 0, new Intent().setClassName(c10, "com.google.android.gms.measurement.AppMeasurementReceiver").setAction("com.google.android.gms.measurement.UPLOAD"), zzbs.zza);
    }

    private final n q() {
        if (this.f40476e == null) {
            this.f40476e = new y8(this, this.f39651b.b0());
        }
        return this.f40476e;
    }

    @TargetApi(24)
    private final void r() {
        JobScheduler jobScheduler = (JobScheduler) this.f40059a.c().getSystemService("jobscheduler");
        if (jobScheduler != null) {
            jobScheduler.cancel(o());
        }
    }

    /* access modifiers changed from: protected */
    public final boolean l() {
        AlarmManager alarmManager = this.f40475d;
        if (alarmManager != null) {
            alarmManager.cancel(p());
        }
        r();
        return false;
    }

    public final void m() {
        i();
        this.f40059a.d().v().a("Unscheduling upload");
        AlarmManager alarmManager = this.f40475d;
        if (alarmManager != null) {
            alarmManager.cancel(p());
        }
        q().b();
        r();
    }

    public final void n(long j10) {
        i();
        this.f40059a.b();
        Context c10 = this.f40059a.c();
        if (!t9.a0(c10)) {
            this.f40059a.d().q().a("Receiver not registered/enabled");
        }
        if (!t9.b0(c10, false)) {
            this.f40059a.d().q().a("Service not registered/enabled");
        }
        m();
        this.f40059a.d().v().b("Scheduling upload, millis", Long.valueOf(j10));
        this.f40059a.a().b();
        this.f40059a.z();
        if (j10 < Math.max(0, ((Long) g3.f39855z.a((Object) null)).longValue()) && !q().e()) {
            q().d(j10);
        }
        this.f40059a.b();
        Context c11 = this.f40059a.c();
        ComponentName componentName = new ComponentName(c11, "com.google.android.gms.measurement.AppMeasurementJobService");
        int o10 = o();
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString("action", "com.google.android.gms.measurement.UPLOAD");
        zzbt.zza(c11, new JobInfo.Builder(o10, componentName).setMinimumLatency(j10).setOverrideDeadline(j10 + j10).setExtras(persistableBundle).build(), "com.google.android.gms", "UploadAlarm");
    }
}
