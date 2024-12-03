package androidx.camera.core.impl.utils.executor;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ScheduledExecutorService;

final class f {

    /* renamed from: a  reason: collision with root package name */
    private static volatile ScheduledExecutorService f2655a;

    private f() {
    }

    static ScheduledExecutorService a() {
        if (f2655a != null) {
            return f2655a;
        }
        synchronized (f.class) {
            if (f2655a == null) {
                f2655a = new c(new Handler(Looper.getMainLooper()));
            }
        }
        return f2655a;
    }
}
