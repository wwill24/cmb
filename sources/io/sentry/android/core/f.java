package io.sentry.android.core;

import android.app.Activity;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ g f30967a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Activity f30968b;

    public /* synthetic */ f(g gVar, Activity activity) {
        this.f30967a = gVar;
        this.f30968b = activity;
    }

    public final void run() {
        this.f30967a.k(this.f30968b);
    }
}
