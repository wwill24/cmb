package io.sentry.android.core;

import io.sentry.Integration;
import io.sentry.SentryLevel;
import io.sentry.g2;
import io.sentry.j2;
import io.sentry.util.l;

final class SendCachedEnvelopeIntegration implements Integration {

    /* renamed from: a  reason: collision with root package name */
    private final j2 f30890a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f30891b;

    public SendCachedEnvelopeIntegration(j2 j2Var, boolean z10) {
        this.f30890a = (j2) l.c(j2Var, "SendFireAndForgetFactory is required");
        this.f30891b = z10;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void e(g2 g2Var, SentryAndroidOptions sentryAndroidOptions) {
        try {
            g2Var.a();
        } catch (Throwable th2) {
            sentryAndroidOptions.getLogger().b(SentryLevel.ERROR, "Failed trying to send cached events.", th2);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:15|16|17|18|19) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0073 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(io.sentry.g0 r6, io.sentry.SentryOptions r7) {
        /*
            r5 = this;
            java.lang.String r0 = "Hub is required"
            io.sentry.util.l.c(r6, r0)
            boolean r0 = r7 instanceof io.sentry.android.core.SentryAndroidOptions
            if (r0 == 0) goto L_0x000d
            r0 = r7
            io.sentry.android.core.SentryAndroidOptions r0 = (io.sentry.android.core.SentryAndroidOptions) r0
            goto L_0x000e
        L_0x000d:
            r0 = 0
        L_0x000e:
            java.lang.String r1 = "SentryAndroidOptions is required"
            java.lang.Object r0 = io.sentry.util.l.c(r0, r1)
            io.sentry.android.core.SentryAndroidOptions r0 = (io.sentry.android.core.SentryAndroidOptions) r0
            java.lang.String r1 = r7.getCacheDirPath()
            io.sentry.j2 r2 = r5.f30890a
            io.sentry.h0 r3 = r7.getLogger()
            boolean r1 = r2.e(r1, r3)
            r2 = 0
            if (r1 != 0) goto L_0x0035
            io.sentry.h0 r6 = r7.getLogger()
            io.sentry.SentryLevel r7 = io.sentry.SentryLevel.ERROR
            java.lang.Object[] r0 = new java.lang.Object[r2]
            java.lang.String r1 = "No cache dir path is defined in options."
            r6.c(r7, r1, r0)
            return
        L_0x0035:
            io.sentry.j2 r7 = r5.f30890a
            io.sentry.g2 r6 = r7.d(r6, r0)
            if (r6 != 0) goto L_0x004b
            io.sentry.h0 r6 = r0.getLogger()
            io.sentry.SentryLevel r7 = io.sentry.SentryLevel.ERROR
            java.lang.Object[] r0 = new java.lang.Object[r2]
            java.lang.String r1 = "SendFireAndForget factory is null."
            r6.c(r7, r1, r0)
            return
        L_0x004b:
            io.sentry.k0 r7 = r0.getExecutorService()     // Catch:{ all -> 0x008e }
            io.sentry.android.core.a1 r1 = new io.sentry.android.core.a1     // Catch:{ all -> 0x008e }
            r1.<init>(r6, r0)     // Catch:{ all -> 0x008e }
            java.util.concurrent.Future r6 = r7.submit((java.lang.Runnable) r1)     // Catch:{ all -> 0x008e }
            boolean r7 = r5.f30891b     // Catch:{ all -> 0x008e }
            if (r7 == 0) goto L_0x0080
            io.sentry.h0 r7 = r0.getLogger()     // Catch:{ all -> 0x008e }
            io.sentry.SentryLevel r1 = io.sentry.SentryLevel.DEBUG     // Catch:{ all -> 0x008e }
            java.lang.String r3 = "Startup Crash marker exists, blocking flush."
            java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch:{ all -> 0x008e }
            r7.c(r1, r3, r4)     // Catch:{ all -> 0x008e }
            long r3 = r0.getStartupCrashFlushTimeoutMillis()     // Catch:{ TimeoutException -> 0x0073 }
            java.util.concurrent.TimeUnit r7 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ TimeoutException -> 0x0073 }
            r6.get(r3, r7)     // Catch:{ TimeoutException -> 0x0073 }
            goto L_0x0080
        L_0x0073:
            io.sentry.h0 r6 = r0.getLogger()     // Catch:{ all -> 0x008e }
            io.sentry.SentryLevel r7 = io.sentry.SentryLevel.DEBUG     // Catch:{ all -> 0x008e }
            java.lang.String r1 = "Synchronous send timed out, continuing in the background."
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch:{ all -> 0x008e }
            r6.c(r7, r1, r3)     // Catch:{ all -> 0x008e }
        L_0x0080:
            io.sentry.h0 r6 = r0.getLogger()     // Catch:{ all -> 0x008e }
            io.sentry.SentryLevel r7 = io.sentry.SentryLevel.DEBUG     // Catch:{ all -> 0x008e }
            java.lang.String r1 = "SendCachedEnvelopeIntegration installed."
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x008e }
            r6.c(r7, r1, r2)     // Catch:{ all -> 0x008e }
            goto L_0x009a
        L_0x008e:
            r6 = move-exception
            io.sentry.h0 r7 = r0.getLogger()
            io.sentry.SentryLevel r0 = io.sentry.SentryLevel.ERROR
            java.lang.String r1 = "Failed to call the executor. Cached events will not be sent"
            r7.b(r0, r1, r6)
        L_0x009a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.core.SendCachedEnvelopeIntegration.a(io.sentry.g0, io.sentry.SentryOptions):void");
    }
}
