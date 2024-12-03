package siftscience.android;

import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class TaskManager {
    private static final String TAG = "siftscience.android.TaskManager";
    private final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

    TaskManager() {
    }

    /* access modifiers changed from: package-private */
    public void schedule(Runnable runnable, long j10, TimeUnit timeUnit) {
        try {
            this.executor.schedule(runnable, j10, timeUnit);
        } catch (RejectedExecutionException unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public void shutdown() {
        this.executor.shutdown();
        try {
            this.executor.awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public void submit(Runnable runnable) {
        try {
            this.executor.submit(runnable);
        } catch (RejectedExecutionException unused) {
        }
    }
}
