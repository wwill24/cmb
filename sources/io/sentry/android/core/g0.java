package io.sentry.android.core;

import android.os.SystemClock;
import io.sentry.g;
import io.sentry.u2;
import io.sentry.v3;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public final class g0 {

    /* renamed from: e  reason: collision with root package name */
    private static g0 f30980e = new g0();

    /* renamed from: a  reason: collision with root package name */
    private Long f30981a;

    /* renamed from: b  reason: collision with root package name */
    private Long f30982b;

    /* renamed from: c  reason: collision with root package name */
    private Boolean f30983c = null;

    /* renamed from: d  reason: collision with root package name */
    private u2 f30984d;

    private g0() {
    }

    public static g0 e() {
        return f30980e;
    }

    public u2 a() {
        Long b10;
        u2 d10 = d();
        if (d10 == null || (b10 = b()) == null) {
            return null;
        }
        return new v3(d10.h() + g.h(b10.longValue()));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002a, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.lang.Long b() {
        /*
            r6 = this;
            monitor-enter(r6)
            java.lang.Long r0 = r6.f30981a     // Catch:{ all -> 0x002b }
            r1 = 0
            if (r0 == 0) goto L_0x0029
            java.lang.Long r0 = r6.f30982b     // Catch:{ all -> 0x002b }
            if (r0 == 0) goto L_0x0029
            java.lang.Boolean r2 = r6.f30983c     // Catch:{ all -> 0x002b }
            if (r2 != 0) goto L_0x000f
            goto L_0x0029
        L_0x000f:
            long r2 = r0.longValue()     // Catch:{ all -> 0x002b }
            java.lang.Long r0 = r6.f30981a     // Catch:{ all -> 0x002b }
            long r4 = r0.longValue()     // Catch:{ all -> 0x002b }
            long r2 = r2 - r4
            r4 = 60000(0xea60, double:2.9644E-319)
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 < 0) goto L_0x0023
            monitor-exit(r6)
            return r1
        L_0x0023:
            java.lang.Long r0 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x002b }
            monitor-exit(r6)
            return r0
        L_0x0029:
            monitor-exit(r6)
            return r1
        L_0x002b:
            r0 = move-exception
            monitor-exit(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.core.g0.b():java.lang.Long");
    }

    public Long c() {
        return this.f30981a;
    }

    public u2 d() {
        return this.f30984d;
    }

    public Boolean f() {
        return this.f30983c;
    }

    /* access modifiers changed from: package-private */
    public synchronized void g() {
        h(SystemClock.uptimeMillis());
    }

    /* access modifiers changed from: package-private */
    public void h(long j10) {
        this.f30982b = Long.valueOf(j10);
    }

    /* access modifiers changed from: package-private */
    public synchronized void i(long j10, u2 u2Var) {
        if (this.f30984d == null || this.f30981a == null) {
            this.f30984d = u2Var;
            this.f30981a = Long.valueOf(j10);
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void j(boolean z10) {
        if (this.f30983c == null) {
            this.f30983c = Boolean.valueOf(z10);
        }
    }
}
