package com.google.android.gms.measurement.internal;

import android.os.Process;
import com.google.android.gms.common.internal.p;
import java.util.concurrent.BlockingQueue;

final class r4 extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private final Object f40217a;

    /* renamed from: b  reason: collision with root package name */
    private final BlockingQueue f40218b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f40219c = false;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ s4 f40220d;

    public r4(s4 s4Var, String str, BlockingQueue blockingQueue) {
        this.f40220d = s4Var;
        p.k(str);
        p.k(blockingQueue);
        this.f40217a = new Object();
        this.f40218b = blockingQueue;
        setName(str);
    }

    private final void b() {
        synchronized (this.f40220d.f40246i) {
            if (!this.f40219c) {
                this.f40220d.f40247j.release();
                this.f40220d.f40246i.notifyAll();
                s4 s4Var = this.f40220d;
                if (this == s4Var.f40240c) {
                    s4Var.f40240c = null;
                } else if (this == s4Var.f40241d) {
                    s4Var.f40241d = null;
                } else {
                    s4Var.f40059a.d().r().a("Current scheduler thread is neither worker nor network");
                }
                this.f40219c = true;
            }
        }
    }

    private final void c(InterruptedException interruptedException) {
        this.f40220d.f40059a.d().w().b(String.valueOf(getName()).concat(" was interrupted"), interruptedException);
    }

    public final void a() {
        synchronized (this.f40217a) {
            this.f40217a.notifyAll();
        }
    }

    public final void run() {
        int i10;
        boolean z10 = false;
        while (!z10) {
            try {
                this.f40220d.f40247j.acquire();
                z10 = true;
            } catch (InterruptedException e10) {
                c(e10);
            }
        }
        try {
            int threadPriority = Process.getThreadPriority(Process.myTid());
            while (true) {
                q4 q4Var = (q4) this.f40218b.poll();
                if (q4Var != null) {
                    if (true != q4Var.f40172b) {
                        i10 = 10;
                    } else {
                        i10 = threadPriority;
                    }
                    Process.setThreadPriority(i10);
                    q4Var.run();
                } else {
                    synchronized (this.f40217a) {
                        if (this.f40218b.peek() == null) {
                            boolean unused = this.f40220d.f40248k;
                            try {
                                this.f40217a.wait(30000);
                            } catch (InterruptedException e11) {
                                c(e11);
                            }
                        }
                    }
                    synchronized (this.f40220d.f40246i) {
                        if (this.f40218b.peek() == null) {
                            b();
                            b();
                            return;
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            b();
            throw th2;
        }
    }
}
