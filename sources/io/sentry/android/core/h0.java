package io.sentry.android.core;

import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public final class h0 {

    /* renamed from: b  reason: collision with root package name */
    private static h0 f30987b = new h0();

    /* renamed from: a  reason: collision with root package name */
    private Boolean f30988a = null;

    private h0() {
    }

    public static h0 a() {
        return f30987b;
    }

    public Boolean b() {
        return this.f30988a;
    }

    /* access modifiers changed from: package-private */
    public synchronized void c(boolean z10) {
        this.f30988a = Boolean.valueOf(z10);
    }
}
