package io.sentry;

import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public final class r0 implements d0 {

    /* renamed from: a  reason: collision with root package name */
    private final Runtime f31608a = Runtime.getRuntime();

    public void a() {
    }

    public void b(x1 x1Var) {
        x1Var.b(new f1(System.currentTimeMillis(), this.f31608a.totalMemory() - this.f31608a.freeMemory()));
    }
}
