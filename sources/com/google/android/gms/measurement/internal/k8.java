package com.google.android.gms.measurement.internal;

import android.app.job.JobParameters;

public final /* synthetic */ class k8 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ n8 f39995a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ q3 f39996b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ JobParameters f39997c;

    public /* synthetic */ k8(n8 n8Var, q3 q3Var, JobParameters jobParameters) {
        this.f39995a = n8Var;
        this.f39996b = q3Var;
        this.f39997c = jobParameters;
    }

    public final void run() {
        this.f39995a.d(this.f39996b, this.f39997c);
    }
}
