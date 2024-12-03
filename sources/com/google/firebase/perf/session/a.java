package com.google.firebase.perf.session;

import android.content.Context;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SessionManager f21153a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f21154b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ PerfSession f21155c;

    public /* synthetic */ a(SessionManager sessionManager, Context context, PerfSession perfSession) {
        this.f21153a = sessionManager;
        this.f21154b = context;
        this.f21155c = perfSession;
    }

    public final void run() {
        this.f21153a.lambda$setApplicationContext$0(this.f21154b, this.f21155c);
    }
}
