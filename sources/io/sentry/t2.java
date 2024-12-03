package io.sentry;

import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public final class t2 {

    /* renamed from: d  reason: collision with root package name */
    private static final t2 f31635d = new t2();

    /* renamed from: a  reason: collision with root package name */
    private boolean f31636a;

    /* renamed from: b  reason: collision with root package name */
    private Boolean f31637b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f31638c = new Object();

    private t2() {
    }

    public static t2 a() {
        return f31635d;
    }

    public void b(boolean z10) {
        synchronized (this.f31638c) {
            if (!this.f31636a) {
                this.f31637b = Boolean.valueOf(z10);
                this.f31636a = true;
            }
        }
    }
}
