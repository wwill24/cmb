package io.sentry.android.core;

import android.app.Activity;
import android.util.SparseIntArray;
import androidx.core.app.FrameMetricsAggregator;
import io.sentry.SentryLevel;
import io.sentry.h0;
import io.sentry.protocol.f;
import io.sentry.protocol.o;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.VisibleForTesting;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    private FrameMetricsAggregator f30972a;

    /* renamed from: b  reason: collision with root package name */
    private final SentryAndroidOptions f30973b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<o, Map<String, f>> f30974c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<Activity, b> f30975d;

    /* renamed from: e  reason: collision with root package name */
    private final u0 f30976e;

    private static final class b {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final int f30977a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final int f30978b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final int f30979c;

        private b(int i10, int i11, int i12) {
            this.f30977a = i10;
            this.f30978b = i11;
            this.f30979c = i12;
        }
    }

    public g(t0 t0Var, SentryAndroidOptions sentryAndroidOptions, u0 u0Var) {
        this.f30972a = null;
        this.f30974c = new ConcurrentHashMap();
        this.f30975d = new WeakHashMap();
        if (t0Var.a("androidx.core.app.FrameMetricsAggregator", sentryAndroidOptions.getLogger())) {
            this.f30972a = new FrameMetricsAggregator();
        }
        this.f30973b = sentryAndroidOptions;
        this.f30976e = u0Var;
    }

    private b f() {
        FrameMetricsAggregator frameMetricsAggregator;
        int i10;
        int i11;
        SparseIntArray sparseIntArray;
        if (!h() || (frameMetricsAggregator = this.f30972a) == null) {
            return null;
        }
        SparseIntArray[] b10 = frameMetricsAggregator.b();
        int i12 = 0;
        if (b10 == null || b10.length <= 0 || (sparseIntArray = b10[0]) == null) {
            i11 = 0;
            i10 = 0;
        } else {
            int i13 = 0;
            i11 = 0;
            i10 = 0;
            while (i12 < sparseIntArray.size()) {
                int keyAt = sparseIntArray.keyAt(i12);
                int valueAt = sparseIntArray.valueAt(i12);
                i13 += valueAt;
                if (keyAt > 700) {
                    i10 += valueAt;
                } else if (keyAt > 16) {
                    i11 += valueAt;
                }
                i12++;
            }
            i12 = i13;
        }
        return new b(i12, i11, i10);
    }

    private b g(Activity activity) {
        b f10;
        b remove = this.f30975d.remove(activity);
        if (remove == null || (f10 = f()) == null) {
            return null;
        }
        return new b(f10.f30977a - remove.f30977a, f10.f30978b - remove.f30978b, f10.f30979c - remove.f30979c);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void i(Activity activity) {
        this.f30972a.a(activity);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void j(Runnable runnable, String str) {
        try {
            runnable.run();
        } catch (Throwable unused) {
            if (str != null) {
                h0 logger = this.f30973b.getLogger();
                SentryLevel sentryLevel = SentryLevel.WARNING;
                logger.c(sentryLevel, "Failed to execute " + str, new Object[0]);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void k(Activity activity) {
        this.f30972a.c(activity);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l() {
        this.f30972a.e();
    }

    private void m(Runnable runnable, String str) {
        try {
            if (io.sentry.android.core.internal.util.b.e().a()) {
                runnable.run();
            } else {
                this.f30976e.b(new e(this, runnable, str));
            }
        } catch (Throwable unused) {
            if (str != null) {
                h0 logger = this.f30973b.getLogger();
                SentryLevel sentryLevel = SentryLevel.WARNING;
                logger.c(sentryLevel, "Failed to execute " + str, new Object[0]);
            }
        }
    }

    private void o(Activity activity) {
        b f10 = f();
        if (f10 != null) {
            this.f30975d.put(activity, f10);
        }
    }

    public synchronized void e(Activity activity) {
        if (h()) {
            m(new c(this, activity), "FrameMetricsAggregator.add");
            o(activity);
        }
    }

    @VisibleForTesting
    public boolean h() {
        return this.f30972a != null && this.f30973b.isEnableFramesTracking();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0074, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void n(android.app.Activity r5, io.sentry.protocol.o r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            boolean r0 = r4.h()     // Catch:{ all -> 0x0075 }
            if (r0 != 0) goto L_0x0009
            monitor-exit(r4)
            return
        L_0x0009:
            io.sentry.android.core.f r0 = new io.sentry.android.core.f     // Catch:{ all -> 0x0075 }
            r0.<init>(r4, r5)     // Catch:{ all -> 0x0075 }
            r1 = 0
            r4.m(r0, r1)     // Catch:{ all -> 0x0075 }
            io.sentry.android.core.g$b r5 = r4.g(r5)     // Catch:{ all -> 0x0075 }
            if (r5 == 0) goto L_0x0073
            int r0 = r5.f30977a     // Catch:{ all -> 0x0075 }
            if (r0 != 0) goto L_0x002b
            int r0 = r5.f30978b     // Catch:{ all -> 0x0075 }
            if (r0 != 0) goto L_0x002b
            int r0 = r5.f30979c     // Catch:{ all -> 0x0075 }
            if (r0 != 0) goto L_0x002b
            goto L_0x0073
        L_0x002b:
            io.sentry.protocol.f r0 = new io.sentry.protocol.f     // Catch:{ all -> 0x0075 }
            int r1 = r5.f30977a     // Catch:{ all -> 0x0075 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x0075 }
            java.lang.String r2 = "none"
            r0.<init>(r1, r2)     // Catch:{ all -> 0x0075 }
            io.sentry.protocol.f r1 = new io.sentry.protocol.f     // Catch:{ all -> 0x0075 }
            int r2 = r5.f30978b     // Catch:{ all -> 0x0075 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0075 }
            java.lang.String r3 = "none"
            r1.<init>(r2, r3)     // Catch:{ all -> 0x0075 }
            io.sentry.protocol.f r2 = new io.sentry.protocol.f     // Catch:{ all -> 0x0075 }
            int r5 = r5.f30979c     // Catch:{ all -> 0x0075 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0075 }
            java.lang.String r3 = "none"
            r2.<init>(r5, r3)     // Catch:{ all -> 0x0075 }
            java.util.HashMap r5 = new java.util.HashMap     // Catch:{ all -> 0x0075 }
            r5.<init>()     // Catch:{ all -> 0x0075 }
            java.lang.String r3 = "frames_total"
            r5.put(r3, r0)     // Catch:{ all -> 0x0075 }
            java.lang.String r0 = "frames_slow"
            r5.put(r0, r1)     // Catch:{ all -> 0x0075 }
            java.lang.String r0 = "frames_frozen"
            r5.put(r0, r2)     // Catch:{ all -> 0x0075 }
            java.util.Map<io.sentry.protocol.o, java.util.Map<java.lang.String, io.sentry.protocol.f>> r0 = r4.f30974c     // Catch:{ all -> 0x0075 }
            r0.put(r6, r5)     // Catch:{ all -> 0x0075 }
            monitor-exit(r4)
            return
        L_0x0073:
            monitor-exit(r4)
            return
        L_0x0075:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.core.g.n(android.app.Activity, io.sentry.protocol.o):void");
    }

    public synchronized void p() {
        if (h()) {
            m(new d(this), "FrameMetricsAggregator.stop");
            this.f30972a.d();
        }
        this.f30974c.clear();
    }

    public synchronized Map<String, f> q(o oVar) {
        if (!h()) {
            return null;
        }
        Map<String, f> map = this.f30974c.get(oVar);
        this.f30974c.remove(oVar);
        return map;
    }

    public g(t0 t0Var, SentryAndroidOptions sentryAndroidOptions) {
        this(t0Var, sentryAndroidOptions, new u0());
    }
}
