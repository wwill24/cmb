package com.google.mlkit.common.sdkinternal;

import androidx.annotation.NonNull;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicReference;

public class n {

    /* renamed from: a  reason: collision with root package name */
    private final Object f21448a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private boolean f21449b;

    /* renamed from: c  reason: collision with root package name */
    private final Queue f21450c = new ArrayDeque();
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final AtomicReference f21451d = new AtomicReference();

    /* access modifiers changed from: private */
    public final void d() {
        synchronized (this.f21448a) {
            if (this.f21450c.isEmpty()) {
                this.f21449b = false;
                return;
            }
            g0 g0Var = (g0) this.f21450c.remove();
            e(g0Var.f21404a, g0Var.f21405b);
        }
    }

    private final void e(Executor executor, Runnable runnable) {
        try {
            executor.execute(new e0(this, runnable));
        } catch (RejectedExecutionException unused) {
            d();
        }
    }

    public void a(@NonNull Executor executor, @NonNull Runnable runnable) {
        synchronized (this.f21448a) {
            if (this.f21449b) {
                this.f21450c.add(new g0(executor, runnable, (f0) null));
                return;
            }
            this.f21449b = true;
            e(executor, runnable);
        }
    }
}
