package io.sentry;

import io.sentry.util.n;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public final class o2 implements v2 {

    /* renamed from: a  reason: collision with root package name */
    private final v2 f31363a;

    public o2() {
        if (b()) {
            this.f31363a = new t3();
        } else {
            this.f31363a = new x3();
        }
    }

    private static boolean b() {
        return n.b() && n.a();
    }

    public u2 a() {
        return this.f31363a.a();
    }
}
