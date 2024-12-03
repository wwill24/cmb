package androidx.camera.core.impl.utils.executor;

import java.util.concurrent.Executor;

final class b implements Executor {

    /* renamed from: a  reason: collision with root package name */
    private static volatile b f2635a;

    b() {
    }

    static Executor a() {
        if (f2635a != null) {
            return f2635a;
        }
        synchronized (b.class) {
            if (f2635a == null) {
                f2635a = new b();
            }
        }
        return f2635a;
    }

    public void execute(Runnable runnable) {
        runnable.run();
    }
}
