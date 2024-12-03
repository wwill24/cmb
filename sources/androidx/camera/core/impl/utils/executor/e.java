package androidx.camera.core.impl.utils.executor;

import androidx.annotation.NonNull;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class e implements Executor {

    /* renamed from: b  reason: collision with root package name */
    private static volatile Executor f2651b;

    /* renamed from: a  reason: collision with root package name */
    private final ExecutorService f2652a = Executors.newFixedThreadPool(2, new a());

    class a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        private final AtomicInteger f2653a = new AtomicInteger(0);

        a() {
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName(String.format(Locale.US, "CameraX-camerax_io_%d", new Object[]{Integer.valueOf(this.f2653a.getAndIncrement())}));
            return thread;
        }
    }

    e() {
    }

    static Executor a() {
        if (f2651b != null) {
            return f2651b;
        }
        synchronized (e.class) {
            if (f2651b == null) {
                f2651b = new e();
            }
        }
        return f2651b;
    }

    public void execute(@NonNull Runnable runnable) {
        this.f2652a.execute(runnable);
    }
}
