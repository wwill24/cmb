package io.sentry.android.core;

import io.sentry.n0;
import io.sentry.t4;
import java.lang.ref.WeakReference;

public final /* synthetic */ class m implements t4 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ActivityLifecycleIntegration f31063a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WeakReference f31064b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f31065c;

    public /* synthetic */ m(ActivityLifecycleIntegration activityLifecycleIntegration, WeakReference weakReference, String str) {
        this.f31063a = activityLifecycleIntegration;
        this.f31064b = weakReference;
        this.f31065c = str;
    }

    public final void a(n0 n0Var) {
        this.f31063a.t0(this.f31064b, this.f31065c, n0Var);
    }
}
