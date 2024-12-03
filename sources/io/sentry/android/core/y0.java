package io.sentry.android.core;

import io.sentry.p3;
import io.sentry.t;
import io.sentry.util.l;
import io.sentry.w;

final class y0 implements t {

    /* renamed from: a  reason: collision with root package name */
    private boolean f31114a = false;

    /* renamed from: b  reason: collision with root package name */
    private final g f31115b;

    /* renamed from: c  reason: collision with root package name */
    private final SentryAndroidOptions f31116c;

    y0(SentryAndroidOptions sentryAndroidOptions, g gVar) {
        this.f31116c = (SentryAndroidOptions) l.c(sentryAndroidOptions, "SentryAndroidOptions is required");
        this.f31115b = (g) l.c(gVar, "ActivityFramesTracker is required");
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x000a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean c(java.util.List<io.sentry.protocol.r> r4) {
        /*
            r3 = this;
            java.util.Iterator r4 = r4.iterator()
        L_0x0004:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L_0x002a
            java.lang.Object r0 = r4.next()
            io.sentry.protocol.r r0 = (io.sentry.protocol.r) r0
            java.lang.String r1 = r0.b()
            java.lang.String r2 = "app.start.cold"
            boolean r1 = r1.contentEquals(r2)
            if (r1 != 0) goto L_0x0028
            java.lang.String r0 = r0.b()
            java.lang.String r1 = "app.start.warm"
            boolean r0 = r0.contentEquals(r1)
            if (r0 == 0) goto L_0x0004
        L_0x0028:
            r4 = 1
            return r4
        L_0x002a:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.core.y0.c(java.util.List):boolean");
    }

    public p3 a(p3 p3Var, w wVar) {
        return p3Var;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0080, code lost:
        return r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized io.sentry.protocol.v b(io.sentry.protocol.v r4, io.sentry.w r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            io.sentry.android.core.SentryAndroidOptions r5 = r3.f31116c     // Catch:{ all -> 0x0081 }
            boolean r5 = r5.isTracingEnabled()     // Catch:{ all -> 0x0081 }
            if (r5 != 0) goto L_0x000b
            monitor-exit(r3)
            return r4
        L_0x000b:
            boolean r5 = r3.f31114a     // Catch:{ all -> 0x0081 }
            if (r5 != 0) goto L_0x0054
            java.util.List r5 = r4.o0()     // Catch:{ all -> 0x0081 }
            boolean r5 = r3.c(r5)     // Catch:{ all -> 0x0081 }
            if (r5 == 0) goto L_0x0054
            io.sentry.android.core.g0 r5 = io.sentry.android.core.g0.e()     // Catch:{ all -> 0x0081 }
            java.lang.Long r5 = r5.b()     // Catch:{ all -> 0x0081 }
            if (r5 == 0) goto L_0x0054
            io.sentry.protocol.f r0 = new io.sentry.protocol.f     // Catch:{ all -> 0x0081 }
            long r1 = r5.longValue()     // Catch:{ all -> 0x0081 }
            float r5 = (float) r1     // Catch:{ all -> 0x0081 }
            java.lang.Float r5 = java.lang.Float.valueOf(r5)     // Catch:{ all -> 0x0081 }
            io.sentry.MeasurementUnit$Duration r1 = io.sentry.MeasurementUnit.Duration.MILLISECOND     // Catch:{ all -> 0x0081 }
            java.lang.String r1 = r1.apiName()     // Catch:{ all -> 0x0081 }
            r0.<init>(r5, r1)     // Catch:{ all -> 0x0081 }
            io.sentry.android.core.g0 r5 = io.sentry.android.core.g0.e()     // Catch:{ all -> 0x0081 }
            java.lang.Boolean r5 = r5.f()     // Catch:{ all -> 0x0081 }
            boolean r5 = r5.booleanValue()     // Catch:{ all -> 0x0081 }
            if (r5 == 0) goto L_0x0048
            java.lang.String r5 = "app_start_cold"
            goto L_0x004a
        L_0x0048:
            java.lang.String r5 = "app_start_warm"
        L_0x004a:
            java.util.Map r1 = r4.m0()     // Catch:{ all -> 0x0081 }
            r1.put(r5, r0)     // Catch:{ all -> 0x0081 }
            r5 = 1
            r3.f31114a = r5     // Catch:{ all -> 0x0081 }
        L_0x0054:
            io.sentry.protocol.o r5 = r4.G()     // Catch:{ all -> 0x0081 }
            io.sentry.protocol.Contexts r0 = r4.C()     // Catch:{ all -> 0x0081 }
            io.sentry.j4 r0 = r0.e()     // Catch:{ all -> 0x0081 }
            if (r5 == 0) goto L_0x007f
            if (r0 == 0) goto L_0x007f
            java.lang.String r0 = r0.b()     // Catch:{ all -> 0x0081 }
            java.lang.String r1 = "ui.load"
            boolean r0 = r0.contentEquals(r1)     // Catch:{ all -> 0x0081 }
            if (r0 == 0) goto L_0x007f
            io.sentry.android.core.g r0 = r3.f31115b     // Catch:{ all -> 0x0081 }
            java.util.Map r5 = r0.q(r5)     // Catch:{ all -> 0x0081 }
            if (r5 == 0) goto L_0x007f
            java.util.Map r0 = r4.m0()     // Catch:{ all -> 0x0081 }
            r0.putAll(r5)     // Catch:{ all -> 0x0081 }
        L_0x007f:
            monitor-exit(r3)
            return r4
        L_0x0081:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.core.y0.b(io.sentry.protocol.v, io.sentry.w):io.sentry.protocol.v");
    }
}
