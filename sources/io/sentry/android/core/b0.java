package io.sentry.android.core;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Debug;
import android.os.Process;
import android.os.SystemClock;
import io.sentry.SentryLevel;
import io.sentry.a2;
import io.sentry.android.core.internal.util.p;
import io.sentry.c0;
import io.sentry.e;
import io.sentry.f1;
import io.sentry.g0;
import io.sentry.n0;
import io.sentry.o0;
import io.sentry.profilemeasurements.b;
import io.sentry.util.l;
import io.sentry.x1;
import io.sentry.z1;
import java.io.File;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

final class b0 implements o0 {

    /* renamed from: a  reason: collision with root package name */
    private int f30923a;

    /* renamed from: b  reason: collision with root package name */
    private File f30924b;

    /* renamed from: c  reason: collision with root package name */
    private File f30925c;

    /* renamed from: d  reason: collision with root package name */
    private Future<?> f30926d;

    /* renamed from: e  reason: collision with root package name */
    private volatile z1 f30927e;

    /* renamed from: f  reason: collision with root package name */
    private final Context f30928f;

    /* renamed from: g  reason: collision with root package name */
    private final SentryAndroidOptions f30929g;

    /* renamed from: h  reason: collision with root package name */
    private final g0 f30930h;

    /* renamed from: i  reason: collision with root package name */
    private final i0 f30931i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public long f30932j;

    /* renamed from: k  reason: collision with root package name */
    private long f30933k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f30934l;

    /* renamed from: m  reason: collision with root package name */
    private int f30935m;

    /* renamed from: n  reason: collision with root package name */
    private String f30936n;

    /* renamed from: o  reason: collision with root package name */
    private final p f30937o;

    /* renamed from: p  reason: collision with root package name */
    private a2 f30938p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public final ArrayDeque<b> f30939q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public final ArrayDeque<b> f30940r;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public final ArrayDeque<b> f30941s;

    /* renamed from: t  reason: collision with root package name */
    private final Map<String, io.sentry.profilemeasurements.a> f30942t;

    class a implements p.b {

        /* renamed from: a  reason: collision with root package name */
        final long f30943a = TimeUnit.SECONDS.toNanos(1);

        /* renamed from: b  reason: collision with root package name */
        final long f30944b = TimeUnit.MILLISECONDS.toNanos(700);

        /* renamed from: c  reason: collision with root package name */
        float f30945c = 0.0f;

        a() {
        }

        public void a(long j10, long j11, float f10) {
            boolean z10;
            long nanoTime = ((j10 - System.nanoTime()) + SystemClock.elapsedRealtimeNanos()) - b0.this.f30932j;
            if (nanoTime >= 0) {
                if (((float) j11) > ((float) this.f30943a) / (f10 - 1.0f)) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                float f11 = ((float) ((int) (f10 * 100.0f))) / 100.0f;
                if (j11 > this.f30944b) {
                    b0.this.f30941s.addLast(new b(Long.valueOf(nanoTime), Long.valueOf(j11)));
                } else if (z10) {
                    b0.this.f30940r.addLast(new b(Long.valueOf(nanoTime), Long.valueOf(j11)));
                }
                if (f11 != this.f30945c) {
                    this.f30945c = f11;
                    b0.this.f30939q.addLast(new b(Long.valueOf(nanoTime), Float.valueOf(f11)));
                }
            }
        }
    }

    public b0(Context context, SentryAndroidOptions sentryAndroidOptions, i0 i0Var, p pVar) {
        this(context, sentryAndroidOptions, i0Var, pVar, c0.b());
    }

    private ActivityManager.MemoryInfo k() {
        try {
            ActivityManager activityManager = (ActivityManager) this.f30928f.getSystemService("activity");
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            if (activityManager != null) {
                activityManager.getMemoryInfo(memoryInfo);
                return memoryInfo;
            }
            this.f30929g.getLogger().c(SentryLevel.INFO, "Error getting MemoryInfo.", new Object[0]);
            return null;
        } catch (Throwable th2) {
            this.f30929g.getLogger().b(SentryLevel.ERROR, "Error getting MemoryInfo.", th2);
            return null;
        }
    }

