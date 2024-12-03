package androidx.camera.core;

import java.util.concurrent.atomic.AtomicBoolean;

final class v2 extends h0 {

    /* renamed from: d  reason: collision with root package name */
    private final AtomicBoolean f2927d = new AtomicBoolean(false);

    v2(o1 o1Var) {
        super(o1Var);
    }

    public void close() {
        if (!this.f2927d.getAndSet(true)) {
            super.close();
        }
    }
}
