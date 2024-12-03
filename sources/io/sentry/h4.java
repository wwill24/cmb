package io.sentry;

public final /* synthetic */ class h4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ g0 f31261a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SentryOptions f31262b;

    public /* synthetic */ h4(g0 g0Var, SentryOptions sentryOptions) {
        this.f31261a = g0Var;
        this.f31262b = sentryOptions;
    }

    public final void run() {
        this.f31261a.o(this.f31262b.getFlushTimeoutMillis());
    }
}
