package com.google.mlkit.common.sdkinternal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.internal.mlkit_common.zzbh;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class j extends zzbh {

    /* renamed from: b  reason: collision with root package name */
    private static final ThreadLocal f21410b = new ThreadLocal();

    /* renamed from: a  reason: collision with root package name */
    private final ThreadPoolExecutor f21411a;

    public j() {
        ThreadFactory defaultThreadFactory = Executors.defaultThreadFactory();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(availableProcessors, availableProcessors, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new u(defaultThreadFactory));
        this.f21411a = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    static /* synthetic */ void b(Runnable runnable) {
        f21410b.set(new ArrayDeque());
        runnable.run();
    }

    /* access modifiers changed from: private */
    public static void c(Deque deque, Runnable runnable) {
        p.k(deque);
        deque.add(runnable);
        if (deque.size() <= 1) {
            do {
                runnable.run();
                deque.removeFirst();
                runnable = (Runnable) deque.peekFirst();
            } while (runnable != null);
        }
    }

    public final void execute(@NonNull Runnable runnable) {
        Deque deque = (Deque) f21410b.get();
        if (deque == null || deque.size() > 1) {
            this.f21411a.execute(new v(runnable));
        } else {
            c(deque, runnable);
        }
    }

    /* access modifiers changed from: protected */
    @NonNull
    public final /* synthetic */ Object zza() {
        return this.f21411a;
    }

    /* access modifiers changed from: protected */
    @NonNull
    public final ExecutorService zzb() {
        return this.f21411a;
    }
}
