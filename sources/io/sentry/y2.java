package io.sentry;

import java.util.concurrent.Callable;

public final /* synthetic */ class y2 implements Callable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ l0 f31805a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Session f31806b;

    public /* synthetic */ y2(l0 l0Var, Session session) {
        this.f31805a = l0Var;
        this.f31806b = session;
    }

    public final Object call() {
        return n3.K(this.f31805a, this.f31806b);
    }
}
