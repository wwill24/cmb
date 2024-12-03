package io.sentry.android.core;

import io.sentry.android.core.b;
import io.sentry.g0;

public final /* synthetic */ class d0 implements b.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnrIntegration f30957a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ g0 f30958b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SentryAndroidOptions f30959c;

    public /* synthetic */ d0(AnrIntegration anrIntegration, g0 g0Var, SentryAndroidOptions sentryAndroidOptions) {
        this.f30957a = anrIntegration;
        this.f30958b = g0Var;
        this.f30959c = sentryAndroidOptions;
    }

    public final void a(ApplicationNotResponding applicationNotResponding) {
        this.f30957a.g(this.f30958b, this.f30959c, applicationNotResponding);
    }
}
