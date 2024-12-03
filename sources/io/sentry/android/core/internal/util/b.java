package io.sentry.android.core.internal.util;

import android.os.Looper;
import io.sentry.util.thread.a;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public final class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private static final b f31021a = new b();

    private b() {
    }

    public static b e() {
        return f31021a;
    }

    public boolean b(long j10) {
        return Looper.getMainLooper().getThread().getId() == j10;
    }
}
