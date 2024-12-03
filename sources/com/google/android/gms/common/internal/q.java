package com.google.android.gms.common.internal;

import androidx.annotation.NonNull;

public final class q {

    /* renamed from: b  reason: collision with root package name */
    private static q f39041b;

    /* renamed from: c  reason: collision with root package name */
    private static final RootTelemetryConfiguration f39042c = new RootTelemetryConfiguration(0, false, false, 0, 0);

    /* renamed from: a  reason: collision with root package name */
    private RootTelemetryConfiguration f39043a;

    private q() {
    }

    @NonNull
    public static synchronized q b() {
        q qVar;
        synchronized (q.class) {
            if (f39041b == null) {
                f39041b = new q();
            }
            qVar = f39041b;
        }
        return qVar;
    }

    public RootTelemetryConfiguration a() {
        return this.f39043a;
    }

    public final synchronized void c(RootTelemetryConfiguration rootTelemetryConfiguration) {
        if (rootTelemetryConfiguration == null) {
            this.f39043a = f39042c;
            return;
        }
        RootTelemetryConfiguration rootTelemetryConfiguration2 = this.f39043a;
        if (rootTelemetryConfiguration2 == null || rootTelemetryConfiguration2.i0() < rootTelemetryConfiguration.i0()) {
            this.f39043a = rootTelemetryConfiguration;
        }
    }
}