    private void l() {
        if (!this.f30934l) {
            this.f30934l = true;
            String profilingTracesDirPath = this.f30929g.getProfilingTracesDirPath();
            if (!this.f30929g.isProfilingEnabled()) {
                this.f30929g.getLogger().c(SentryLevel.INFO, "Profiling is disabled in options.", new Object[0]);
            } else if (profilingTracesDirPath == null) {
                this.f30929g.getLogger().c(SentryLevel.WARNING, "Disabling profiling because no profiling traces dir path is defined in options.", new Object[0]);
            } else {
                int profilingTracesHz = this.f30929g.getProfilingTracesHz();
                if (profilingTracesHz <= 0) {
                    this.f30929g.getLogger().c(SentryLevel.WARNING, "Disabling profiling because trace rate is set to %d", Integer.valueOf(profilingTracesHz));
                    return;
                }
                this.f30923a = ((int) TimeUnit.SECONDS.toMicros(1)) / profilingTracesHz;
                this.f30925c = new File(profilingTracesDirPath);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void m(n0 n0Var) {
        this.f30927e = r(n0Var, true, (List<x1>) null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ z1 n(n0 n0Var, List list) throws Exception {
        return r(n0Var, false, list);
    }

    @SuppressLint({"NewApi"})
    private void q(n0 n0Var) {
        File file = this.f30925c;
        this.f30924b = new File(file, UUID.randomUUID() + ".trace");
        this.f30942t.clear();
        this.f30939q.clear();
        this.f30940r.clear();
        this.f30941s.clear();
        this.f30936n = this.f30937o.j(new a());
        this.f30926d = this.f30929g.getExecutorService().schedule(new z(this, n0Var), 30000);
        this.f30932j = SystemClock.elapsedRealtimeNanos();
        this.f30933k = Process.getElapsedCpuTime();
        this.f30938p = new a2(n0Var, Long.valueOf(this.f30932j), Long.valueOf(this.f30933k));
        Debug.startMethodTracingSampling(this.f30924b.getPath(), 3000000, this.f30923a);
    }

    @SuppressLint({"NewApi"})
    private z1 r(n0 n0Var, boolean z10, List<x1> list) {
        String str;
        String str2;
        String str3;
        if (this.f30931i.d() < 21) {
            return null;
        }
        z1 z1Var = this.f30927e;
        a2 a2Var = this.f30938p;
        if (a2Var != null && a2Var.h().equals(n0Var.d().toString())) {
            int i10 = this.f30935m;
            if (i10 > 0) {
                this.f30935m = i10 - 1;
            }
            this.f30929g.getLogger().c(SentryLevel.DEBUG, "Transaction %s (%s) finished.", n0Var.getName(), n0Var.m().j().toString());
            if (this.f30935m == 0 || z10) {
                Debug.stopMethodTracing();
                this.f30937o.k(this.f30936n);
                long elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
                long elapsedCpuTime = Process.getElapsedCpuTime();
                long j10 = elapsedRealtimeNanos - this.f30932j;
                ArrayList<a2> arrayList = new ArrayList<>(1);
                arrayList.add(this.f30938p);
                this.f30938p = null;
                this.f30935m = 0;
                Future<?> future = this.f30926d;
                if (future != null) {
                    future.cancel(true);
                    this.f30926d = null;
                }
                if (this.f30924b == null) {
                    this.f30929g.getLogger().c(SentryLevel.ERROR, "Trace file does not exists", new Object[0]);
                    return null;
                }
                ActivityManager.MemoryInfo k10 = k();
                if (k10 != null) {
                    str = Long.toString(k10.totalMem);
                } else {
                    str = "0";
                }
                String str4 = str;
                String[] strArr = Build.SUPPORTED_ABIS;
                for (a2 i11 : arrayList) {
                    i11.i(Long.valueOf(elapsedRealtimeNanos), Long.valueOf(this.f30932j), Long.valueOf(elapsedCpuTime), Long.valueOf(this.f30933k));
                    elapsedCpuTime = elapsedCpuTime;
                }
                if (!this.f30940r.isEmpty()) {
                    this.f30942t.put("slow_frame_renders", new io.sentry.profilemeasurements.a("nanosecond", this.f30940r));
                }
                if (!this.f30941s.isEmpty()) {
                    this.f30942t.put("frozen_frame_renders", new io.sentry.profilemeasurements.a("nanosecond", this.f30941s));
                }
                if (!this.f30939q.isEmpty()) {
                    this.f30942t.put("screen_frame_rates", new io.sentry.profilemeasurements.a("hz", this.f30939q));
                }
                t(list);
                File file = this.f30924b;
                String l10 = Long.toString(j10);
                int d10 = this.f30931i.d();
                if (strArr == null || strArr.length <= 0) {
                    str2 = "";
                } else {
                    str2 = strArr[0];
                }
                String str5 = str2;
                a0 a0Var = new a0();
                String b10 = this.f30931i.b();
                String c10 = this.f30931i.c();
                String e10 = this.f30931i.e();
                Boolean f10 = this.f30931i.f();
                String proguardUuid = this.f30929g.getProguardUuid();
                String release = this.f30929g.getRelease();
                String environment = this.f30929g.getEnvironment();
                if (z10) {
                    str3 = "timeout";
                } else {
                    str3 = "normal";
                }
                return new z1(file, arrayList, n0Var, l10, d10, str5, a0Var, b10, c10, e10, f10, str4, proguardUuid, release, environment, str3, this.f30942t);
            }
            a2 a2Var2 = this.f30938p;
            if (a2Var2 != null) {
                a2Var2.i(Long.valueOf(SystemClock.elapsedRealtimeNanos()), Long.valueOf(this.f30932j), Long.valueOf(Process.getElapsedCpuTime()), Long.valueOf(this.f30933k));
            }
            return null;
        } else if (z1Var == null) {
            this.f30929g.getLogger().c(SentryLevel.INFO, "Transaction %s (%s) finished, but was not currently being profiled. Skipping", n0Var.getName(), n0Var.m().j().toString());
            return null;
        } else if (z1Var.C().equals(n0Var.d().toString())) {
            this.f30927e = null;
            return z1Var;
        } else {
            this.f30929g.getLogger().c(SentryLevel.INFO, "A timed out profiling data exists, but the finishing transaction %s (%s) is not part of it", n0Var.getName(), n0Var.m().j().toString());
            return null;
        }
    }

    /* access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    /* renamed from: s */
    public void p(n0 n0Var) {
        if (this.f30931i.d() >= 21) {
            l();
            File file = this.f30925c;
            if (file != null && this.f30923a != 0 && file.canWrite()) {
                int i10 = this.f30935m + 1;
                this.f30935m = i10;
                if (i10 == 1) {
                    q(n0Var);
                    this.f30929g.getLogger().c(SentryLevel.DEBUG, "Transaction %s (%s) started and being profiled.", n0Var.getName(), n0Var.m().j().toString());
                    return;
                }
                this.f30935m = i10 - 1;
                this.f30929g.getLogger().c(SentryLevel.WARNING, "A transaction is already being profiled. Transaction %s (%s) will be ignored.", n0Var.getName(), n0Var.m().j().toString());
            }
        }
    }

    private void t(List<x1> list) {
        if (list != null) {
            ArrayDeque arrayDeque = new ArrayDeque(list.size());
            ArrayDeque arrayDeque2 = new ArrayDeque(list.size());
            ArrayDeque arrayDeque3 = new ArrayDeque(list.size());
            for (x1 next : list) {
                e c10 = next.c();
                f1 d10 = next.d();
                if (c10 != null) {
                    arrayDeque3.add(new b(Long.valueOf(TimeUnit.MILLISECONDS.toNanos(c10.b()) - this.f30932j), Double.valueOf(c10.a())));
                }
                if (d10 != null && d10.b() > -1) {
                    arrayDeque.add(new b(Long.valueOf(TimeUnit.MILLISECONDS.toNanos(d10.a()) - this.f30932j), Long.valueOf(d10.b())));
                }
                if (d10 != null && d10.c() > -1) {
                    arrayDeque2.add(new b(Long.valueOf(TimeUnit.MILLISECONDS.toNanos(d10.a()) - this.f30932j), Long.valueOf(d10.c())));
                }
            }
            if (!arrayDeque3.isEmpty()) {
                this.f30942t.put("cpu_usage", new io.sentry.profilemeasurements.a("percent", arrayDeque3));
            }
            if (!arrayDeque.isEmpty()) {
                this.f30942t.put("memory_footprint", new io.sentry.profilemeasurements.a("byte", arrayDeque));
            }
            if (!arrayDeque2.isEmpty()) {
                this.f30942t.put("memory_native_footprint", new io.sentry.profilemeasurements.a("byte", arrayDeque2));
            }
        }
    }

    public synchronized void a(n0 n0Var) {
        this.f30929g.getExecutorService().submit((Runnable) new x(this, n0Var));
    }

    public synchronized z1 b(n0 n0Var, List<x1> list) {
        try {
            return (z1) this.f30929g.getExecutorService().submit(new y(this, n0Var, list)).get();
        } catch (ExecutionException e10) {
            this.f30929g.getLogger().b(SentryLevel.ERROR, "Error finishing profiling: ", e10);
            return null;
        } catch (InterruptedException e11) {
            this.f30929g.getLogger().b(SentryLevel.ERROR, "Error finishing profiling: ", e11);
            return null;
        }
    }

    public b0(Context context, SentryAndroidOptions sentryAndroidOptions, i0 i0Var, p pVar, g0 g0Var) {
        this.f30924b = null;
        this.f30925c = null;
        this.f30926d = null;
        this.f30927e = null;
        this.f30932j = 0;
        this.f30933k = 0;
        this.f30934l = false;
        this.f30935m = 0;
        this.f30939q = new ArrayDeque<>();
        this.f30940r = new ArrayDeque<>();
        this.f30941s = new ArrayDeque<>();
        this.f30942t = new HashMap();
        this.f30928f = (Context) l.c(context, "The application context is required");
        this.f30929g = (SentryAndroidOptions) l.c(sentryAndroidOptions, "SentryAndroidOptions is required");
        this.f30930h = (g0) l.c(g0Var, "Hub is required");
        this.f30937o = (p) l.c(pVar, "SentryFrameMetricsCollector is required");
        this.f30931i = (i0) l.c(i0Var, "The BuildInfoProvider is required.");
    }
}
