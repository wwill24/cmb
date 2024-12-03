package io.sentry;

import io.sentry.util.l;
import java.security.SecureRandom;

final class q4 {

    /* renamed from: c  reason: collision with root package name */
    private static final Double f31602c = Double.valueOf(1.0d);

    /* renamed from: a  reason: collision with root package name */
    private final SentryOptions f31603a;

    /* renamed from: b  reason: collision with root package name */
    private final SecureRandom f31604b;

    public q4(SentryOptions sentryOptions) {
        this((SentryOptions) l.c(sentryOptions, "options are required"), new SecureRandom());
    }

    private boolean b(Double d10) {
        return d10.doubleValue() >= this.f31604b.nextDouble();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0030  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x004d A[SYNTHETIC, Splitter:B:19:0x004d] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0081 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0082  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public io.sentry.r4 a(io.sentry.d2 r8) {
        /*
            r7 = this;
            io.sentry.s4 r0 = r8.a()
            io.sentry.r4 r0 = r0.f()
            if (r0 == 0) goto L_0x000b
            return r0
        L_0x000b:
            io.sentry.SentryOptions r0 = r7.f31603a
            io.sentry.SentryOptions$d r0 = r0.getProfilesSampler()
            r1 = 0
            if (r0 == 0) goto L_0x002d
            io.sentry.SentryOptions r0 = r7.f31603a     // Catch:{ all -> 0x001f }
            io.sentry.SentryOptions$d r0 = r0.getProfilesSampler()     // Catch:{ all -> 0x001f }
            java.lang.Double r0 = r0.a(r8)     // Catch:{ all -> 0x001f }
            goto L_0x002e
        L_0x001f:
            r0 = move-exception
            io.sentry.SentryOptions r2 = r7.f31603a
            io.sentry.h0 r2 = r2.getLogger()
            io.sentry.SentryLevel r3 = io.sentry.SentryLevel.ERROR
            java.lang.String r4 = "Error in the 'ProfilesSamplerCallback' callback."
            r2.b(r3, r4, r0)
        L_0x002d:
            r0 = r1
        L_0x002e:
            if (r0 != 0) goto L_0x0036
            io.sentry.SentryOptions r0 = r7.f31603a
            java.lang.Double r0 = r0.getProfilesSampleRate()
        L_0x0036:
            if (r0 == 0) goto L_0x0040
            boolean r2 = r7.b(r0)
            if (r2 == 0) goto L_0x0040
            r2 = 1
            goto L_0x0041
        L_0x0040:
            r2 = 0
        L_0x0041:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            io.sentry.SentryOptions r3 = r7.f31603a
            io.sentry.SentryOptions$f r3 = r3.getTracesSampler()
            if (r3 == 0) goto L_0x0077
            io.sentry.SentryOptions r3 = r7.f31603a     // Catch:{ all -> 0x0058 }
            io.sentry.SentryOptions$f r3 = r3.getTracesSampler()     // Catch:{ all -> 0x0058 }
            java.lang.Double r3 = r3.a(r8)     // Catch:{ all -> 0x0058 }
            goto L_0x0067
        L_0x0058:
            r3 = move-exception
            io.sentry.SentryOptions r4 = r7.f31603a
            io.sentry.h0 r4 = r4.getLogger()
            io.sentry.SentryLevel r5 = io.sentry.SentryLevel.ERROR
            java.lang.String r6 = "Error in the 'TracesSamplerCallback' callback."
            r4.b(r5, r6, r3)
            r3 = r1
        L_0x0067:
            if (r3 == 0) goto L_0x0077
            io.sentry.r4 r8 = new io.sentry.r4
            boolean r1 = r7.b(r3)
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            r8.<init>(r1, r3, r2, r0)
            return r8
        L_0x0077:
            io.sentry.s4 r8 = r8.a()
            io.sentry.r4 r8 = r8.r()
            if (r8 == 0) goto L_0x0082
            return r8
        L_0x0082:
            io.sentry.SentryOptions r8 = r7.f31603a
            java.lang.Double r8 = r8.getTracesSampleRate()
            io.sentry.SentryOptions r3 = r7.f31603a
            java.lang.Boolean r3 = r3.getEnableTracing()
            java.lang.Boolean r4 = java.lang.Boolean.TRUE
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x0099
            java.lang.Double r3 = f31602c
            goto L_0x009a
        L_0x0099:
            r3 = r1
        L_0x009a:
            if (r8 != 0) goto L_0x009d
            r8 = r3
        L_0x009d:
            if (r8 == 0) goto L_0x00ad
            io.sentry.r4 r1 = new io.sentry.r4
            boolean r3 = r7.b(r8)
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            r1.<init>(r3, r8, r2, r0)
            return r1
        L_0x00ad:
            io.sentry.r4 r8 = new io.sentry.r4
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            r8.<init>(r0, r1, r0, r1)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.q4.a(io.sentry.d2):io.sentry.r4");
    }

    q4(SentryOptions sentryOptions, SecureRandom secureRandom) {
        this.f31603a = sentryOptions;
        this.f31604b = secureRandom;
    }
}
