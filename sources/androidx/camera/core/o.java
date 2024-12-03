package androidx.camera.core;

import androidx.annotation.NonNull;
import androidx.camera.core.impl.w;
import androidx.core.util.h;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class o implements Executor {

    /* renamed from: c  reason: collision with root package name */
    private static final ThreadFactory f2828c = new a();

    /* renamed from: a  reason: collision with root package name */
    private final Object f2829a = new Object();
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private ThreadPoolExecutor f2830b = b();

    class a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        private final AtomicInteger f2831a = new AtomicInteger(0);

        a() {
        }

        public Thread newThread(@NonNull Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName(String.format(Locale.US, "CameraX-core_camera_%d", new Object[]{Integer.valueOf(this.f2831a.getAndIncrement())}));
            return thread;
        }
    }

    o() {
    }

    private static ThreadPoolExecutor b() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), f2828c);
        threadPoolExecutor.setRejectedExecutionHandler(new n());
        return threadPoolExecutor;
    }

    /* access modifiers changed from: package-private */
    public void c(@NonNull w wVar) {
        ThreadPoolExecutor threadPoolExecutor;
        h.g(wVar);
        synchronized (this.f2829a) {
            if (this.f2830b.isShutdown()) {
                this.f2830b = b();
            }
            threadPoolExecutor = this.f2830b;
        }
        int max = Math.max(1, wVar.b().size());
        threadPoolExecutor.setMaximumPoolSize(max);
        threadPoolExecutor.setCorePoolSize(max);
    }

    public void execute(@NonNull Runnable runnable) {
        h.g(runnable);
        synchronized (this.f2829a) {
            this.f2830b.execute(runnable);
        }
    }
}
