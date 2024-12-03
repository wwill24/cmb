package com.google.firebase.crashlytics.internal.send;

import cd.g;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId;

public final /* synthetic */ class b implements g {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ReportQueue f21026a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f21027b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f21028c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ CrashlyticsReportWithSessionId f21029d;

    public /* synthetic */ b(ReportQueue reportQueue, TaskCompletionSource taskCompletionSource, boolean z10, CrashlyticsReportWithSessionId crashlyticsReportWithSessionId) {
        this.f21026a = reportQueue;
        this.f21027b = taskCompletionSource;
        this.f21028c = z10;
        this.f21029d = crashlyticsReportWithSessionId;
    }

    public final void a(Exception exc) {
        this.f21026a.lambda$sendReport$1(this.f21027b, this.f21028c, this.f21029d, exc);
    }
}
