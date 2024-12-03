package androidx.camera.core.impl.utils.executor;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

final class d implements Executor {

    /* renamed from: b  reason: collision with root package name */
    private static volatile Executor f2648b;

    /* renamed from: a  reason: collision with root package name */
    private final ExecutorService f2649a = Executors.newSingleThreadExecutor(new a());

    class a implements ThreadFactory {
        a() {
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setPriority(10);
            thread.setName("CameraX-camerax_high_priority");
            return thread;
        }
    }

    d() {
    }

    static Executor a() {
        if (f2648b != null) {
            return f2648b;
        }
        synchronized (d.class) {
            if (f2648b == null) {
                f2648b = new d();
            }
        }
        return f2648b;
    }

    public void execute(@NonNull Runnable runnable) {
        this.f2649a.execute(runnable);
    }
}
