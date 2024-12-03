package io.sentry.android.core;

import android.app.Activity;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ g f30947a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Activity f30948b;

    public /* synthetic */ c(g gVar, Activity activity) {
        this.f30947a = gVar;
        this.f30948b = activity;
    }

    public final void run() {
        this.f30947a.i(this.f30948b);
    }
}
