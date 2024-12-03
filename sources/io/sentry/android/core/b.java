package io.sentry.android.core;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Debug;
import io.sentry.SentryLevel;
import io.sentry.h0;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

final class b extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f30914a;

    /* renamed from: b  reason: collision with root package name */
    private final a f30915b;

    /* renamed from: c  reason: collision with root package name */
    private final u0 f30916c;

    /* renamed from: d  reason: collision with root package name */
    private final long f30917d;

    /* renamed from: e  reason: collision with root package name */
    private final h0 f30918e;

    /* renamed from: f  reason: collision with root package name */
    private final AtomicLong f30919f;

    /* renamed from: g  reason: collision with root package name */
    private final AtomicBoolean f30920g;

    /* renamed from: h  reason: collision with root package name */
    private final Context f30921h;

    /* renamed from: j  reason: collision with root package name */
    private final Runnable f30922j;

    public interface a {
        void a(ApplicationNotResponding applicationNotResponding);
    }

    b(long j10, boolean z10, a aVar, h0 h0Var, Context context) {
        this(j10, z10, aVar, h0Var, new u0(), context);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b() {
        this.f30919f.set(0);
        this.f30920g.set(false);
    }

    public void run() {
        boolean z10;
        boolean z11;
        setName("|ANR-WatchDog|");
        long j10 = this.f30917d;
        while (!isInterrupted()) {
            if (this.f30919f.get() == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            this.f30919f.addAndGet(j10);
            if (z10) {
                this.f30916c.b(this.f30922j);
            }
            try {
                Thread.sleep(j10);
                if (this.f30919f.get() != 0 && !this.f30920g.get()) {
                    if (this.f30914a || (!Debug.isDebuggerConnected() && !Debug.waitingForDebugger())) {
                        ActivityManager activityManager = (ActivityManager) this.f30921h.getSystemService("activity");
                        if (activityManager != null) {
                            List<ActivityManager.ProcessErrorStateInfo> list = null;
                            try {
                                list = activityManager.getProcessesInErrorState();
                            } catch (Throwable th2) {
                                this.f30918e.b(SentryLevel.ERROR, "Error getting ActivityManager#getProcessesInErrorState.", th2);
                            }
                            if (list != null) {
                                Iterator<ActivityManager.ProcessErrorStateInfo> it = list.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        if (it.next().condition == 2) {
                                            z11 = true;
                                            break;
                                        }
                                    } else {
                                        z11 = false;
                                        break;
                                    }
                                }
                                if (!z11) {
                                }
                            }
                        }
                        this.f30918e.c(SentryLevel.INFO, "Raising ANR", new Object[0]);
                        this.f30915b.a(new ApplicationNotResponding("Application Not Responding for at least " + this.f30917d + " ms.", this.f30916c.a()));
                        j10 = this.f30917d;
                        this.f30920g.set(true);
                    } else {
                        this.f30918e.c(SentryLevel.DEBUG, "An ANR was detected but ignored because the debugger is connected.", new Object[0]);
                        this.f30920g.set(true);
                    }
                }
            } catch (InterruptedException e10) {
                try {
                    Thread.currentThread().interrupt();
                    this.f30918e.c(SentryLevel.WARNING, "Interrupted: %s", e10.getMessage());
                    return;
                } catch (SecurityException unused) {
                    this.f30918e.c(SentryLevel.WARNING, "Failed to interrupt due to SecurityException: %s", e10.getMessage());
                    return;
                }
            }
        }
    }

    b(long j10, boolean z10, a aVar, h0 h0Var, u0 u0Var, Context context) {
        this.f30919f = new AtomicLong(0);
        this.f30920g = new AtomicBoolean(false);
        this.f30922j = new a(this);
        this.f30914a = z10;
        this.f30915b = aVar;
        this.f30917d = j10;
        this.f30918e = h0Var;
        this.f30916c = u0Var;
        this.f30921h = context;
    }
}
