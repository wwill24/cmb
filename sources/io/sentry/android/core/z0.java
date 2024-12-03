package io.sentry.android.core;

import android.app.Activity;
import io.sentry.SentryLevel;
import io.sentry.android.core.internal.util.k;
import io.sentry.b;
import io.sentry.p3;
import io.sentry.t;
import io.sentry.util.i;
import io.sentry.util.l;
import io.sentry.w;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public final class z0 implements t {

    /* renamed from: a  reason: collision with root package name */
    private final SentryAndroidOptions f31119a;

    /* renamed from: b  reason: collision with root package name */
    private final i0 f31120b;

    public z0(SentryAndroidOptions sentryAndroidOptions, i0 i0Var) {
        this.f31119a = (SentryAndroidOptions) l.c(sentryAndroidOptions, "SentryAndroidOptions is required");
        this.f31120b = (i0) l.c(i0Var, "BuildInfoProvider is required");
    }

    public p3 a(p3 p3Var, w wVar) {
        byte[] b10;
        if (!p3Var.u0()) {
            return p3Var;
        }
        if (!this.f31119a.isAttachScreenshot()) {
            this.f31119a.getLogger().c(SentryLevel.DEBUG, "attachScreenshot is disabled.", new Object[0]);
            return p3Var;
        }
        Activity b11 = k0.c().b();
        if (b11 == null || i.h(wVar) || (b10 = k.b(b11, this.f31119a.getLogger(), this.f31120b)) == null) {
            return p3Var;
        }
        wVar.j(b.a(b10));
        wVar.i("android:activity", b11);
        return p3Var;
    }
}
