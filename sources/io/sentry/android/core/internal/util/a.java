package io.sentry.android.core.internal.util;

import android.os.SystemClock;
import io.sentry.transport.o;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public final class a implements o {

    /* renamed from: a  reason: collision with root package name */
    private static final o f31020a = new a();

    private a() {
    }

    public static o a() {
        return f31020a;
    }

    public long getCurrentTimeMillis() {
        return SystemClock.uptimeMillis();
    }
}
