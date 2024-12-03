package io.sentry.android.core;

import io.sentry.g2;

public final /* synthetic */ class a1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ g2 f30912a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SentryAndroidOptions f30913b;

    public /* synthetic */ a1(g2 g2Var, SentryAndroidOptions sentryAndroidOptions) {
        this.f30912a = g2Var;
        this.f30913b = sentryAndroidOptions;
    }

    public final void run() {
        SendCachedEnvelopeIntegration.e(this.f30912a, this.f30913b);
    }
}
