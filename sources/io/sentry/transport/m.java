package io.sentry.transport;

import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public final class m implements o {

    /* renamed from: a  reason: collision with root package name */
    private static final o f31664a = new m();

    private m() {
    }

    public static o a() {
        return f31664a;
    }

    public final long getCurrentTimeMillis() {
        return System.currentTimeMillis();
    }
}
