package io.sentry.android.core;

import android.content.Context;
import io.sentry.SentryOptions;
import io.sentry.h0;
import io.sentry.n2;

public final /* synthetic */ class c1 implements n2.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h0 f30952a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f30953b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ n2.a f30954c;

    public /* synthetic */ c1(h0 h0Var, Context context, n2.a aVar) {
        this.f30952a = h0Var;
        this.f30953b = context;
        this.f30954c = aVar;
    }

    public final void a(SentryOptions sentryOptions) {
        d1.h(this.f30952a, this.f30953b, this.f30954c, (SentryAndroidOptions) sentryOptions);
    }
}
