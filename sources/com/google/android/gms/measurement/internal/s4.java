package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.p;
import java.lang.Thread;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;

public final class s4 extends o5 {
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public static final AtomicLong f40239l = new AtomicLong(Long.MIN_VALUE);
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public r4 f40240c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public r4 f40241d;

    /* renamed from: e  reason: collision with root package name */
    private final PriorityBlockingQueue f40242e = new PriorityBlockingQueue();

    /* renamed from: f  reason: collision with root package name */
    private final BlockingQueue f40243f = new LinkedBlockingQueue();

    /* renamed from: g  reason: collision with root package name */
    private final Thread.UncaughtExceptionHandler f40244g = new p4(this, "Thread death: Uncaught exception on worker thread");

    /* renamed from: h  reason: collision with root package name */
    private final Thread.UncaughtExceptionHandler f40245h = new p4(this, "Thread death: Uncaught exception on network thread");
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final Object f40246i = new Object();
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public final Semaphore f40247j = new Semaphore(2);
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public volatile boolean f40248k;

    s4(u4 u4Var) {
        super(u4Var);
    }

    private final void D(q4 q4Var) {
        synchronized (this.f40246i) {
            this.f40242e.add(q4Var);
            r4 r4Var = this.f40240c;
            if (r4Var == null) {
                r4 r4Var2 = new r4(this, "Measurement Worker", this.f40242e);
                this.f40240c = r4Var2;
                r4Var2.setUncaughtExceptionHandler(this.f40244g);
                this.f40240c.start();
            } else {
                r4Var.a();
            }
        }
    }

    public final void A(Runnable runnable) throws IllegalStateException {
        k();
        p.k(runnable);
        D(new q4(this, runnable, true, "Task exception on worker thread"));
    }

    public final boolean C() {
        return Thread.currentThread() == this.f40240c;
    }

    public final void g() {
        if (Thread.currentThread() != this.f40241d) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    public final void h() {
        if (Thread.currentThread() != this.f40240c) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    /* access modifiers changed from: protected */
    public final boolean j() {
        return false;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:11|12|13|14) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0027, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r3 = r1.f40059a.d().w();
        r3.a("Interrupted waiting for " + r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0047, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000e, code lost:
        r2 = r2.get();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0012, code lost:
        if (r2 != null) goto L_0x0027;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0014, code lost:
        r1.f40059a.d().w().a("Timed out waiting for ".concat(r5));
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0028 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object r(java.util.concurrent.atomic.AtomicReference r2, long r3, java.lang.String r5, java.lang.Runnable r6) {
        /*
            r1 = this;
            monitor-enter(r2)
            com.google.android.gms.measurement.internal.u4 r0 = r1.f40059a     // Catch:{ all -> 0x0049 }
            com.google.android.gms.measurement.internal.s4 r0 = r0.f()     // Catch:{ all -> 0x0049 }
            r0.z(r6)     // Catch:{ all -> 0x0049 }
            r2.wait(r3)     // Catch:{ InterruptedException -> 0x0028 }
            monitor-exit(r2)     // Catch:{ all -> 0x0049 }
            java.lang.Object r2 = r2.get()
            if (r2 != 0) goto L_0x0027
            com.google.android.gms.measurement.internal.u4 r3 = r1.f40059a
            com.google.android.gms.measurement.internal.q3 r3 = r3.d()
            com.google.android.gms.measurement.internal.o3 r3 = r3.w()
            java.lang.String r4 = "Timed out waiting for "
            java.lang.String r4 = r4.concat(r5)
            r3.a(r4)
        L_0x0027:
            return r2
        L_0x0028:
            com.google.android.gms.measurement.internal.u4 r3 = r1.f40059a     // Catch:{ all -> 0x0049 }
            com.google.android.gms.measurement.internal.q3 r3 = r3.d()     // Catch:{ all -> 0x0049 }
            com.google.android.gms.measurement.internal.o3 r3 = r3.w()     // Catch:{ all -> 0x0049 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0049 }
            r4.<init>()     // Catch:{ all -> 0x0049 }
            java.lang.String r6 = "Interrupted waiting for "
            r4.append(r6)     // Catch:{ all -> 0x0049 }
            r4.append(r5)     // Catch:{ all -> 0x0049 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0049 }
            r3.a(r4)     // Catch:{ all -> 0x0049 }
            monitor-exit(r2)     // Catch:{ all -> 0x0049 }
            r2 = 0
            return r2
        L_0x0049:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0049 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.s4.r(java.util.concurrent.atomic.AtomicReference, long, java.lang.String, java.lang.Runnable):java.lang.Object");
    }

    public final Future s(Callable callable) throws IllegalStateException {
        k();
        p.k(callable);
        q4 q4Var = new q4(this, callable, false, "Task exception on worker thread");
        if (Thread.currentThread() == this.f40240c) {
            if (!this.f40242e.isEmpty()) {
                this.f40059a.d().w().a("Callable skipped the worker queue.");
            }
            q4Var.run();
        } else {
            D(q4Var);
        }
        return q4Var;
    }

    public final Future t(Callable callable) throws IllegalStateException {
        k();
        p.k(callable);
        q4 q4Var = new q4(this, callable, true, "Task exception on worker thread");
        if (Thread.currentThread() == this.f40240c) {
            q4Var.run();
        } else {
            D(q4Var);
        }
        return q4Var;
    }

    public final void y(Runnable runnable) throws IllegalStateException {
        k();
        p.k(runnable);
        q4 q4Var = new q4(this, runnable, false, "Task exception on network thread");
        synchronized (this.f40246i) {
            this.f40243f.add(q4Var);
            r4 r4Var = this.f40241d;
            if (r4Var == null) {
                r4 r4Var2 = new r4(this, "Measurement Network", this.f40243f);
                this.f40241d = r4Var2;
                r4Var2.setUncaughtExceptionHandler(this.f40245h);
                this.f40241d.start();
            } else {
                r4Var.a();
            }
        }
    }

    public final void z(Runnable runnable) throws IllegalStateException {
        k();
        p.k(runnable);
        D(new q4(this, runnable, false, "Task exception on worker thread"));
    }
}
