package io.sentry.util.thread;

import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public final class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private static final long f31727a = Thread.currentThread().getId();

    /* renamed from: b  reason: collision with root package name */
    private static final b f31728b = new b();

    private b() {
    }

    public static b e() {
        return f31728b;
    }

    public boolean b(long j10) {
        return f31727a == j10;
    }
}
